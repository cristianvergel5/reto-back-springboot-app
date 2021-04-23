package com.reto.spring.springbootbackendapirest.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.reto.spring.springbootbackendapirest.models.entity.Producto;

public interface IProductoDao extends CrudRepository<Producto, Long>{
	
	
	
}
