package com.reto.spring.springbootbackendapirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reto.spring.springbootbackendapirest.models.entity.Cliente;
import com.reto.spring.springbootbackendapirest.models.services.IClienteService;

@RestController //
@RequestMapping("/api") //Importar | mapear
public class ClienteRestController {
	
	@Autowired
	private IClienteService clienteService;
	
	@GetMapping("/clientes") //peticion tipo get
	//metodo para listar los clientes
	public List<Cliente> index(){
		return clienteService.findAll();
	}
}
