package com.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.main.exception.ResourceNotFoundException;
import com.main.model.Empleado;
import com.main.repository.EmpleadoRepository;

@Service
@Transactional
public class EmpleadoServiceImpl implements EmpleadoService{

	@Autowired
	private EmpleadoRepository empRepo;
	
	@Override
	public Empleado createEmpleado(Empleado emp) {
		return empRepo.save(emp);
	}

	@Override
	public Empleado updateEmpelado(Empleado emp) {
		Optional<Empleado> empleadoBD = this.empRepo.findById(emp.getDni());
		if(empleadoBD.isPresent()) {
			Empleado empleadoUpdate = empleadoBD.get();
			empleadoUpdate.setDni(emp.getDni());
			empleadoUpdate.setNombre(emp.getNombre());
			empleadoUpdate.setSexo(emp.getSexo());
			empleadoUpdate.setCategoria(emp.getCategoria());
			empleadoUpdate.setAnyos(emp.getAnyos());
			empRepo.save(empleadoUpdate);
			return empleadoUpdate;
		}else {
			throw new ResourceNotFoundException("Empleado con DNI : "+emp.getDni() +" inexistente");
		}
	}

	@Override
	public List<Empleado> getAll() {
		return empRepo.findAll();
	}

	@Override
	public Empleado getSpec(String dni) {
		Optional<Empleado> empleadoBD = this.empRepo.findById(dni);
		if(empleadoBD.isPresent()) {
			return empleadoBD.get();
		}else {
			throw new ResourceNotFoundException("Empleado con DNI : "+dni +" inexistente");
		}
	}

	@Override
	public void deleteEmpleado(String dni) {
		Optional<Empleado> empleadoBD = this.empRepo.findById(dni);
		if(empleadoBD.isPresent()) {
			empRepo.delete(empleadoBD.get());
		}else {
			throw new ResourceNotFoundException("Empleado con DNI : "+dni +" inexistente");
		}
	}

}
