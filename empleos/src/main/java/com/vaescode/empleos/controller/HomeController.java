package com.vaescode.empleos.controller;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {
	
	@GetMapping("/listado")
	public String mostrarListado(Model model) {

		List<String> lista = new LinkedList<String>();
		lista.add("Ingeniero de Sistemas");
		lista.add("Auxiliar de contabilidad");
		lista.add("Vendedor");
		lista.add("Arquitecto");
		
		model.addAttribute("empleos", lista);
		return "listado";
	}
	
	@GetMapping({"/","home"})
	public String mostrarHome(Model model) {
		/*model.addAttribute("mensaje", "Bienvenidos a Empleos App");
		model.addAttribute("fecha", new Date());*/
		String nombre= "Auxiliar de contabilidad";
		Date fechaPub = new Date();
		double salario = 9000.0;
		boolean vigente = true;
		model.addAttribute("nombre",nombre);
		model.addAttribute("fecha", fechaPub);
		model.addAttribute("salario",salario);
		model.addAttribute("vigente",vigente);
		
		return "home";
	}
	
	@GetMapping("/acerca")
	public String acerca(Model model) {
		model.addAttribute("mensaje", "Acerca de nosotros");
		model.addAttribute("quienes", "¿Quienes somos?");
		return "acerca";
	}

}
