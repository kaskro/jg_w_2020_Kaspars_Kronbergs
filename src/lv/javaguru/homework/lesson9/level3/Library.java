package lv.javaguru.homework.lesson9.level3;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Library {

    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public Book getBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        return new Book("", "");
    }

    public Library getBooksByAuthor(String author) {
        Library authorBooks = new Library();
        for (Book book : books) {
            if (book.getAuthor().equals(author)) {
                authorBooks.addBook(book);
            }
        }
        return authorBooks;
    }

    public int getSize() {
        return books.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Library)) return false;
        Library library = (Library) o;
        return Objects.equals(books, library.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(books);
    }

    @Override
    public String toString() {
        return "Library{" +
                "books=" + books +
                '}';
    }
}
