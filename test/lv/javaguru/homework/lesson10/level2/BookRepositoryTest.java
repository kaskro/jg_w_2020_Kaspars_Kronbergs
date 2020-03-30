package lv.javaguru.homework.lesson10.level2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

//ok
class BookRepositoryTest {

    private BookRepository bookRepository;

    @BeforeEach
    void setUp() {
        bookRepository = new BookRepository();
    }

    @Test
    void shouldSaveBook() {
        Book book = new Book("Random book", "John Doe", 100);
        bookRepository.save(book);
        assertEquals(1, bookRepository.getRepository().size());
    }

    @Test
    void shouldDeleteBook() {
        Book book = new Book("Random book", "John Doe", 100);
        bookRepository.save(book);
        bookRepository.delete("1");
        assertEquals(0, bookRepository.getRepository().size());
    }

    @Test
    void shouldGetErrorWhenIdNotFoundDeleting() {
        Book book = new Book("Random book", "John Doe", 100);
        bookRepository.save(book);
        try {
            bookRepository.delete("3");
            fail();
        } catch (ItemNotFoundException e) {
            assertEquals("Item with id = \"3\" not found.", e.getMessage());
        }
    }

    @Test
    void shouldGetBookById() {
        Book book = new Book("Random book", "John Doe", 100);
        bookRepository.save(book);
        assertEquals(book, bookRepository.findById("1"));
    }


    @Test
    void shouldGetErrorWhenIdNotFoundWhenFindingById() {
        Book book = new Book("Random book", "John Doe", 100);
        bookRepository.save(book);
        try {
            Book foundBook = bookRepository.findById("3");
            fail();
        } catch (ItemNotFoundException e) {
            assertEquals("Item with id = \"3\" not found.", e.getMessage());
        }
    }

    @Test
    void shouldFindAllBooks() {
        Book firstBook = new Book("Random book", "John Doe", 100);
        Book secondBook = new Book("That book", "Mon Moe", 300);
        Book thirdBook = new Book("This book", "Jo Roe", 400);

        List<Book> testList = new ArrayList<>();
        testList.add(firstBook);
        testList.add(secondBook);
        testList.add(thirdBook);

        bookRepository.save(firstBook);
        bookRepository.save(secondBook);
        bookRepository.save(thirdBook);

        assertEquals(testList, bookRepository.findAll());
    }
}