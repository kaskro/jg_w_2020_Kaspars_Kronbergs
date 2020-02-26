package lv.javaguru.homework.lesson5.level1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    void shouldGetAuthor() {

        Book book = new Book();

        assertNull(book.getAuthor());
    }

    @Test
    void shouldSetAuthor() {

        String author = "Cesar";

        Book book = new Book();
        book.setAuthor(author);

        assertEquals(author, book.getAuthor());
    }

    @Test
    void shouldGetTitle() {

        Book book = new Book();

        assertNull(book.getTitle());
    }

    @Test
    void shouldSetTitle() {

        String title = "Demo";

        Book book = new Book();
        book.setTitle(title);

        assertEquals(title, book.getTitle());
    }

    @Test
    void shouldGetPageCount() {

        Book book = new Book();

        assertEquals(0, book.getPageCount());
    }

    @Test
    void shouldSetPageCount() {

        int pageCount = 10;

        Book book = new Book();
        book.setPageCount(pageCount);

        assertEquals(pageCount, book.getPageCount());
    }

    @Test
    void shouldBeTrueWhenObjectsAreEqual() {

        String author = "John Doe";
        String title = "How to be";
        int pageCount = 100;

        Book firstBook = new Book();
        firstBook.setAuthor(author);
        firstBook.setTitle(title);
        firstBook.setPageCount(pageCount);

        Book secondBook = new Book();
        secondBook.setAuthor(author);
        secondBook.setTitle(title);
        secondBook.setPageCount(pageCount);

        assertTrue(firstBook.equals(secondBook));
    }

    @Test
    void shouldBeFalseWhenObjectsAreNotEqual() {

        String author = "John Doe";
        String title = "How to be";
        int pageCount = 100;

        Book firstBook = new Book();
        firstBook.setAuthor(author);
        firstBook.setTitle(title);
        firstBook.setPageCount(pageCount);

        Book secondBook = new Book();
        secondBook.setAuthor("Wrong Doe");
        secondBook.setTitle(title);
        secondBook.setPageCount(101);

        assertFalse(firstBook.equals(secondBook));
    }

    @Test
    void shouldReturnTrueWhenStringHasCorrectFormat() {

        String author = "John Doe";
        String title = "How to be";
        int pageCount = 100;
        String correctFormat = "Book{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", pageCount=" + pageCount +
                '}';

        Book book = new Book();
        book.setAuthor(author);
        book.setTitle(title);
        book.setPageCount(pageCount);

        assertEquals(correctFormat, book.toString());
    }
}