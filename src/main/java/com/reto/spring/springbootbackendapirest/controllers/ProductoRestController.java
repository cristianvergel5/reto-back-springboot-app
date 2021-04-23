package com.reto.spring.springbootbackendapirest.controllers;

import java.util.List;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.reto.spring.springbootbackendapirest.models.entity.Producto;
import com.reto.spring.springbootbackendapirest.models.services.IProductoService;

import ch.qos.logback.classic.Logger;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class ProductoRestController {
	
	private Logger logger;
	
	@Autowired
	private IProductoService productoService;
	
	
	//list
	@GetMapping("/productos")
	public List<Producto> index(){
		return productoService.findAll();
	}
	//search for id
	@GetMapping("/productos/{id}")
	public Producto show(@PathVariable Long id) {
		return this.productoService.findById(id);
	}
	
	
	//create
	@PostMapping("/productos")
	@ResponseStatus(HttpStatus.CREATED)
	public Producto create(@RequestBody Producto producto) {
		this.productoService.save(producto);
		return producto;
	}
	
//	//update
//	@PutMapping("/productos/{id}")
//	@ResponseStatus(HttpStatus.CREATED)
//	public Producto update(@RequestBody Producto producto, @PathVariable Long id) {
//		Producto productoActual = this.productoService.findById(id);
//		
//		productoActual.setNombre(producto.getNombre());
//		productoActual.setDescripcion(producto.getDescripcion());
//		productoActual.setPrecio(producto.getPrecio());
//		productoActual.setEnvio(producto.getEnvio());
//		this.productoService.save(productoActual);
//		return productoActual;
//		
//	}
	
	//update reto 1
	@PutMapping("/productos/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Producto update(@RequestBody Producto producto, @PathVariable Long id) {
		Producto productoActual = this.productoService.findById(id);
		
		long valor = 0;
		
		if(productoActual.getPrecio() > 100000) {
			productoActual.setEnvio(valor);
			
			
		} else {
			productoActual.getEnvio();
		}
		
		this.productoService.save(productoActual);
		return productoActual;
	}
	
	
	//delete
	@DeleteMapping("/productos/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		Producto producto = this.productoService.findById(id);
		this.productoService.delete(producto);
	}
	
	
	
		
}
