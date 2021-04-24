package com.reto.spring.springbootbackendapirest.models.services;

//import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.reto.spring.springbootbackendapirest.models.dao.IProductoDao;
import com.reto.spring.springbootbackendapirest.models.entity.Producto;

@Service("productoService")
@Transactional
public class ProductoServiceImpl implements IProductoService{

	@Autowired
	private IProductoDao productoDao;
	
	@Override
	public Iterable<Producto> findAll() {
		return productoDao.findAll();
	}

	@Override
	public Producto findById(Long id) {
		return productoDao.findById(id).orElse(null);
	}
	

	
	
	
	
	
	
}
