package lv.javaguru.homework.lesson5.level1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    private Book book;

    @BeforeEach
    void setUp() {
        book = new Book();
    }

    @Test
    void shouldSetAndGetAuthor() {

        String author = "Cesar";

        book.setAuthor(author);

        assertEquals(author, book.getAuthor());
    }

    @Test
    void shouldSetAndGetTitle() {

        String title = "Demo";

        book.setTitle(title);

        assertEquals(title, book.getTitle());
    }

    @Test
    void shouldGetPageCount() {

        assertEquals(0, book.getPageCount());
    }

    @Test
    void shouldSetPageCount() {

        int pageCount = 10;

        book.setPageCount(pageCount);

        assertEquals(pageCount, book.getPageCount());
    }

    @Test
    void shouldBeEqualsBooks() {

        String author = "John Doe";
        String title = "How to be";
        int pageCount = 100;

        Book firstBook = createBook(author, title, pageCount);

        Book secondBook = createBook(author, title, pageCount);

        assertTrue(firstBook.equals(secondBook));
    }

    private Book createBook(String author, String title, int pageCount) {
        book = new Book();
        book.setAuthor(author);
        book.setTitle(title);
        book.setPageCount(pageCount);
        return book;
    }

    @Test
    void shouldNotBeEqualsBooks() {

        String author = "John Doe";
        String title = "How to be";
        int pageCount = 100;

        Book firstBook = createBook(author, title, pageCount);

        Book secondBook = createBook("Wrong Doe", title, 101);

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


        book.setAuthor(author);
        book.setTitle(title);
        book.setPageCount(pageCount);

        assertEquals(correctFormat, book.toString());
    }
}