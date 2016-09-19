package ru.konstpavlov.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Konstantin on 17.09.2016.
 *
 * Сервлет для вызова jsp страницы по добавлению данных по новой книге
 *
 */
@WebServlet(name = "addNewBookServlet", urlPatterns = "/addNew")
public class addNewBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("WEB-INF/addNew.jsp").forward(request,response);
    }
}
