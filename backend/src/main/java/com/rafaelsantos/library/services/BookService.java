package com.rafaelsantos.library.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rafaelsantos.library.entities.Book;
import com.rafaelsantos.library.entities.Category;
import com.rafaelsantos.library.entities.dto.BookDTO;
import com.rafaelsantos.library.entities.dto.CategoryDTO;
import com.rafaelsantos.library.repositories.BookRepository;
import com.rafaelsantos.library.repositories.CategoryRepository;
import com.rafaelsantos.library.services.exceptions.DatabaseException;
import com.rafaelsantos.library.services.exceptions.ResourceNotFoundException;

@Service
public class BookService {
	
	@Autowired
	private BookRepository repository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Transactional(readOnly = true)
	public Page<BookDTO> findAllPaged(Pageable pageable){
		Page<Book> list = repository.findAll(pageable);
		return list.map(x -> new BookDTO(x));
	}
	
	@Transactional(readOnly = true)
	public BookDTO findById(Long id) {
		Optional<Book> obj = repository.findById(id);
		Book entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new BookDTO(entity, entity.getCategories());
	}
	
	@Transactional
	public BookDTO insert(BookDTO dto) {
		Book entity = new Book();
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		
		return new BookDTO(entity);
	}
	
	@Transactional
	public BookDTO update(Long id, BookDTO dto) {
		try {
			Book entity = repository.getOne(id);
			copyDtoToEntity(dto, entity);
			repository.save(entity);
			
			return new BookDTO(entity);
		} catch (Exception e) {
			throw new ResourceNotFoundException("Id not found " + id);
		}
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} 
		catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id not found " + id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity violation");
		}
	}
	
	private void copyDtoToEntity(BookDTO dto, Book entity) {
		entity.setName(dto.getName());
		entity.setAuthor(dto.getAuthor());
		entity.setEdition(dto.getEdition());
		entity.setImgUrl(dto.getImgUrl());
		entity.setPrice(dto.getPrice());
		
		entity.getCategories().clear();
		
		for(CategoryDTO catDto : dto.getCategories()) {
			Category category = categoryRepository.getOne(catDto.getId());
			entity.getCategories().add(category);
		}
	}
}
