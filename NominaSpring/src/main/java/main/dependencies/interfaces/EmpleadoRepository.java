package main.dependencies.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import main.dependencies.Empleado;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, String> {
	
	
}
