package com.main.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name="empleados")
public class Empleado {
	
	@NotNull
	private String nombre;
	@Id
	@NotNull
	private String dni;
	@NotNull
	private String sexo;
	@NotNull
	private Integer categoria;
	@NotNull
	private Integer anyos;
	
//	@OneToOne(mappedBy = "empleado")
//	private Nomina nomina;
	
	public Empleado() {
		super();
	}
	public Empleado(String dni) {
		super();
		this.dni = dni;
	}
	
	
	public Empleado(String nombre, String dni, String sexo, Integer categoria, Integer anyos) {
		super();
		this.nombre = nombre;
		this.dni = dni;
		this.sexo = sexo;
		this.categoria = categoria;
		this.anyos = anyos;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public Integer getCategoria() {
		return categoria;
	}
	public void setCategoria(Integer categoria) {
		this.categoria = categoria;
	}
	public Integer getAnyos() {
		return anyos;
	}
	public void setAnyos(Integer anyos) {
		this.anyos = anyos;
	}
	
	

}
