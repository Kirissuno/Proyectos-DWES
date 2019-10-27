package main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import main.dependencies.Empleado;
import main.dependencies.Nomina;
import main.dependencies.interfaces.EmpleadoRepository;
import main.dependencies.interfaces.NominaRepository;

@SpringBootApplication(scanBasePackages={"main.dependencies","main.dependencies.interfaces"})
public class Main implements CommandLineRunner {
	
	@Autowired
	EmpleadoRepository empleadoDAO;
	@Autowired
	NominaRepository nominaDAO;
	
	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		for(Empleado emp : empleadoDAO.findAll()) {
			System.out.println(emp);
		}
		for(Nomina nom : nominaDAO.findAll()) {
			System.out.println(nom);
		}
	}
}
