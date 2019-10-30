package com.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.main.model.Empleado;
import com.main.service.EmpleadoService;

@RestController
public class EmpleadoController {

	@Autowired
	private EmpleadoService empleadoService;
	
	@GetMapping("/empleados")
	public ModelAndView getAll() {
		List<Empleado> lista = empleadoService.getAll();
		return new ModelAndView("empleados", "lista", lista);
	}
	
	@GetMapping("/empleados/{dni}")
	public ResponseEntity<Empleado> getEspecifico(@PathVariable String dni){
		return ResponseEntity.ok().body(empleadoService.getSpec(dni));
	}
	
	@PostMapping("/empleados")
	public ResponseEntity<Empleado> crearEmpl(@RequestBody Empleado emp){
		return ResponseEntity.ok().body(empleadoService.createEmpleado(emp));
	}
	
	@PutMapping("/empleados/{dni}")
	public ResponseEntity<Empleado> actualizaEmp(@PathVariable String dni,@RequestBody Empleado emp){
		emp.setDni(dni);
		return ResponseEntity.ok().body(empleadoService.updateEmpelado(emp));
	}
	
	@DeleteMapping("/empleados/{dni}")
	public HttpStatus borrarEmp(@PathVariable String dni){
		empleadoService.deleteEmpleado(dni);
		return HttpStatus.OK;
	}
}
