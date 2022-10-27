package prSeriesDAO;

import java.util.ArrayList;

import dao.SerieDao;
import dao.TemporadaDao;
import pojo.Serie;
import pojo.Temporada;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Serie s = new Serie("Mobile Suit Gundam: The Witch from Mercury", 13, "Cruncyroll");
		SerieDao serieDao = new SerieDao();
		//serieDao.insertar(s); 
		Serie s = serieDao.getById(2);
		//Temporada t = new Temporada(2, "Mobile Suit Gundam: The Witch from Mercury Part 2", s);
		TemporadaDao temporadaDao = new TemporadaDao();
		//temporadaDao.insertar(t); 
		
		System.out.println(s); 
		
		ArrayList<Temporada> temporadas = serieDao.getTemporadas(s);
		
		for (int i = 0; i < temporadas.size(); i++) {
			System.out.println(temporadas.get(i).getTitulo());
		}
	}

}
