package com.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.model.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, String> {

}
