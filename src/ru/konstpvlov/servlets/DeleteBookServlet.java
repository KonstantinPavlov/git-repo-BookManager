package ru.konstpvlov.servlets;

import ru.konstpvlov.model.DAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Konstantin on 17.09.2016.
 *
 *
 *
 */
@WebServlet(name = "DeleteBookServlet",urlPatterns = "/delete")
public class DeleteBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        DAO.deleteBook(id);
        response.sendRedirect("/booklist");
    }
}
