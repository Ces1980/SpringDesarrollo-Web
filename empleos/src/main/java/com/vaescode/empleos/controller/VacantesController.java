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
import java.util.List;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

@Controller
@RequestMapping("/vacantes")
public class VacantesController {
	
	@Autowired
	private IVacanteService serviceVacante;
	
	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		
		//Todo 1. Obtener todas las vacantes (recuperarlas con la clase servicio)
		List<Vacante> lista = serviceVacante.buscarTodas();
		//Agregar el modelo al listado de vacantes
		model.addAttribute("vacantes", lista);	
		//Renderizar las vacantes en la vista (integrar el archivo template-empleos/listVacantes.html)
		
		//Agregar al menu una opción llamada Vacantes configurando la URL vacantes/index 
		return "vacantes/listVacantes";
	}
	
	@GetMapping("/create")
	public String crear() {
		return "vacantes/formVacante";
	}
	
/*Para revisar posibles errores después del Data Binding(enlace de datos) debemos 
 * agregar un parametro de tipo BindingResult INMEDIATAMENTE después del parametro que se pasa del tipo Modelo
 * */
	@PostMapping("/save")
	public String guardar (Vacante vacante, BindingResult result) {
		
		if(result.hasErrors()) {
			for (ObjectError error: result.getAllErrors()) {
				System.out.println("Ocurrio un error: " + error.getDefaultMessage());
			}
			return "vacantes/formVacante";
		}
		serviceVacante.guardar(vacante);
		System.out.println("Vacante" + vacante);
		
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
