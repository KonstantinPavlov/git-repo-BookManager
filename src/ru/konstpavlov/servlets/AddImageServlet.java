package ru.konstpavlov.servlets;

import ru.konstpavlov.model.Book;
import ru.konstpavlov.model.DAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.UUID;

/**
 * Created by Konstantin on 17.09.2016.
 *
 *
 * Сервлет добавляющий данные по картинкам в базу
 *
 */
@WebServlet(name = "AddImageServlet" ,urlPatterns = "/addimage")
@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
        maxFileSize=1024*1024*10,      // 10MB
        maxRequestSize=1024*1024*50)   // 50MB
public class AddImageServlet extends HttpServlet {



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String appPath = request.getServletContext().getRealPath("");
        // создаем путь, где будем хранить файлы
        String savePath = appPath + File.separator + DAO.getSaveDir();

        // создаем папку, если ее нет
        File fileSaveDir = new File(savePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdir();
        }
        // сохраняем файл
        String fileName="";
        for (Part part : request.getParts()) {
            fileName = extractFileName(part);
            // генерируем уникальное имя
            UUID uniqFileName = UUID.randomUUID();
            // Определеим расширение файла, экранируем точку
            String[] vals = fileName.split("\\.");
            String uniqFile = uniqFileName.toString().replaceAll("-","") +"."+vals[vals.length-1];
            fileName = uniqFile;
            part.write(savePath + File.separator + fileName);
        }

        int id = Integer.parseInt(request.getParameter("id"));
        try {
            DAO.addImagetoBook(id,savePath,fileName);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/book?id="+id);

    }

    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length()-1);
            }
        }
        return "";
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
