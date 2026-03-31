package com.xzit.service;

import com.xzit.domain.Book;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface BookService {

    public boolean save(Book book);

    public boolean update(Book book);

    public boolean delete(Integer id);

    public Book getById(Integer id);

    public List<Book> getAll();
}
