package com.example.pruebabackendspring.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap; 
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.pruebabackendspring.entity.Item;
import com.example.pruebabackendspring.services.ProductService;

@Controller
@RequestMapping("cart")
public class CartController {
	
	@Autowired
	private ProductService productService;
	
	//Listar carrito
	@RequestMapping(method = RequestMethod.GET)
	public String index() {
		return "cart/index";
	}
	
	// agregar producto a carrito
	@RequestMapping(value = "buy/{id}" , method = RequestMethod.GET)
	public String buy(@PathVariable("id") int id,  HttpSession session) {
		if(session.getAttribute("cart") == null) {
			List<Item> cart = new ArrayList<Item>();
			cart.add(new Item(productService.findById(id), 1));
			session.setAttribute("cart", cart);
			
		} else {
			List<Item> cart = (List<Item>) session.getAttribute("cart");
			int index = IsExists(id, cart);
				if(index==-1) {
					cart.add(new Item(productService.findById(id), 1));
				} else {
					int quantity = cart.get(index).getQuantity() + 1; 
					cart.get(index).setQuantity(quantity);
				}
				session.setAttribute("cart", cart);
			}
		return "redirect:../../cart";
	}
	
	
	//eliminar
	@RequestMapping(value = "remove/{id}" , method = RequestMethod.GET)
	public String remove(@PathVariable("id") int id,   HttpSession session) {
		List<Item> cart = (List<Item>) session.getAttribute("cart");
		int index = IsExists(id, cart);
		session.setAttribute("cart", cart);
		cart.remove(index);
		return "redirect:../../cart";
	}
	
	//actualizar carrito
	@RequestMapping(value = "remove/{id}" , method = RequestMethod.POST)
	public String update(HttpServletRequest request, HttpSession session) {
		  String[] quantites =  request.getParameterValues("quantity"); 
		  List<Item> cart = (List<Item>) session.getAttribute("cart");
		  
		  for(int i = 0;i< cart.size(); i++){
			  cart.get(i).setQuantity(Integer.parseInt(quantites[i]));
		  }
		  session.setAttribute("cart", cart);
		return "redirect:../../cart";
	}
	
	//buscar id en list de Items
	private int IsExists(int id, List<Item> cart) {
		for(int i = 0; i < cart.size(); i++	) {
			if(cart.get(i).getProduct().getId() ==id) {
				return i;
			}
		}
		return -1;
	}
		

}
