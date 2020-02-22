package lv.javaguru.homework.lesson5.level1;

//izmanto atsevišķu metodi katram testam
public class BookTest {
    public static void main(String[] args) {
        Book firstBook = new Book();
        firstBook.setAuthor("John Doe");
        firstBook.setTitle("How to be");
        firstBook.setPageCount(100);

        Book secondBook = new Book();
        secondBook.setAuthor("Not John Doe");
        secondBook.setTitle("How not to be");
        secondBook.setPageCount(99);

        Book thirdBook = new Book();
        thirdBook.setAuthor("John Doe");
        thirdBook.setTitle("How to be");
        thirdBook.setPageCount(100);

        System.out.println(firstBook.toString());
        System.out.println(secondBook.toString());
        System.out.println(thirdBook.toString());

        System.out.println("(firstBook == secondBook) = " + firstBook.equals(secondBook));
        System.out.println("(firstBook == thirdBook) = " + firstBook.equals(thirdBook));

    }

}
