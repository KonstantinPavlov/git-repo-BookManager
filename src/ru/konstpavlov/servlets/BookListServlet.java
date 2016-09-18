package ru.konstpavlov.servlets;

import ru.konstpavlov.model.DAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

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

        request.setCharacterEncoding("UTF-8");

        String name = request.getParameter("searchValue");
        String whatSearch =request.getParameter("search");
        request.setAttribute("searchValue",name);
        request.setAttribute("whatSearch",whatSearch);
        try {
            request.setAttribute("books", DAO.getData(name,whatSearch));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("WEB-INF/BookList.jsp").forward(request,response);
    }
}
