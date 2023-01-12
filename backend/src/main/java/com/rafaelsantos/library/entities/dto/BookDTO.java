package com.rafaelsantos.library.entities.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.rafaelsantos.library.entities.Book;
import com.rafaelsantos.library.entities.Category;

public class BookDTO implements Serializable{
	private static final long serialVersionUID = 1L;
		
	private Long id;
	
	private String author;
	private String name;
	private Double price;
	private Integer edition;
	private String imgUrl;
	
	private List<CategoryDTO> categories = new ArrayList<>();
	
	public BookDTO() {}

	public BookDTO(Long id, String author, String name, Double price, Integer edition, String imgUrl) {
		super();
		this.id = id;
		this.author = author;
		this.name = name;
		this.price = price;
		this.edition = edition;
		this.imgUrl = imgUrl;
	}
	
	
	public BookDTO(Book entity) {
		this.id = entity.getId();
		this.author = entity.getAuthor();
		this.name = entity.getName();
		this.price = entity.getPrice();
		this.edition = entity.getEdition();
		this.imgUrl = entity.getImgUrl();
	}
	
	public  BookDTO(Book entity, Set<Category> categories) {
		this(entity);
		categories.forEach(cat -> this.categories.add(new CategoryDTO(cat)));
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getEdition() {
		return edition;
	}

	public void setEdition(Integer edition) {
		this.edition = edition;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public List<CategoryDTO> getCategories() {
		return categories;
	}

	public void setCategories(List<CategoryDTO> categories) {
		this.categories = categories;
	}
}
