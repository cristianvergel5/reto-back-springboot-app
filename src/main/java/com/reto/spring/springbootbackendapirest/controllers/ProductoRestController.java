package com.reto.spring.springbootbackendapirest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.reto.spring.springbootbackendapirest.models.services.IProductoService;



@Controller
//@CrossOrigin(origins = {"http://localhost:4200"})
//@RestController
@RequestMapping("producto")
public class ProductoRestController {
	@Autowired
	private IProductoService productoService;
	
	
	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		modelMap.put("productos", productoService.findAll());
		return "producto/index";
	}
	

		
}
