package com.mayab.calidad.Doubles;

import java.io.File;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.mayab.calidad.doubles.Alumno;
import com.mayab.calidad.doubles.AlumnoMysql;

import org.dbunit.Assertion;
import org.dbunit.DBTestCase;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class TestDoubles extends DBTestCase{
	
	public TestDoubles(String name) {
		super(name);
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS, "com.mysql.cj.jdbc.Driver");
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL, "jdbc:mysql://localhost:3306/DBUnit"
			+ "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME, "root");
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD, "");
	}

	@Before
	public void setUp() throws Exception {
		super.setUp();
		IDatabaseConnection conn = getConnection();
		try {
			DatabaseOperation.CLEAN_INSERT.execute(conn, getDataSet());
		}finally {
			conn.close();
		}
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void atestInsert() throws Exception {
		IDatabaseConnection conn = getConnection();
		Alumno alumno = new Alumno("Vero", 9, 20, 5.9f,"vero@hotmail.com");
		AlumnoMysql functions = new AlumnoMysql();
		int size = conn.getRowCount("Alumno");
		functions.addAlumno(alumno);
		assertEquals(size + 1, conn.getRowCount("Alumno"));
		conn.close();
	}
	
	@Test
	public void dtestDelete() throws Exception{
		IDatabaseConnection conn = getConnection();
		Alumno alumno = new Alumno("Vero", 6, 20, 5.9f,"vero@hotmail.com");
		AlumnoMysql functions = new AlumnoMysql();
		int size = conn.getRowCount("Alumno");
		functions.removeAlumno(alumno);
		assertEquals(size - 1, conn.getRowCount("Alumno"));
		conn.close();
	}
	
	@Test
	public void btestUpdateAvg() throws Exception{
		Alumno alumno = new Alumno("Ivanna", 7, 20, 5.9f,"ivanna@hotmail.com");
		AlumnoMysql functions = new AlumnoMysql();
		functions.updatePromedio(alumno);
		
		IDataSet connection = getConnection().createDataSet();
		ITable actualTable = connection.getTable("Alumno");
		InputStream xmlFile = getClass().getResourceAsStream("/alumnoExpected.xml");
		IDataSet expectedDataSet = new FlatXmlDataSetBuilder().build(xmlFile);
	    ITable expectedTable = expectedDataSet.getTable("Alumno");
		
		Assertion.assertEquals(expectedTable, actualTable);
	}
	
	
	@Test
	public void ctestGetALL()throws Exception{
		IDataSet connection = getConnection().createDataSet();
		ITable actualTable = connection.getTable("Alumno");
		InputStream xmlFile = getClass().getResourceAsStream("/alumnoExpected.xml");
		IDataSet expectedDataSet = new FlatXmlDataSetBuilder().build(xmlFile);
	    ITable expectedTable = expectedDataSet.getTable("Alumno");
		Assertion.assertEquals(expectedTable, actualTable);
	}

	@Override
	protected IDataSet getDataSet() throws Exception {
		InputStream xmlFile = getClass().getResourceAsStream("/alumno.xml");
		return new FlatXmlDataSetBuilder().build(xmlFile);
	}

}
