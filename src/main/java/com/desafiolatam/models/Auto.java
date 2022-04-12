package com.desafiolatam.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="autos")
public class Auto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
		
		@NotNull
		@Size(min=3, max=20)
		private String marca;
		
		@NotNull
		@Size(min=3, max=20)
		private String modelo;
		
		@NotNull
		@Size(min=3, max=20)
		private String color;
		
		@NotNull
		@Range(min=0, max=400, message = "Fuera del rango") //acepta 0,001
		private Float velocidad;
		
		@Column(updatable=false)
		@DateTimeFormat(pattern="yyyy-MM-dd")
		private Date createdAt;

		@DateTimeFormat(pattern="yyyy-MM-dd")
		private Date updatedAt; 
		
		
		public Auto() {
			super();
		}

		public Auto(Long id, String marca, String modelo, String color, @Range(min = 0, max = 400) Float velocidad) {
			super();
			this.id = id;
			this.marca = marca;
			this.modelo = modelo;
			this.color = color;
			this.velocidad = velocidad;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Auto(String marca, String modelo, String color, Float velocidad) {
			super();
			this.marca = marca;
			this.modelo = modelo;
			this.color = color;
			this.velocidad = velocidad;
		}

		public String getMarca() {
			return marca;
		}

		public void setMarca(String marca) {
			this.marca = marca;
		}

		public String getModelo() {
			return modelo;
		}

		public void setModelo(String modelo) {
			this.modelo = modelo;
		}

		public String getColor() {
			return color;
		}

		public void setColor(String color) {
			this.color = color;
		}

		public Float getVelocidad() {
			return velocidad;
		}

		public void setVelocidad(Float velocidad) {
			this.velocidad = velocidad;
		}

		@Override
		public String toString() {
			return "Auto [marca=" + marca + ", modelo=" + modelo + ", color=" + color + ", velocidad=" + velocidad
					+ "]";
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