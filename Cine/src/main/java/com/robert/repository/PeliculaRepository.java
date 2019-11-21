package com.robert.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.robert.model.Pelicula;

@Repository
public interface PeliculaRepository extends JpaRepository<Pelicula, String> {

}
