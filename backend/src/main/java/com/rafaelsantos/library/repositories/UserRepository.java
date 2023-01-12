package com.rafaelsantos.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rafaelsantos.library.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	User findByEmail(String email);
}
