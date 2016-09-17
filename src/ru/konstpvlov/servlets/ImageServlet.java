package ru.konstpvlov.servlets;

import ru.konstpvlov.model.DAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;

/**
 * Created by Konstantin on 17.09.2016.
 */
@WebServlet(name = "ImageServlet")
public class ImageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            int id = Integer.parseInt(request.getParameter("id"));
            response.setContentType("image/gif");
        InputStream inputStream = null;
        try {
            inputStream = DAO.getImage(id);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        byte[] bytes = new byte[5000];
        int read = 0;

        OutputStream outputStream = response.getOutputStream();

        while ((read = inputStream.read(bytes))!= -1)
        {
            outputStream.write(bytes,0,read);
        }
        outputStream.flush();
        outputStream.close();
    }
}
