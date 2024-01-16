package com.bookaroo.bookaroo;

import java.util.List;

public interface BookService {

    List<Book> findAllBooks();

    List<Book> findBooksByTitle(String title);

    List<Book> findBooksByAuthor(String author);

    List<Book> findBooksByGenre(String genre);

}
