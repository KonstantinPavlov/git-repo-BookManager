package ru.konstpvlov.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Konstantin on 17.09.2016.
 *
 *
 *
 */
public class DAO {

   static List<Book> data = new ArrayList<>();

    static {
        data.add(new Book(1,"Head First Java","Изучаем Java Год: 2012","Кэти Сьерра, Берт Бейтс"));
        data.add(new Book(2,"Test Driven Development","Test-driven development (TDD) – разработка через тестирование.","Kent Beck"));
        data.add(new Book(3,"Effective Java","Java. Эффективное программирование, 2-е издание","Joshua Bloch"));
        data.add(new Book(4,"The Pragmatic Programmer","The Pragmatic Programmer. From Journeyman to Master / Программист-прагматик."," Andrew Hunt,David Thomas"));
    }

    public static List<Book> getData() {
        return data;
    }

    public static void addBook(String name, String description, String author)
    {
        data.add(new Book(data.size(),name,description,author));
    }

    public static void deleteBook(int id)
    {
        Book p =null;

        for (Book book: data) {
            if (book.getId()==id)
                p=book;
        }

        if (p!=null)
            data.remove(p);
    }

    public static Object getBook(int id) {

        Book p =null;

        for (Book book: data) {
            if (book.getId()==id)
                p=book;
        }
        return p;

    }

    public static void updateBook(int id,String name, String description, String author) {

        Book p = (Book) getBook(id);
        p.setAuthor(author);
        p.setName(name);
        p.setDescription(description);


    }
}
