package com.bolsadeidea.springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import com.bolsadeidea.springboot.backend.apirest.models.entity.Cliente;


public interface IClienteService {

	
	public List<Cliente> findAll();
	
	public Page<Cliente> findAll(Pageable pageable);
	
	public Cliente save(Cliente cliente);
	
	public void delete(Long id);
	
	public Cliente finById(Long id);
	
	public Cliente findByIdcriteriaBuilder(Long id);
	
	public Cliente findByIdNative(Long id);
}
