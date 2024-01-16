package com.bookaroo.bookaroo;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "books", createIndex = false)
public class Book {
    @Id
    private String id;
    private String title;
    private String author;
    private String genre;
    private Integer year;
    // Constructors

    public Book() {
        // Default constructor
    }

    public Book(String title, String author, String genre, Integer year) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.year = year;
    }

    // Getters and Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer publicationYear) {
        this.year = publicationYear;
    }

    // Additional methods, if needed

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", year=" + year +
                '}';
    }
}