package com.main.service;

import java.util.List;

import com.main.model.Empleado;
import com.main.model.Nomina;

public interface NominaSevice {
	List<Nomina> getAll();
	Nomina getSpec(String dni);
	Nomina updateSueldo(Empleado emp);
	void deleteNomina(String dni);
}
