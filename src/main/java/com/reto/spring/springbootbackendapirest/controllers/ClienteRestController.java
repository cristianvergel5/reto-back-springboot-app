package com.reto.spring.springbootbackendapirest.controllers;

import java.util.List;

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

import com.reto.spring.springbootbackendapirest.models.entity.Cliente;
import com.reto.spring.springbootbackendapirest.models.services.IClienteService;


@CrossOrigin(origins= {"http://localhost:4200"}) //se da acceso a el dominio para enviar y recibir datos
@RestController //  indica que es un apirest
@RequestMapping("/api") //Importar | mapear
public class ClienteRestController {
	
	@Autowired
	private IClienteService clienteService;
	
	
	// Implementacion de Listar clientes
	@GetMapping("/clientes") //peticion tipo get endpoint para responder a las peticiones
	//metodo para listar los clientes
	public List<Cliente> index(){
		return clienteService.findAll();
	}
	
	
	//implementacion buscar por ID
	@GetMapping("/clientes/{id}")
	public Cliente show(@PathVariable Long id){  // anotacion pathv porque se esta pasando por id
		return clienteService.findById(id);
	}
	
	
	//Crear 
	@PostMapping("/clientes")
	@ResponseStatus(code = HttpStatus.CREATED) //si es correcto el create da respuesta ok retorna 201
	public Cliente create(@RequestBody Cliente cliente){  //RequestBody dado que vienen en formato json se indica que es REBody, se transforman los datos 
		return clienteService.save(cliente);
	}
	
	//Actualizar 
	@PutMapping("/clientes/{id}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Cliente update(@RequestBody Cliente cliente, @PathVariable Long id) {
		Cliente clienteActual = this.clienteService.findById(id);
		
		clienteActual.setApellido(cliente.getApellido());;
		clienteActual.setNombre(cliente.getNombre());
		clienteActual.setEmail(cliente.getEmail());
		
		return clienteService.save(clienteActual);
	}
	
	@DeleteMapping("/clientes/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT) //retorna 204 si la se elimino correctamente
	public void detele(@PathVariable Long id) {
		this.clienteService.findById(id);
		clienteService.delete(id);
	}
}
