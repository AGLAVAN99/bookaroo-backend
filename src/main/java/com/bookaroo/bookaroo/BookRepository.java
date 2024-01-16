package com.bookaroo.bookaroo;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface BookRepository extends ElasticsearchRepository<Book, String> {

    // Custom query methods
    List<Book> findByTitle(String title);

    List<Book> findByAuthor(String author);

    List<Book> findByGenre(String genre);

}
