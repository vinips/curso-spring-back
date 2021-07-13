package io.github.vinips.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.vinips.model.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	
	

}
