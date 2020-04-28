package com.vaescode.empleos.service;

import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;
import com.vaescode.empleos.model.Vacante;

@Service
public class VacantesServiceImpl implements IVacanteService{
	
	/*Se inicializa la lista como atributo de la clase para poder usarla
	 * en cualquier metodo dentro de ella */
	private List<Vacante> lista = null;

	/*Constructor de la clase*/
	public VacantesServiceImpl() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
		lista = new LinkedList<Vacante>();
		
		try {
			//Vacante uno
			Vacante vacante1 = new Vacante();
			vacante1.setId(1);
			vacante1.setNombre("Ingeniero civil");
			vacante1.setDescripcion("Solicitamos ing. civil para diseñar puente peatonal");
			vacante1.setFecha(sdf.parse("09-04-2020"));
			vacante1.setSalario(8000.00);
			vacante1.setEstatus("Aprobada");
			vacante1.setDestacado(1);
			vacante1.setImagen("logo3.png");
			
			//Vacante dos
			Vacante vacante2 = new Vacante();
			vacante2.setId(2);
			vacante2.setNombre("Contador publico");
			vacante2.setDescripcion("Empresa importante solicita contador con 5 años de experiencia");
			vacante2.setFecha(sdf.parse("12-04-2020"));
			vacante2.setSalario(8500.00);
			vacante2.setDestacado(0);
			vacante2.setImagen("empresa2.png");
			
			//Vacante tres
			Vacante vacante3 = new Vacante();
			vacante3.setId(3);
			vacante3.setNombre("Ingeniero electronico");
			vacante3.setDescripcion("Empresa internacional solicita ingeniero mecanico para mantenimiento de la instalación electrica");
			vacante3.setFecha(sdf.parse("11-04-2020"));
			vacante3.setSalario(10500.00);
			vacante3.setDestacado(0);
		
			
			//Vacante cuatro
			Vacante vacante4 = new Vacante();
			vacante4.setId(4);
			vacante4.setNombre("Ingeniero en sistemas");
			vacante4.setDescripcion("Solicitamos ing. en sistemas para desarrollo de app a la medida");
			vacante4.setFecha(sdf.parse("09-04-2020"));
			vacante4.setSalario(25500.00);
			vacante4.setDestacado(1);
			vacante4.setImagen("empresa3.png");
			
			/**
			 * Agregamos los 4 objetos de tipo Vacante a la lista
			 * */
			lista.add(vacante1);
			lista.add(vacante2);
			lista.add(vacante3);
			lista.add(vacante4);
			
		}catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		
	}
	
	@Override
	public List<Vacante> buscarTodas() {
		return lista;
	}

	@Override
	public Vacante buscarPorId(Integer idVacante) {
		for (Vacante vacante : lista) {
			if(vacante.getId() == idVacante) {
				return vacante;
			}
		}
		return null;
	}

	@Override
	public void guardar(Vacante vacante) {
		/*Objeto que es enviado por el controlador a través de la clase de servicio*/
		lista.add(vacante);
	}

	

}
