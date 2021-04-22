package com.reto.spring.springbootbackendapirest.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.reto.spring.springbootbackendapirest.models.entity.Cliente;

public interface IClienteDao extends CrudRepository<Cliente, Long> {
	
}
