package prSeriesDAO;

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
		//Temporada t = new Temporada(1, "Mobile Suit Gundam: The Witch from Mercury Part 1", s);
		TemporadaDao temporadaDao = new TemporadaDao();
		
		System.out.println(s); 
		
		//temporadaDao.insertar(t); 
		System.out.println(serieDao.getTemporadas(s));
	}

}
