package com.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.main.exception.ResourceNotFoundException;
import com.main.model.Empleado;
import com.main.model.Nomina;
import com.main.repository.NominaRepository;

@Service
@Transactional
public class NominaServiceImpl implements NominaSevice {

	@Autowired
	private NominaRepository nomRepo;

	@Override
	public Nomina updateSueldo(Empleado emp) {
		Optional<Nomina> nominaBD = this.nomRepo.findById(emp.getDni());
		if(nominaBD.isPresent()) {
			Nomina nominaUpdate = nominaBD.get();
			nominaUpdate.setDni(emp.getDni());;
			nominaUpdate.setSueldo(sueldo(emp));
			nomRepo.save(nominaUpdate);
			return nominaUpdate;
		}else {
			return null;
		}
	}

	@Override
	public List<Nomina> getAll() {
		return nomRepo.findAll();
	}

	@Override
	public Nomina getSpec(String dni) {
		Optional<Nomina> nominaBD = this.nomRepo.findById(dni);
		return nominaBD.orElseThrow();
	}
	
	@Override
	public void deleteNomina(String dni) {
		Optional<Nomina> nominaBD = this.nomRepo.findById(dni);
		if(nominaBD.isPresent()) {
			nomRepo.delete(nominaBD.get());
		}
	}
	
	private static final int SUELDO_BASE[] = 
		{50000, 70000, 90000, 110000, 130000, 150000, 170000, 190000, 210000, 230000};
	
	public static int sueldo (Empleado emp) {
		return SUELDO_BASE[emp.getCategoria()-1]+5000*emp.getAnyos();
	}


}
