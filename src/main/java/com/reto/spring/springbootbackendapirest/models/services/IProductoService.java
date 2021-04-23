package com.reto.spring.springbootbackendapirest.models.services;

import java.util.List;

import com.reto.spring.springbootbackendapirest.models.entity.Producto;

public interface IProductoService {
	
	
	public List<Producto> findAll();
	
	public void save(Producto producto);
	
	public Producto findById(Long id);
	
	public void delete(Producto producto);
	
}
