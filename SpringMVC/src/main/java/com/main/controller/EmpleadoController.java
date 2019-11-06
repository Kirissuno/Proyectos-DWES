package com.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.main.model.Empleado;
import com.main.service.EmpleadoService;

@RestController
public class EmpleadoController {

	@Autowired
	private EmpleadoService empleadoService;
	
	@GetMapping("/")
	public ModelAndView index() {
		return new ModelAndView("index");
	}
	
	@GetMapping("/empleados")
	public ModelAndView getAll() {
		return new ModelAndView("empleados", "lista", empleadoService.getAll());
	}
	
//	@GetMapping("/empleado")
//	public ModelAndView getEspecifico(@RequestParam String dni){
//		return new ModelAndView("empleado", "empleado", empleadoService.getSpec(dni));
//	}
	
	@PostMapping("/empleados")
	public ResponseEntity<Empleado> crearEmpl(@RequestBody Empleado emp){
		return ResponseEntity.ok().body(empleadoService.createEmpleado(emp));
	}
	
	@GetMapping("/empleado")
	public ModelAndView actualizaEmp(@RequestParam String dni){
		return new ModelAndView("formmodificar", "empleado", empleadoService.getSpec(dni));
	}
	
	@GetMapping("/empleado/mod")
	public ModelAndView actualizaEmp(@RequestParam String dni, @RequestParam String nombre, @RequestParam String sexo, @RequestParam Integer categoria, @RequestParam Integer anyos){
		empleadoService.updateEmpleado(new Empleado(nombre, dni, sexo, categoria, anyos));
		return new ModelAndView("index");
	}
	
	@GetMapping("/empleado/alta")
	public ModelAndView altaEmp(@RequestParam String nombre, @RequestParam String dni, @RequestParam String sexo, @RequestParam Integer categoria, @RequestParam Integer anyos){
		empleadoService.updateEmpleado(new Empleado(nombre, dni, sexo, categoria, anyos));
		return new ModelAndView("index");
	}
	
	@GetMapping("/empleados/borrar")
	public ModelAndView borrarEmp(@RequestParam String dni){
		empleadoService.deleteEmpleado(dni);
		return new ModelAndView("/");
	}
	
	@GetMapping("/alta")
	public ModelAndView actualizaEmp(){
		return new ModelAndView("altaempleado");
	}
}
