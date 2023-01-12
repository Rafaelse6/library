package com.rafaelsantos.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rafaelsantos.library.entities.Book;

public interface BookRepository extends JpaRepository<Book, Long>{

}
