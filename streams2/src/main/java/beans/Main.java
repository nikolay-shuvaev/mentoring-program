package beans;

import java.util.*;
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
                bookProducer.apply("Book title 8", 776),
        };

        setupAuthorBookLinks(authors, books);

        long bookWithManyPages = Stream.of(books)
                .filter(book -> book.getNumberOfPages() > 200)
                .count();

        System.out.println("Number of books with more than 200 - " + bookWithManyPages + " of total " + books.length);

        Optional<Book> max = Arrays.stream(books)
                .max(Comparator.comparingInt(Book::getNumberOfPages));

        Optional<Book> min = Arrays.stream(books)
                .min(Comparator.comparingInt(Book::getNumberOfPages));

        System.out.println("Max pages in a book - " + max.get());
        System.out.println("Min pages in a book - " + min.get());

        Arrays.stream(books)
                .filter(b -> b.getAuthors().size() > 1)
                .forEach(System.out::println);

        System.out.println("-------------");
        Arrays.stream(books)
                .sorted(Comparator.comparingInt(Book::getNumberOfPages).thenComparing(Book::getTitle))
                .forEach(System.out::println);
        System.out.println("-------------");

        Arrays.stream(books)
                .map(Book::getTitle)
                .forEach(System.out::println);
        System.out.println("-------------");

        Arrays.stream(books).parallel()
                .map(Book::getAuthors)
                .peek(b -> {
                })
                .flatMap(List::stream)
                .peek(b -> {
                })
                .distinct()
                .forEach(System.out::println);

        Author workOn = authors[0];

        System.out.println("v1");
        workOn.getBooks().stream()
                .max(Comparator.comparingInt(Book::getNumberOfPages))
                .ifPresent(b -> {
                    System.out.println(b.getTitle());
                });
        System.out.println("v2");

        Arrays.stream(books)
                .filter(book -> book.getAuthors().contains(workOn))
                .max(Comparator.comparingInt(Book::getNumberOfPages))
                .ifPresent(book -> {
                    System.out.println(book.getTitle());
                });
    }

    private static void setupAuthorBookLinks(Author[] authors, Book[] books) {
        IntStream ints = new Random().ints(0, books.length);
        Arrays.stream(authors).forEach(author -> {
            int firstInt = ThreadLocalRandom.current().nextInt(0, books.length);
            int secondInt;
            do {
                secondInt = ThreadLocalRandom.current().nextInt(0, books.length);
            }
            while (firstInt == secondInt);
            Book[] bookList = new Book[]{
                    books[firstInt],
                    books[secondInt],
            };

            Stream.of(bookList).forEach(b -> {
                b.getAuthors().add(author);
            });

            author.setBooks(Arrays.asList(bookList));
        });

    }


}
