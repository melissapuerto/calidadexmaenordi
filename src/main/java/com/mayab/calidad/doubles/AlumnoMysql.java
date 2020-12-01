package com.mayab.calidad.doubles;

import java.util.ArrayList;
import java.sql.*;
import java.sql.PreparedStatement;

public class AlumnoMysql implements AlumnoDAO{
	@Override
	public String addAlumno(Alumno alumno) {
		// TODO Auto-generated method stub	
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/DBUnit"
					+ "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
			String query = "Insert Into Alumno(nombre,id,edad,promedio,email) values (?, ?, ?, ?, ?);";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement .setString(1, alumno.getNombre());
            		preparedStatement .setInt(2, alumno.getId());
            		preparedStatement .setInt(3, alumno.getEdad());
            		preparedStatement .setFloat(4, (float) alumno.getPromedio());
            		preparedStatement .setString(5, alumno.getEmail());
			
			preparedStatement.execute();
			conn.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return "Se agrego alumno";
	}

	@Override
	public String removeAlumno(Alumno alumno) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/DBUnit"
					+ "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
			String query = "Delete from Alumno where id = ?;";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt (1, alumno.getId());
		
			preparedStatement.execute();
			conn.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return "Se elimino alumno";
	}

	@Override
	public String updatePromedio(Alumno alumno) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/DBUnit"
					+ "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
			String query = "Update Alumno Set promedio = ? where id = ?;";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setFloat(1, (float) alumno.getPromedio());
			preparedStatement.setInt (2, alumno.getId());
			preparedStatement.execute();
			conn.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return "Se actualizo promedio";
	}

	@Override
	public boolean getAll() {
		// TODO Auto-generated method stub
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/DBUnit"
					+ "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
			String query = "Select * from Alumno";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.execute();
			conn.close();
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return true;
		
	}

}
