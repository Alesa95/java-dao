package main;

import java.util.ArrayList;

import dao.SerieDao;
import dao.TemporadaDao;
import pojo.Serie;
import pojo.Temporada;

public class Main {

	public static void main(String[] args) {
		
		//	Instanciamos los Dao
		SerieDao serieDao = new SerieDao();
		TemporadaDao temporadaDao = new TemporadaDao();
		/*
		//	Creamos las series localmente
		Serie s1 = new Serie("Mobile Suit Gundam: The Witch from Mercury", 12, "Cruncyroll");
		Serie s2 = new Serie("Bocchi the Rock!", 12, "Cruncyroll");
		
		//	Insertamos las series en la BD a trav�s de SerieDao
		serieDao.insert(s1); 
		serieDao.insert(s2);
		
		Serie s_id1 = serieDao.getById(1);
		Serie s_id2 = serieDao.getById(2);
		Serie s_id3 = serieDao.getById(3);
		
		//System.out.println(s_id3);
		
		//	Creamos las temporadas localmente
		Temporada t1 = new Temporada(1, "Mobile Suit Gundam: The Witch from Mercury Part 1", s_id1);
		Temporada t2 = new Temporada(2, "Mobile Suit Gundam: The Witch from Mercury Part 2", s_id1);
		Temporada t3 = new Temporada (1, "Bocchi the Rock! Season 1", s_id2);
		
		//	Insertamos las temporadas en la BD a trav�s de TemporadaDao
		temporadaDao.insert(t1); 
		temporadaDao.insert(t2); 
		temporadaDao.insert(t3); 
		
		ArrayList<Temporada> temporadas = serieDao.getTemporadas(s_id2);
		
		for (int i = 0; i < temporadas.size(); i++) {
			System.out.println(temporadas.get(i).getTitulo());
		}
		*/
		ArrayList<Serie>series = serieDao.getAll();
						
		for (int i = 0; i < series.size(); i++) {
			System.out.println("SERIE: " + series.get(i).getTitulo());
			ArrayList<Temporada>temporadas = series.get(i).getTemporadas();
			for (int j = 0; j < temporadas.size(); j++) {
				System.out.println("TEMPORADA: " + temporadas.get(j).getTitulo());
			}
		}
	}

}
