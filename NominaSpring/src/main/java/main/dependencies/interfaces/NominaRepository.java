package main.dependencies.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import main.dependencies.Nomina;

@Repository
public interface NominaRepository extends JpaRepository<Nomina, String> {
	
}
