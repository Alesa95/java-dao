package prSeriesDAO;

import java.util.ArrayList;

import dao.SerieDao;
import dao.TemporadaDao;
import pojo.Serie;
import pojo.Temporada;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SerieDao serieDao = new SerieDao();
		TemporadaDao temporadaDao = new TemporadaDao();
		
		//	Creamos las series localmente
		Serie s1 = new Serie("Mobile Suit Gundam: The Witch from Mercury", 13, "Cruncyroll");
		Serie s2 = new Serie("Bocchi the Rock!", 13, "Cruncyroll");
		
		//	Insertamos las series en la BD a través de SerieDao
		serieDao.insert(s1); 
		serieDao.insert(s2);
		
		Serie s_id1 = serieDao.getById(1);
		Serie s_id2 = serieDao.getById(2);
		
		//	Creamos las temporadas localmente
		Temporada t1 = new Temporada(1, "Mobile Suit Gundam: The Witch from Mercury Part 1", s_id1);
		Temporada t2 = new Temporada(2, "Mobile Suit Gundam: The Witch from Mercury Part 2", s_id1);
		Temporada t3 = new Temporada (1, "Bocchi the Rock! Season 1", s_id2);
		
		//	Insertamos las temporadas en la BD a través de TemporadaDao
		temporadaDao.insert(t1); 
		temporadaDao.insert(t2); 
		temporadaDao.insert(t3); 
		
		/*ArrayList<Temporada> temporadas = serieDao.getTemporadas(s_id2);
		
		for (int i = 0; i < temporadas.size(); i++) {
			System.out.println(temporadas.get(i).getTitulo());
		}*/
	}

}
