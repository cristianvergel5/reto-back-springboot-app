package com.reto.spring.springbootbackendapirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.reto.spring.springbootbackendapirest.models.dao.IClienteDao;
import com.reto.spring.springbootbackendapirest.models.entity.Cliente;


@Service //marca la clase como un componente de servicio, queda almacenado contenedor de spring 
public class ClienteServiceImpl implements IClienteService{
	
	@Autowired //inyectar el cliente DAO, (dependencias)
	private IClienteDao clienteDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Cliente> findAll() {
		return (List<Cliente>) clienteDao.findAll(); //retorna un iterable, se hace el cast para convertirlo a list
	}

	@Override
	@Transactional(readOnly = true)
	public Cliente findById(Long id) {
		// TODO Auto-generated method stub
		return clienteDao.findById(id).orElse(null);
	}

	@Override
	public Cliente save(Cliente cliente) {
		// TODO Auto-generated method stub
		return clienteDao.save(cliente);
	}
	
	
	@Transactional(readOnly = true)
	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		clienteDao.deleteById(id);
	}
	

}
