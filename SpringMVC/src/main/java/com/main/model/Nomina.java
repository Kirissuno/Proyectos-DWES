package com.main.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name = "nominas")
public class Nomina{
	
	@Id
	@NotNull
	@Column(length = 255)
	private String dni;
	@NotNull
	private Integer sueldo;

	public Nomina(String dni, Integer sueldo) {
		super();
		this.dni = dni;
		this.sueldo = sueldo;
	}

	public Nomina() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
	
	public int getSueldo() {
		return sueldo;
	}

	public void setSueldo(Integer sueldo) {
		this.sueldo = sueldo;
	}

}
