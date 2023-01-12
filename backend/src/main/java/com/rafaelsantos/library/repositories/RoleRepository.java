package com.rafaelsantos.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rafaelsantos.library.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{

}
