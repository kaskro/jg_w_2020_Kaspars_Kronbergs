package lv.javaguru.homework.lesson9.level3;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Library {

    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    //pastāstīšu par šo konceptu pirms nodarbības, atgadini lūdzu
    //šeit labāk atgriezt Optinoal<Book>
    public Book getBookByTitle(String title) {
//        Book foundedBook = null;  nodefinē šeit mainīgo
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                return book;//šeit ielik to ja atrod founedBook = book;
            }
        }
         //attiecīgi šeit Optional.of
//        return Optional.of(foundedBook);
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
