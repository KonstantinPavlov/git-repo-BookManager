package ru.konstpavlov.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Konstantin on 17.09.2016.
 *
 *
 *
 */
public class DAO {


    public static Connection getConnection () throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/bookmanager","root","root");
    }

    public static List<Book> getData() throws SQLException, ClassNotFoundException {


        try (
                Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT id,name,description,author FROM books");
                ResultSet resultSet = preparedStatement.executeQuery();)
        {
            ArrayList<Book> books = new ArrayList<>();
            while (resultSet.next())
            {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String desc = resultSet.getString("description");
                String author = resultSet.getString("author");
                books.add(new Book(id,name,desc,author));
            }
            return books;
        }
    }

    public static void addBook(String name, String description, String author) throws SQLException, ClassNotFoundException {

        try(Connection connection = getConnection();
            PreparedStatement preparedStatement= connection.prepareStatement("INSERT INTO  books (name,description,author) VALUES (?,?,?)");)
        {
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,description);
            preparedStatement.setString(3,author);
            preparedStatement.executeUpdate();}

    }

    public static void deleteBook(int id) throws SQLException, ClassNotFoundException {

        try(Connection connection = getConnection();
            PreparedStatement preparedStatement= connection.prepareStatement("DELETE FROM books WHERE id=?");)
        {

            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();}

    }

    public static Object getBook(int id) throws SQLException, ClassNotFoundException {

        try (
                Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT name,description,author FROM books WHERE id=?");
                )
        {
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Book book=null;
            while (resultSet.next())
            {

                String name = resultSet.getString("name");
                String desc = resultSet.getString("description");
                String author = resultSet.getString("author");
                book = new Book(id,name,desc,author);
            }
            return book;
        }

    }

    public static void updateBook(int id,String name, String description, String author) throws SQLException, ClassNotFoundException {

        try(Connection connection = getConnection();
            PreparedStatement preparedStatement= connection.prepareStatement("UPDATE books SET name = ?,description=?, author=?  WHERE id=?");)
        {
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,description);
            preparedStatement.setString(3,author);
            preparedStatement.setInt(4,id);
            preparedStatement.executeUpdate();}

    }

    public static void addImagetoBook(int id, String appPath, String fileName) throws SQLException, ClassNotFoundException, IOException {

        try(Connection connection = getConnection();
            PreparedStatement preparedStatement= connection.prepareStatement("INSERT INTO images (name,image,id) VALUES (?,?,?)");
            )
        {
            File file = new File(appPath + File.separator+fileName);
            FileInputStream fileInputStream = new FileInputStream(file);
            preparedStatement.setString(1,fileName);
            preparedStatement.setBinaryStream(2,fileInputStream,(int) file.length());
            preparedStatement.setInt(3,id);
            preparedStatement.executeUpdate();
            fileInputStream.close();
            file.delete();
            }

    }


    public static InputStream getImage(int id) throws SQLException, ClassNotFoundException {
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement= connection.prepareStatement("SELECT  image FROM images WHERE id=?");
        ) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
            {
                return resultSet.getBinaryStream(1);
            }
        }

        return null;
    }
}
