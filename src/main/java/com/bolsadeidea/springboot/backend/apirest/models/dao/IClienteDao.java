package com.bolsadeidea.springboot.backend.apirest.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bolsadeidea.springboot.backend.apirest.models.entity.Cliente;


@Repository
public interface IClienteDao extends JpaRepository<Cliente, Long> {
	
	@Query(
			value = "SELECT * FROM CLIENTES c WHERE c.id = ?1", 
			nativeQuery = true)
	public Cliente findByIdNative(Long id);

}
