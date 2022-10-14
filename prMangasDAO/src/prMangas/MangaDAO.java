package prMangas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public abstract class MangaDAO {
	
	private static Connection connection;
	
	public static ArrayList<Manga> selectAllMangas() {
		
		ArrayList<Manga> mangas = new ArrayList<>();
		
		Connection connection = openConnection();
		
		try {
			String query = "select * from mangas";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				mangas.add(new Manga(
						resultSet.getInt("id"),
						resultSet.getString("name"),
						resultSet.getString("author"),
						resultSet.getInt("pages")
				));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mangas;
	}
	
	public static Manga findById (int id) {
		Manga manga = null;
		
		Connection connection = openConnection();
				
		try {
			String query = "select * from mangas where id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				manga = new Manga(
						resultSet.getInt("id"),
						resultSet.getString("name"),
						resultSet.getString("author"),
						resultSet.getInt("pages")
				);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return manga;
	}
	
	public static void insertManga(Manga manga) {
		Connection connection = openConnection();
				
		try {
			String query = "insert into mangas (name, author, pages) values (?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, manga.getName());
			preparedStatement.setString(2, manga.getAuthor());
			preparedStatement.setInt(3, manga.getPages());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void updateManga (Manga manga) {
		int id = manga.getId();
		String name = manga.getName();
		String author = manga.getAuthor();
		int pages = manga.getPages();
		Connection connection = openConnection();
		try {
			String query = "update mangas set name = ?, author = ?, pages = ? WHERE id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, author);
			preparedStatement.setInt(3, pages);
			preparedStatement.setInt(4, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();
	}
	
	//	Método para eliminar un manga
	public static void deleteManga(Manga manga) {
		int id = manga.getId();
		Connection connection = openConnection();
		try {
			String query = "delete from mangas where id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();
	}
	
	//	Método para eliminar todos los mangas
	public static void deleteAllMangas() {
		Connection connection = openConnection();
		try {
			Statement smt = connection.createStatement();
			smt.executeUpdate("delete from mangas");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();
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
