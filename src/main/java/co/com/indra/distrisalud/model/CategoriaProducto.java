package co.com.indra.distrisalud.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class CategoriaProducto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@NotNull(message = "Debes especificar el nombre")
	@Size(min = 1, max = 100, message = "Longitud máxima 100 caracteres")
	private String nombre;

	public CategoriaProducto(String nombre, Integer id) {
		this.nombre = nombre;
		this.id = id;
	}
	
	public CategoriaProducto(String nombre) {
		this.nombre = nombre;		
	}

	public CategoriaProducto() {
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
