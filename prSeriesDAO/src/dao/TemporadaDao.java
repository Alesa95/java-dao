package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

import pojo.Temporada;
import util.DatabaseConnection;

public class TemporadaDao implements Dao<Temporada> {
	
	private static Connection connection;
	
	public TemporadaDao () {
		
	}

	@Override
	public ArrayList getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Temporada getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Temporada t) {
		// TODO Auto-generated method stub
		Connection connection = openConnection();
		
		try {
			String query = "insert into temporadas (num_temporada, titulo, serie_id) values (?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, t.getNum_temporada());
			preparedStatement.setString(2, t.getTitulo());
			preparedStatement.setInt(3, t.getSerie().getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();
	}

	@Override
	public void modify(Temporada t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Temporada t) {
		// TODO Auto-generated method stub
		
	}
	
//	Método para abrir la conexión
	private static Connection openConnection() {
		
		DatabaseConnection dbConnection = new DatabaseConnection();
		connection = dbConnection.getConnection();
		return connection;
	}
	
	//	Método para abrir la conexión
	private static void closeConnection() {
		try {
			connection.close();
			connection = null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
