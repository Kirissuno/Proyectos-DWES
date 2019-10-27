package main.dependencies;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity(name="nominas")
@Table(name="nominas")
public class Nomina implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String dni;
	
	private Integer sueldo;

	public Nomina() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Nomina(String dni, Integer sueldo) {
		super();
		this.dni = dni;
		this.sueldo = sueldo;
	}

	public String getEmpleado() {
		return dni;
	}

	public void setEmpleado(String dni) {
		this.dni = dni;
	}

	public Integer getSueldo() {
		return sueldo;
	}

	public void setSueldo(Integer sueldo) {
		this.sueldo = sueldo;
	}

	@Override
	public String toString() {
		return dni + ", " + sueldo;
	}
	
	
	
	
}
