package main.dependencies;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="empleados")
@Table(name="empleados")
public class Empleado {
	/**
	 * 
	 */
	private String nombre;
	@Id
	private String dni;
	private String sexo;
	private Integer categoria;
	private Integer anyos;
	
	
	
	public Empleado(String nombre, String dni, String sexo, Integer categoria, Integer anyos) {
		super();
		this.nombre = nombre;
		this.dni = dni;
		this.sexo = sexo;
		this.categoria = categoria;
		this.anyos = anyos;
	}
	
	public Empleado() {
		super();
		// TODO Auto-generated constructor stub
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

	@Override
	public String toString() {
		return nombre + ", " + dni + ", " + sexo + ", " + categoria
				+ ", " + anyos;
	}
	
	
	
}
