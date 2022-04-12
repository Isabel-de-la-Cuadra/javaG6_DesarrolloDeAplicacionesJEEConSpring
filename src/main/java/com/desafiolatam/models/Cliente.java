package com.desafiolatam.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="clientes")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
		
	@NotNull
	@Size(min=3, max=20, message = "Aceptamos nombres con más de 3 caracteres" )
	private String nombre;
	
	@NotNull
	@Size(min=3, max=20, message = "Aceptamos apellidos con más de 3 caracteres")
	private String apellido;
	
	@NotNull
	private String correo;
	
	//OneToOne, trae por default los join Eager (Activo, de inmediato) or Lazy (Pasivo, lo hace cuando se lo piden)
	//se mapea con cliente no con la tabla
	@OneToOne (mappedBy="cliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Direccion direccion;
		
	//updatable= false fecha en que se creó y no se va a poder modificar, a nivel de BD
	//DateTimeFormat en formato USA con la finalidad de poder hacer cálculos más fáciles
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;

	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt; 
		
	//deleteAt columna para tener los clientes que se han borrado
		
	public Cliente() {
		super();
	}

	public Cliente(
		@NotNull @Size(min = 3, max = 20, message = "Aceptamos nombres con más de 3 caracteres") String nombre,
		@NotNull @Size(min = 3, max = 20, message = "Aceptamos apellidos con más de 3 caracteres") String apellido,
		@NotNull String correo, Direccion direccion) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.direccion = direccion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", correo=" + correo
				+ ", direccion=" + direccion + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}

	//PrePersist crea por nosotros antes de la persistencia
	@PrePersist
	protected void onCreate(){
		this.createdAt = new Date();
	}
		
	//PreUpdate crea por nosotros la fecha antes de la persistencia
	@PreUpdate
	protected void onUpdate(){
		this.updatedAt = new Date();
	} 
	
}