package com.vaescode.empleos.service;

import java.util.List;

import com.vaescode.empleos.model.Vacante;

public interface IVacanteService {

	List<Vacante> buscarTodas();
	
	Vacante buscarPorId(Integer idVacante);
	
	void guardar(Vacante vacante);
}
