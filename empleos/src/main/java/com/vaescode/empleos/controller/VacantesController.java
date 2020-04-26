package com.vaescode.empleos.controller;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vaescode.empleos.model.Vacante;
import com.vaescode.empleos.service.IVacanteService;

import java.util.Date;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/vacantes")
public class VacantesController {
	
	@Autowired
	private IVacanteService serviceVacante;
	
	@GetMapping("/create")
	public String crear() {
		return "vacantes/formVacante";
	}
	

	@PostMapping("/save")
	public String guardar ( Vacante vacante) {
		serviceVacante.guardar(vacante);
		System.out.println("Vacante: " + vacante);
		
		return "vacantes/listVacantes";
	}
	/**
	@PostMapping("/save")
	public String guardar(@RequestParam("nombre") String nombre, @RequestParam("descripcion") String descripcion,
			              @RequestParam("estatus") String estatus, @RequestParam("fecha") String fecha, 
			              @RequestParam("destacado") int destacado,  @RequestParam("salario") double salario,
			              @RequestParam("detalles") String detalles) {
			   
		Para verificar en consola que llegaron los datos coorectamente
		System.out.println("Nombre Vacante: " + nombre);
		System.out.println("Descripción: " + descripcion);
		System.out.println("Estatus: " + estatus);
		System.out.println("Fecha publicación: " + fecha);
		System.out.println("Destacado: " + destacado);
		System.out.println("Salario: " + salario);
		System.out.println("Detalles: " + detalles);
		return "vacantes/listVacantes";
	} */
	
	@GetMapping("/delete")
	public String eliminar(@RequestParam("id") int idVacante, Model model) {
		model.addAttribute("id", idVacante);
		System.out.println("Borrando vacante con id: " + idVacante);
		return "mensaje";
	}

	@GetMapping("/view/{id}")
	public String verDetalle(@PathVariable("id") int idVacante, Model model) {
		
		Vacante vacante = serviceVacante.buscarPorId(idVacante);

		System.out.println("vacante: " + vacante);
		model.addAttribute("vacante", vacante);

		//Buscar los detalles de la variable en la base de datos
		return "detalle";
	}
	
	@InitBinder
	public void initBinder (WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
}
