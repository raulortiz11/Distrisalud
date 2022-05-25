package co.com.indra.distrisalud.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.ManyToOne;

@Entity
public class Producto {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@NotNull(message = "Debes especificar el nombre")
	@Size(min = 1, max = 100, message = "Longitud máxima 100 caracteres")
	private String nombre;

	@NotNull(message = "Debes especificar el estado")
	@Size(min = 1, max = 1, message = "Longitud máxima 1 caracter")
	private String estado;
	
	@ManyToOne
	private CategoriaProducto categoriaProducto;



	public Producto(String nombre, String estado, CategoriaProducto categoriaProducto, Integer id) {
		this.nombre = nombre;
		this.estado = estado;
		this.categoriaProducto = categoriaProducto;
		this.id = id;
		
	}

	public Producto(String nombre, String estado, CategoriaProducto categoriaProducto) {
		this.nombre = nombre;
		this.estado = estado;
		this.categoriaProducto = categoriaProducto;
	}

	public Producto() {
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public CategoriaProducto getCategoriaProducto() {
		return categoriaProducto;
	}

	public void setCategoriaProducto(CategoriaProducto categoriaProducto) {
		this.categoriaProducto = categoriaProducto;
	}
}
