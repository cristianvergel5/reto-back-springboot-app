package com.reto.spring.springbootbackendapirest.models.services;

import java.util.List;

import com.reto.spring.springbootbackendapirest.models.entity.Cliente;

public interface IClienteService {
		
	
	//Listar clientes
	public List<Cliente> findAll();
	
	//Filtrar 
	public Cliente findById(Long id);
	
	//Crear
	public Cliente save(Cliente cliente);
	
	//Eliminar
	public void delete(Long id);
	

	
	
}
