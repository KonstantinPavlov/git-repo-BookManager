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
@WebServlet(name = "BookListServlet",urlPatterns = "/booklist")
public class BookListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("books", DAO.getData());
        request.getRequestDispatcher("WEB-INF/BookList.jsp").forward(request,response);
    }
}
