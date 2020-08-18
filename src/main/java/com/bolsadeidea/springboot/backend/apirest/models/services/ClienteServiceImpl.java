package com.bolsadeidea.springboot.backend.apirest.models.services;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.bolsadeidea.springboot.backend.apirest.models.dao.IClienteDao;
import com.bolsadeidea.springboot.backend.apirest.models.entity.Cliente;

@Service
public class ClienteServiceImpl implements IClienteService{

	@Autowired
	private IClienteDao clienteDao;
	
	@Autowired
	private EntityManager em;
	
	@Override
	@Transactional(readOnly = true)
	public List<Cliente> findAll() {
		return (List<Cliente>) clienteDao.findAll();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Cliente finById(Long id) {
		return clienteDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Cliente save(Cliente cliente) {
		return clienteDao.save(cliente);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		clienteDao.deleteById(id);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Cliente> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return this.clienteDao.findAll(pageable);
	}

	
	@Transactional(readOnly = true)
	public Cliente findByIdcriteriaBuilder(Long id) {
		// TODO Auto-generated method stub


		Cliente result = null;
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Cliente> criteriaQ = cb.createQuery(Cliente.class);
		Root<Cliente> root = criteriaQ.from(Cliente.class);
		
		criteriaQ.select(root).where(cb.equal(root.get("id"), id));
		
		try {
			result = em.createQuery(criteriaQ).getSingleResult();
			
		} catch (PersistenceException e) {
			 return null;
		}
		
		
		return result;
	}

	
	@Override
	public Cliente findByIdNative(Long id) {
		return  clienteDao.findByIdNative(id);
	}
	
	
}
