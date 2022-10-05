package prMangas;

public class Manga {
	
	private int id;
	private String name;
	private String author;
	private int pages;

	public Manga (int id, String name, String author, int pages) {
		this.id = id;
		this.name = name;
		this.author = author;
		this.pages = pages;
	}
	
	public Manga (String name, String author, int pages) {
		this.name = name;
		this.author = author;
		this.pages = pages;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}
}
