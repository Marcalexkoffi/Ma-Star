/*
package bookstoread;

import java.util.Collections;
import java.util.List;

public class BookShelf {
    public List<String> books() {
        return Collections.emptyList();
}

    public void add(String effectiveJava) {
    }
}
avec ca il une reussite et une erreur
*/
package bookstoread;

import java.time.Year;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/*public class BookShelf {
    private final List<String> books = new ArrayList<>();

    public List<String> books() {
        return Collections.unmodifiableList(books);
    }
/* ... permet d'ajouter plusieurs livres à la liste au lieu de un à un aux qQ
    public void add(String... booksToAdd) {
        Arrays.stream(booksToAdd).forEach(book -> books.add(book));
    }

    public List<String> arrange() {
        return books.stream().sorted().collect(Collectors.toList());
    }
}*/
public class BookShelf {
    private final List<Book> books = new ArrayList<>();

    public List<Book> books() {
        return Collections.unmodifiableList(books);
    }

    public void add(Book... booksToAdd) {
        Arrays.stream(booksToAdd).forEach(books::add);
    }

    public List<Book> arrange() {
        return  arrange(Comparator.naturalOrder());
    }

    public List<Book> arrange(Comparator<Book> criteria) {
        return books.stream().sorted(criteria).collect(Collectors.toList());
    }

    /*public Map<Year, List<Book>> groupByPublicationYear() {
        return  books.stream().collect(Collectors.groupingBy(book ->
                Year.of(book.getPublishedOn().getYear())));
    }*/
    public Map<Year, List<Book>> groupByPublicationYear() {
        return  this.groupBy(book ->
                Year.of(book.getPublishedOn().getYear()));
    }

    public <K> Map<K, List<Book>> groupBy(Function<Book, K> fx) {
        return books.stream().collect(Collectors.groupingBy(fx));
    }
}