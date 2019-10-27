package com.main.service;

import java.util.List;

import com.main.model.Empleado;

public interface EmpleadoService {
	Empleado createEmpleado(Empleado emp);
	Empleado updateEmpelado(Empleado emp);
	List<Empleado> getAll();
	Empleado getSpec(String dni);
	void deleteEmpleado(String dni);
}
