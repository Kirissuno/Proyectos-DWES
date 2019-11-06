package com.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.main.service.NominaSevice;

@RestController
public class NominaController {
	
	@Autowired
	private NominaSevice nominaService;
	
	
	@GetMapping("/nomina")
	public ModelAndView getEspecifico(@RequestParam(required = false) String dni){
		return new ModelAndView("empleado", "nomina", nominaService.getSpec(dni));
	}

}
