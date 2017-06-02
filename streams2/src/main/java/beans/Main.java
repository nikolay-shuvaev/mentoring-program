package beans;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.BiFunction;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by Nikolai_Shuvaev on 6/2/2017.
 */
public class Main {
    public static void main(String[] args) {
        BiFunction<String, Short, Author> authorProducer = Author::new;
        BiFunction<String, Integer, Book> bookProducer = Book::new;

        Author[] authors = {
                authorProducer.apply("Aurhor Name 1", (short) 25),
                authorProducer.apply("Aurhor Name 2", (short) 23),
                authorProducer.apply("Aurhor Name 3", (short) 43),
                authorProducer.apply("Aurhor Name 4", (short) 45),
                authorProducer.apply("Aurhor Name 5", (short) 32),
                authorProducer.apply("Aurhor Name 6", (short) 36),
        };


        Book[] books = {
                bookProducer.apply("Book title 1", 213),
                bookProducer.apply("Book title 2", 234),
                bookProducer.apply("Book title 3", 976),
                bookProducer.apply("Book title 4", 233),
                bookProducer.apply("Book title 5", 324),
                bookProducer.apply("Book title 6", 534),
                bookProducer.apply("Book title 7", 456),
                bookProducer.apply("Book title 8", 786),
        };

        setupAuthorBookLinks(authors, books);

    }

    private static void setupAuthorBookLinks(Author[] authors, Book[] books) {
        IntStream ints = new Random().ints(0, books.length);
        Arrays.stream(authors).forEach(author -> {
            Book[] bookList = new Book[]{
                    books[ints.findFirst().getAsInt()],
                    books[ints.findFirst().getAsInt()],
            };

            Stream.of(bookList).forEach(b -> {
                b.getAuthors().add(author);
            });

            author.setBooks(Arrays.asList(bookList));
        });

    }


}
