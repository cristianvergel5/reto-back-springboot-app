package com.reto.spring.springbootbackendapirest.models.services;

//import java.util.List;

//import java.util.List;

import com.reto.spring.springbootbackendapirest.models.entity.Producto;

public interface IProductoService {
	
	
	public Iterable<Producto> findAll();
	public Producto findById(Long id);
}
