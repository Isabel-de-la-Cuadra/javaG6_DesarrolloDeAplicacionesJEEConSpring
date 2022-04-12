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
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="usuarios")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min=4, max=20,message = "El mínimo de caracteres es 4 y el máximo, de 20")
	private String nombre;
	
	@NotNull
	@Size(min=4, max=20,message = "El mínimo de caracteres es 4 y el máximo, de 20")
	private String apellido;
	
	@NotNull
	@Email(message = "El correo no puede estar vacío")
	private String correo;
	
	@NotNull
	@Size(min=4,message = "El mínimo de caracteres es 4")
	private String password;
	
	//No crea la columna passwordControl en la tabla Usuarios
	@Transient
	@Size(min=4,message = "El mínimo de caracteres es 4")
	private String passwordControl;
	
	//OneToOne, trae por default los join Eager (Activo, de inmediato) or Lazy (Pasivo, lo hace cuando se lo piden)
	//se mapea con usuario no con la tabla
	@OneToOne (mappedBy="usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Direccion direccion;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;

	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt; 	
	
	public Usuario() {
		super();
	}
	
	public Usuario(
			@NotNull @Size(min = 4, max = 20, message = "El mínimo de caracteres es 4 y el máximo, de 20") String nombre,
			@NotNull String apellido, @NotNull @Email(message = "El correo no puede estar vacío") String correo,
			@NotNull @Size(min = 4, message = "El mínimo de caracteres es 4") String password,
			@Size(min = 4, message = "El mínimo de caracteres es 4") String passwordControl, Direccion direccion) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.password = password;
		this.passwordControl = passwordControl;
		this.direccion = direccion;
	}

	public Usuario(Long id,
			@NotNull @Size(min = 4, max = 20, message = "El mínimo de caracteres es 4 y el máximo, de 20") String nombre,
			@NotNull String apellido, @NotNull @Email(message = "El correo no puede estar vacío") String correo,
			@NotNull @Size(min = 4, message = "El mínimo de caracteres es 4") String password,
			@Size(min = 4, message = "El mínimo de caracteres es 4") String passwordControl, Direccion direccion,
			Date createdAt, Date updatedAt) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.password = password;
		this.passwordControl = passwordControl;
		this.direccion = direccion;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordControl() {
		return passwordControl;
	}

	public void setPasswordControl(String passwordControl) {
		this.passwordControl = passwordControl;
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

	@PrePersist
	protected void onCreate(){
	this.createdAt = new Date();
	}
	@PreUpdate
	protected void onUpdate(){
	this.updatedAt = new Date();
	} 
	
}
