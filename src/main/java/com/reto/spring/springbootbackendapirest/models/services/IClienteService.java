package com.reto.spring.springbootbackendapirest.models.services;

import java.util.List;

import com.reto.spring.springbootbackendapirest.models.entity.Cliente;

public interface IClienteService {
	
	public List<Cliente> findAll();
	
	public void save(Cliente cliente);
	
	public Cliente findById(Long id);
	
	public void delete(Cliente cliente);

}
