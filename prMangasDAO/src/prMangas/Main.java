package prMangas;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//MangaDAO.deleteAllMangas()
		ArrayList<Manga> mangas = new ArrayList<>();
		mangas = MangaDAO.selectAllMangas();
		
		Manga m1 = mangas.get(2);
		MangaDAO.deleteManga(m1);
		//Manga m2 = MangaDAO.findById(2);
		
		mangas = MangaDAO.selectAllMangas();
		
		for (int i = 0; i < mangas.size(); i++) {
			System.out.println(mangas.get(i).getName());
		}
		
		//System.out.println(MangaDAO.findById(4).getName());
		
		//MangaDAO.insertManga(new Manga("Shadow House", "Somato", 200)); 
	}

}
