package com.vaescode.empleos.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {
	
	/**
	 * @param model
	 * @return
	 */
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
