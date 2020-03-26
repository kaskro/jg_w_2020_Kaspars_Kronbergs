package lv.javaguru.homework.lesson9.level3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class LibraryTest {

    private Library library;

    @BeforeEach
    void setUp() {
        library = new Library();
    }

    @Test
    void shouldAddBook() {
        library.addBook(createBook("Tests", "Demo"));
        assertEquals(1, library.getSize());
    }

    @Test
    void shouldRemoveBook() {
        library.addBook(createBook("Tests", "Demo"));
        library.removeBook(createBook("Tests", "Demo"));
        assertEquals(0, library.getSize());
    }

    @Test
    void shouldGetBookByTitle() {
        Book testBook = createBook("Tests", "Demo");
        library.addBook(testBook);
        assertEquals(Optional.of(testBook), library.getBookByTitle("Demo"));
    }

    @Test
    void shouldNotGetBookByTitle() {
        Book testBook = createBook("Tests", "Demo");
        library.addBook(testBook);
        assertNotEquals(Optional.of(testBook), library.getBookByTitle("Test"));
    }

    @Test
    void shouldGetBooksByAuthor() {
        Book firstBook = createBook("Test", "Demo");
        Book secondBook = createBook("Other", "Author");
        Book thirdBook = createBook("Test", "Demo2");
        Book fourthBook = createBook("Test", "Demo3");
        Book fifthBook = createBook("Different", "Tests");

        library.addBook(firstBook);
        library.addBook(secondBook);
        library.addBook(thirdBook);
        library.addBook(fourthBook);
        library.addBook(fifthBook);

        Library correctLibrary = new Library();

        correctLibrary.addBook(firstBook);
        correctLibrary.addBook(thirdBook);
        correctLibrary.addBook(fourthBook);
        assertEquals(correctLibrary, library.getBooksByAuthor("Test"));
    }

    private Book createBook(String author, String title) {
        return new Book(author, title);
    }
}