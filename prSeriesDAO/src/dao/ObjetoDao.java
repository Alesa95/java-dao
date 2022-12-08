package dao;

import java.sql.Connection;
import java.sql.SQLException;

import util.DatabaseConnection;

public class ObjetoDao {
	
	private static Connection connection;

	/**
	 * Abre la conexión con la base de datos
	 * 
	 * @return	una instancia del objeto Connection con la conexión a la
	 * base de datos especificada en la clase DatabaseConnection
	 */
	protected static Connection openConnection() {
		
		DatabaseConnection dbConnection = new DatabaseConnection();
		connection = dbConnection.getConnection();
		return connection;
	}
	
	/**
	 * Cierra la conexion con la base de datos
	 */
	protected static void closeConnection() { 
		try {
			connection.close();
			connection = null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
