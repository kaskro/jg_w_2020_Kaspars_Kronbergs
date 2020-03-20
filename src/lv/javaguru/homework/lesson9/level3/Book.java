package lv.javaguru.homework.lesson9.level3;

import java.util.Objects;

public class Book {

    private final String author;
    private final String title;

    Book(String author, String title) {
        this.author = getValidValue(author);
        this.title = getValidValue(title);
    }

    private String getValidValue(String value) {
        return value != null ? value : "";
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return Objects.equals(author, book.author) &&
                Objects.equals(title, book.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, title);
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
