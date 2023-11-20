package Lap9;

import java.util.ArrayList;
import java.util.List;

public class ReferenceBook extends Book {
	private List<Chapter> chapters;
	private String field;

	public ReferenceBook(String title, int page, int year, String author, int price, String field) {
		super(title, page, year, author, price);
		this.chapters = new ArrayList<>();
		this.field = field;
	}

	@Override
	public String typeOfBook() {
		return "Reference Book";
	}

	@Override
	public boolean checkTypeAndYear() {
		return false;
	}

	public int getMaxChap() {
		int result = 0;
		for (Chapter chapter : chapters) {
			if (chapter.getChapPage() > result)
				result = chapter.getChapPage();
		}
		return result;
	}

	@Override
	public boolean isMagazineHaveName(String name) {
		return false;
	}

	@Override
	public String toString() {
		return  this.title + " " + this.year;
	}

	@Override
	public void addChapter(Chapter chapter) {
		this.chapters.add(chapter);
	}
}