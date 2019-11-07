package com.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.main.model.Empleado;
import com.main.service.EmpleadoService;
import com.main.service.NominaSevice;

@RestController
public class EmpleadoController {

	@Autowired
	private EmpleadoService empleadoService;
	@Autowired
	private NominaSevice nomService;
	
	@GetMapping("/")
	public ModelAndView index() {
		return new ModelAndView("index");
	}
	
	@GetMapping("/empleados")
	public ModelAndView getAll() {
		return new ModelAndView("empleados", "lista", empleadoService.getAll());
	}
	
	@GetMapping("/empleado")
	public ModelAndView actualizaEmp(@RequestParam String dni){
		return new ModelAndView("formmodificar", "empleado", empleadoService.getSpec(dni));
	}
	
	//
	@PostMapping("/empleado/mod")
	public ModelAndView actualizaEmp(@ModelAttribute("Empleado") Empleado empleado){
		empleadoService.updateEmpleado(empleado);
		return new ModelAndView("index");
	}
	
	@PostMapping("/empleado/alta")
	public ModelAndView submit(@ModelAttribute("Empleado") Empleado empleado,BindingResult result, ModelMap model) {
		model.addAttribute("nombre", empleado.getNombre());
		model.addAttribute("sexo", empleado.getSexo());
		model.addAttribute("dni", empleado.getDni());
		model.addAttribute("categoria", empleado.getCategoria());
		model.addAttribute("anyos", empleado.getAnyos());
		empleadoService.createEmpleado(empleado);
        return new ModelAndView("index");
    }
	
	@GetMapping("/empleados/borrar")
	public ModelAndView borrarEmp(@RequestParam String dni){
		empleadoService.deleteEmpleado(dni);
		nomService.deleteNomina(dni);
		return new ModelAndView("index");
	}
	
	@GetMapping("/alta")
	public ModelAndView actualizaEmp(){
		return new ModelAndView("altaempleado", "empleado", new Empleado());
	}
	
	
}
