package com.everis.nttdatacenters_jdbc_t1_frm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main( String[] args )
	{
		conectar();
	}
	public static  void conectar()
	{
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/academiaTenis?serverTimezone=UTC";
		String login = "root";
		String password = "Studium2020;";
		String sentencia = "";
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		try
		{
			//Cargar los controladores para el acceso a la BD
			Class.forName(driver);
			//Establecer la conexión con la BD Empresa
			connection = DriverManager.getConnection(url, login, password);
			statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			sentencia = "SELECT idEntrenamiento, ejerciciosEntrenamiento, duracionEntrenamiento, entrenadores.nombreEntrenador  FROM  entrenamientos JOIN entrenadores ON entrenamientos.idEntrenadorFK = entrenadores.idEntrenador;";
			rs = statement.executeQuery(sentencia);
			rs.close();
			connection.close();
		}
		catch (ClassNotFoundException cnfe)
		{
			System.out.println("Error 1-"+cnfe.getMessage());
		}
		catch (SQLException sqle)
		{
			System.out.println("Error 2-"+sqle.getMessage());
		}
	}
	public static void desconectar(Connection con)
	{
		try
		{
			con.close();
		} 
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

