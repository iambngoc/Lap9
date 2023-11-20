package Lap9;

public class Magazine extends Book {
	private String name;

	public Magazine(String title, int page, int year, String author, int price, String name) {
		super(title, page, year, author, price);
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public String typeOfBook() {
		return "Magazine";
	}

	@Override
	public boolean checkTypeAndYear() {
		return 2021 - this.getYear() == 10;
	}

	@Override
	public int getMaxChap() {
		return -1;
	}

	@Override
	public boolean isMagazineHaveName(String name) {
		return this.getName().equals(name);
	}

	@Override
	public void addChapter(Chapter chapter) {
	}

	@Override
	public String toString() {
		return this.title + " " + this.year;
	}
}
