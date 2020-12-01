package com.mayab.calidad.doubles;

public class Alumno {
	 
	 int edad;
	 float promedio;
	 String email;
	 String nombre;
	 int id;
	public Alumno() {
		this.nombre = "veronica";
		this.id = 0;
		this.edad = 0;
		this.promedio = 0.0f;
		this.email = "veronica@gmail.com";
	}
	
	public Alumno(String nombre, int id, int edad, float promedio,String email) {
		this.nombre = nombre;
		this.id = id;
		this.edad = edad;
		this.promedio = promedio;
		this.email = email;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public double getPromedio() {
		return promedio;
	}

	public void setPromedio(float promedio) {
		this.promedio = promedio;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	
	

}
