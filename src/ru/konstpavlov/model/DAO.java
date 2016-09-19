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
 * Основной класс связи с базой данных и преборазования данных в класс Book
 */
public class DAO {

    // перменная для хранения пути где будут хранится файлы
    private static final String SAVE_DIR = "uploadFiles";

    // геттер для пути хранения файлов
    public static String getSaveDir() {
        return SAVE_DIR;
    }

    public static Connection getConnection () throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/bookmanager","root","root");
    }

    // метод возвращающий коллекцию книг с отборами -
    public static List<Book> getData(String searchString,String whatSearch) throws SQLException, ClassNotFoundException {

        String prepStatText="";
        boolean hasParamets=false;

        // проверяем наличие параметра - поиска
        if (searchString ==null )
        {
             prepStatText = "SELECT id,name,description,author FROM books";
        }
        else
        {
            if (whatSearch.equals("author"))
            {prepStatText = "SELECT id,name,description,author FROM books WHERE author LIKE ?";}
            else
            {prepStatText = "SELECT id,name,description,author FROM books WHERE name LIKE ?";}
            hasParamets=true;
        }

        //  конструкция try with resources - автоматически закрывает коннект к базе после блок с фигурными скобками
        try (
                Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(prepStatText);
                )
        {
            if (hasParamets)
            {
                preparedStatement.setString(1,"%"+searchString+"%"); // устанавливаем праметр в обрамлении % - специфика запроса на SQl для ключегово слова LIKE - для поиска всевозможных вхождений стркои поиска
            }
            ResultSet resultSet = preparedStatement.executeQuery();
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

    // метод по давблению книги в базу , не проверяет наличие такой книги
    public static void addBook(String name, String description, String author) throws SQLException, ClassNotFoundException {

        try(Connection connection = getConnection();
            PreparedStatement preparedStatement= connection.prepareStatement("INSERT INTO  books (name,description,author) VALUES (?,?,?)");)
        {
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,description);
            preparedStatement.setString(3,author);
            preparedStatement.executeUpdate();}

    }

    // метод по удалению записи из базы по id
    public static void deleteBook(int id) throws SQLException, ClassNotFoundException {

        try(Connection connection = getConnection();
            PreparedStatement preparedStatement= connection.prepareStatement("DELETE FROM books WHERE id=?");)
        {

            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();}

    }

    // метод для получения данных по конкретной книге с левым соединением к таблице хранящей информацию по привязанным картинкам
    public static Object getBook(int id) throws SQLException, ClassNotFoundException {

        try (
                Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT books.name,books.description,books.author ,images.image FROM books LEFT OUTER JOIN  images ON books.id = images.book_id WHERE books.id=?");
                )
        {
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Book book=null;
            while (resultSet.next())
            {

                String name = resultSet.getString("books.name");
                String desc = resultSet.getString("books.description");
                String author = resultSet.getString("books.author");
                String imageName = resultSet.getString("images.image");

                book = new Book(id,name,desc,author);
                book.setImagePath(imageName);
            }
            return book;
        }

    }
    // метод по обновлению данных по книге в базе
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
    // метод по добавлению картинки в связанную таблицу - для хранения имен картинок
    public static void addImagetoBook(int id, String appPath, String fileName) throws SQLException, ClassNotFoundException, IOException {

        try(Connection connection = getConnection();
            PreparedStatement preparedStatement= connection.prepareStatement("INSERT INTO images (image,book_id) VALUES (?,?)");
            )
        {
            preparedStatement.setString(1,fileName);
            preparedStatement.setInt(2,id);
            preparedStatement.executeUpdate();

            }

    }

}
