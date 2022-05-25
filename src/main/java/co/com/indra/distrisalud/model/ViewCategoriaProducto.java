package co.com.indra.distrisalud.model;

import javax.persistence.*;


@Entity
@Table(name="view_categoria_producto")
public class ViewCategoriaProducto {
	 @Id	
	 private Integer categoria_producto_id;
	 private String nombre; 
	 private String cant;
	 
	public Integer getCategoria_producto_id() {
		return categoria_producto_id;
	}
	public void setCategoria_producto_id(Integer categoria_producto_id) {
		this.categoria_producto_id = categoria_producto_id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCant() {
		return cant;
	}
	public void setCant(String cant) {
		this.cant = cant;
	}
	
	 
	 
	 
	

}
