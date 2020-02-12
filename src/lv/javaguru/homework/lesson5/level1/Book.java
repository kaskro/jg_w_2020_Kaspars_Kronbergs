package lv.javaguru.homework.lesson5.level1;

import java.util.Objects;

public class Book {
    private String author;
    private String title;
    private int pageCount;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    @Override
    public boolean equals(Object o) {
        boolean isAllValuesEqual = false;
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        if (Objects.equals(author, book.author)) {
            if (Objects.equals(title, book.title)) {
                if (pageCount == book.pageCount) {
                    isAllValuesEqual = true;
                }
            }
        }
        return isAllValuesEqual;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", pageCount=" + pageCount +
                '}';
    }

}
