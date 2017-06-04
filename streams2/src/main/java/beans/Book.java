package beans;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nikolai_Shuvaev on 6/2/2017.
 */
public class Book {
    private String title;
    private List<Author> authors = new ArrayList<>();
    private int numberOfPages;

    public Book(String title, Integer numOfPages) {
        this.title = title;
        this.numberOfPages = numOfPages;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", authors=" + authors +
                ", numberOfPages=" + numberOfPages +
                '}';
    }
}
