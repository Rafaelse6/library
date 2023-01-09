package com.rafaelsantos.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rafaelsantos.library.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
