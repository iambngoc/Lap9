package Lap9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Publication {
	private List<Book> listBook;

	public Publication() {
		this.listBook = new ArrayList<>();
	}

	public List<Book> getListBook() {
		return listBook;
	}

	public int sumPrice() {
		int result = 0;
		for (Book book : listBook) {
			result += book.getPrice();
		}
		return result;
	}

	public Book getMaxChapRefBook() {
		Book result = null;
		int maxChap = 0;
		for (Book book : listBook) {
			if (book.getMaxChap() > maxChap) {
				maxChap = book.getMaxChap();
				result = book;
			}
		}
		return result;
	}

	public boolean isMagazineHaveName(String name) {
		for (Book book : listBook) {
			if (book.isMagazineHaveName(name))
				return true;
		}
		return false;
	}

	public List<Book> getBooksWithYear(int year) {
		List<Book> result = new ArrayList<>();
		for (Book book : listBook) {
			if (book.isSameYear(year))
				result.add(book);
		}
		return result;
	}

	public void sortBook() {
		listBook.sort(new Comparator<Book>() {
			@Override
			public int compare(Book o1, Book o2) {
				if (o1.getTitle().compareTo(o2.getTitle()) == 0) {
					return o2.getYear() - o1.getYear();
				} else
					return o1.getTitle().compareTo(o2.getTitle());
			}
		});
	}

	public Map<Integer, Integer> getBookByYear() {
		Map<Integer, Integer> result = new HashMap<>();
		for (Book book : listBook) {
			result.put(book.getYear(), result.getOrDefault(book.getYear(), 0) + 1);
		}
		return result;
	}

	public void add(Book book) {
		this.listBook.add(book);
	}

	public static void main(String[] args) {
		Book b1 = new Magazine("A", 50, 2011, "Tom", 100, "Time");
		Book b2 = new Magazine("B", 50, 2021, "Mi", 200, "Rose");
		Book b3 = new Magazine("C", 50, 2023, "Li", 100, "My");
		Book b4 = new ReferenceBook("C", 50, 2020, "Jyn", 100, "Y học");
		Book b5 = new ReferenceBook("C", 50, 2020, "Jyn", 100, "Kinh tế");

		Chapter c1 = new Chapter("1", 30);
		Chapter c2 = new Chapter("2", 40);
		Chapter c3 = new Chapter("3", 50);
		Chapter c4 = new Chapter("I", 50);
		Chapter c5 = new Chapter("II", 50);
		Chapter c6 = new Chapter("III", 50);
		
		b4.addChapter(c1);
		b4.addChapter(c2);
		b4.addChapter(c3);
		b5.addChapter(c4);
		b5.addChapter(c5);
		b5.addChapter(c6);
		
		Publication p = new Publication();
		p.add(b1);
		p.add(b2);
		p.add(b3);
		p.add(b4);
		p.add(b5);
		
        System.out.println(b4.typeOfBook());
        System.out.println(b1.checkTypeAndYear());
        System.out.println(b2.checkTypeAndYear());
        System.out.println(b4.isSameTypeAndAuthor(b5));
        System.out.println(p.sumPrice());
        System.out.println(p.getMaxChapRefBook());
        System.out.println(p.isMagazineHaveName("Time"));
        System.out.println(Arrays.toString(p.getBooksWithYear(2020).toArray()));
        p.sortBook();
        System.out.println(Arrays.toString(p.listBook.toArray()));
        System.out.println(p.getBookByYear());
	}
}
