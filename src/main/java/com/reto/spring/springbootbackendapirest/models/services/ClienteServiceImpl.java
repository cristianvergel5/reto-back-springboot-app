package com.reto.spring.springbootbackendapirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.reto.spring.springbootbackendapirest.models.dao.IClienteDao;
import com.reto.spring.springbootbackendapirest.models.entity.Cliente;


@Service //marca la clase como un componente de servicio, queda almacenado contenedor de spring 
public class ClienteServiceImpl implements IClienteService{
	
	@Autowired //inyectar el cliente DAO 
	private IClienteDao clienteDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Cliente> findAll() {
		return (List<Cliente>) clienteDao.findAll();
	}

}
