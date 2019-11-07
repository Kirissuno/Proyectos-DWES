package com.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.main.exception.ResourceNotFoundException;
import com.main.model.Empleado;
import com.main.model.Nomina;
import com.main.repository.EmpleadoRepository;
import com.main.repository.NominaRepository;

@Service
@Transactional
public class EmpleadoServiceImpl implements EmpleadoService{

	@Autowired
	private EmpleadoRepository empRepo;
	@Autowired
	private NominaRepository nomRepo;
	
	@Override
	public Empleado createEmpleado(Empleado emp) {
		Optional<Empleado> empleadoBD = empRepo.findById(emp.getDni());
		if(!empleadoBD.isPresent()) {
			nomRepo.save(new Nomina(emp.getDni(), NominaServiceImpl.sueldo(emp)));
			return empRepo.save(emp);
		}else {
			throw new ResourceNotFoundException("Empleado con DNI: "+emp.getDni()+" ya existente");
		}
	}

	@Override
	public Empleado updateEmpleado(Empleado emp) {
		Optional<Empleado> empleadoBD = empRepo.findById(emp.getDni());
		Optional<Nomina> nominaBD = nomRepo.findById(empleadoBD.get().getDni());

		if(empleadoBD.isPresent()) {
			Empleado empleadoUpdate = empleadoBD.get();
			Nomina nom = nominaBD.get();
			empleadoUpdate.setDni(emp.getDni());
			empleadoUpdate.setNombre(emp.getNombre());
			empleadoUpdate.setSexo(emp.getSexo());
			if(empleadoBD.get().getCategoria() != emp.getCategoria() || empleadoBD.get().getAnyos() != emp.getCategoria()) {
				empleadoUpdate.setCategoria(emp.getCategoria());
				empleadoUpdate.setAnyos(emp.getAnyos());
				nom.setDni(emp.getDni());
				nom.setSueldo(NominaServiceImpl.sueldo(emp));
			}
			empRepo.save(empleadoUpdate);
			nomRepo.save(nom);
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
		Empleado empleadoBD = this.empRepo.findById(dni).orElseThrow(() -> new ResourceNotFoundException("Empleado con DNI: "+ dni +" no existe"));
		return empleadoBD;
	}

	@Override
	public void deleteEmpleado(String dni) {
		Optional<Empleado> empleadoBD = this.empRepo.findById(dni);
		if(empleadoBD.isPresent()) {
			empRepo.delete(empleadoBD.get());
		}
	}


}
