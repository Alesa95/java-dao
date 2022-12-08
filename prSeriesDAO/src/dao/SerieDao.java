package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pojo.Serie;
import pojo.Temporada;

public class SerieDao extends ObjetoDao implements InterfazDao<Serie> {
	
	private static Connection connection;
	
	public SerieDao () {
		
	}
	
	private int getRowCount(ResultSet resultSet) {
	    if (resultSet == null) {
	        return 0;
	    }

	    try {
	        resultSet.last();
	        return resultSet.getRow();
	    } catch (SQLException exp) {
	        exp.printStackTrace();
	    } finally {
	        try {
	            resultSet.beforeFirst();
	        } catch (SQLException exp) {
	            exp.printStackTrace();
	        }
	    }

	    return 0;
	}
			
	@Override
	public ArrayList<Serie> getAll() {
		connection = openConnection();
		
		ArrayList<Serie> series = new ArrayList<>();
		
		try {
			String query = "select * from series";
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs_series = ps.executeQuery();
			
			//getRowCount(resultSet);
			
			while (rs_series.next()) {
				Serie serie = new Serie(
						rs_series.getInt("id"),
						rs_series.getString("titulo"),
						rs_series.getInt("edad"),
						rs_series.getString("plataforma")
				);
				
				ArrayList<Temporada> temporadas = new ArrayList<Temporada>();
				query = "select * from temporadas where serie_id = ?";
				PreparedStatement ps2 = connection.prepareStatement(query);
				ps2.setInt(1, serie.getId()); 
				ResultSet setTemporadas = ps2.executeQuery();
				
				while (setTemporadas.next()) {
					temporadas.add(new Temporada(
							setTemporadas.getInt("id"),
							setTemporadas.getInt("num_temporada"),
							setTemporadas.getString("titulo")
					));
				}
				
				serie.setTemporadas(temporadas); 
				
				series.add(serie);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();
		
		return series;
	}

	@Override
	public Serie getById(int id) {
		// TODO Auto-generated method stub
		connection = openConnection();
		
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
	public void insert(Serie t) {
		// TODO Auto-generated method stub
		connection = openConnection();
		
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
	public void modify(Serie t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Serie t) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * 
	 * @param serie
	 * @return	un ArrayList con las temporadas de la serie
	 */
	public ArrayList<Temporada> getTemporadas(Serie serie) {
		
		ArrayList<Temporada> temporadas = new ArrayList<>();
		
		connection = openConnection();
		
		try {
			String query = "select * from temporadas where serie_id = ?";
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
	
}
