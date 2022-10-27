package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

import pojo.Serie;
import pojo.Temporada;
import util.DatabaseConnection;

public class SerieDao implements Dao<Serie> {
	
	private static Connection connection;
	
	public SerieDao () {
		
	}

	@Override
	public ArrayList<Serie> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Serie getById(int id) {
		// TODO Auto-generated method stub
		Connection connection = openConnection();
		
		Serie serie = null;
		
		try {
			String query = "select * from series where id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				serie = new Serie(
						resultSet.getInt("id"),
						resultSet.getString("titulo"),
						resultSet.getInt("edad"),
						resultSet.getString("plataforma")
				);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();
		
		return serie;
	}

	@Override
	public void insertar(Serie t) {
		// TODO Auto-generated method stub
		Connection connection = openConnection();
		
		try {
			String query = "insert into series (titulo, edad, plataforma) values (?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, t.getTitulo());
			preparedStatement.setInt(2, t.getEdad());
			preparedStatement.setString(3, t.getPlataforma());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();
	}

	@Override
	public void modificar(Serie t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void borrar(Serie t) {
		// TODO Auto-generated method stub
		
	}
	
	public ArrayList<Temporada> getTemporadas(Serie serie) {
		
		ArrayList<Temporada> temporadas = new ArrayList<>();
		
		Connection connection = openConnection();
		
		try {
			String query = "select (id, num_temporada, titulo) from temporadas where id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, serie.getId()); 
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				temporadas.add(new Temporada(
						resultSet.getInt("id"),
						resultSet.getInt("num_temporada"),
						resultSet.getString("titulo")
				));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temporadas;
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
