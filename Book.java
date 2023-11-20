package Lap9;

import java.util.*;

public abstract class Book {
	protected String title;
	protected int page;
	protected int year;
	protected String author;
	protected int price;

	public Book(String title, int page, int year, String author, int price) {
		this.title = title;
		this.page = page;
		this.year = year;
		this.author = author;
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public int getPage() {
		return page;
	}

	public int getYear() {
		return year;
	}

	public String getAuthor() {
		return author;
	}

	public int getPrice() {
		return price;
	}

	public abstract String typeOfBook();

	public abstract boolean checkTypeAndYear();

	public boolean isSameTypeAndAuthor(Book other) {
		return this.getClass() == other.getClass() && this.getAuthor().equals(other.getAuthor());
	}

	public abstract int getMaxChap();

	public abstract boolean isMagazineHaveName(String name);

	public boolean isSameYear(int year) {
		return this.getYear() == year;
	}

	public abstract void addChapter(Chapter chapter);

}
