package com.vaescode.empleos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/vacantes")
public class VacantesController {

	@GetMapping("/view/{id}")
	public String verDetalle(@PathVariable("id") int idVacante, Model model) {

		System.out.println("IdVacante: " + idVacante);
		model.addAttribute("idVacante", idVacante);

		//Buscar los detalles de la variable en la base de datos
		return "vacantes/detalle";
	}
}
