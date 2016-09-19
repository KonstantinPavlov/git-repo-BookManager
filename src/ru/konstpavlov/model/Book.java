package ru.konstpavlov.model;

/**
 * Created by Konstantin on 17.09.2016.
 *
 *
 * Основной класс для хранения данных о книгах,
 *
 */
public class Book {

    private int id; //  Ид книги из базы
    private String imagePath; // наименование картинки - обложки
    private String name;// название книги
    private String description;// описание книги
    private String author;// автор книги


    // дефолтный конструктор
    public Book()
    {

    }

    // еще  один конструктор , участвует в выоде списка книг
    public Book(int id, String name, String description, String author) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.author = author;
    }

    // геттеры и сеттеры полей, необходимы для правильной работы jsp страниц
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
