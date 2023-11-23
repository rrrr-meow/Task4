package service;

import sructure.BookJSON;
import sructure.BooksJSON;
import sructure.TitleJSON;

import java.util.*;
import java.util.stream.Collectors;

public class DataProcessing {
    private final BooksJSON books;
    public DataProcessing(BooksJSON books) {
        this.books = books;
    }
    public List<TitleJSON> sortByYear(){
        try {
            return this.books.getBooks().stream().sorted(Comparator.comparingInt(book -> book.getBook().getYear())).toList();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    public List<TitleJSON> filterByAuthors(String author){
        try {
            return this.books.getBooks().stream().filter(x -> x.getBook().getAuthor().contains(author)).toList();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    public Set<String> getBooksOfGenre(String genre){
        try {
            return this.books.getBooks().stream().filter(x->x.getBook().getGenre().equals(genre)).map(TitleJSON::getTitle).collect(Collectors.toSet());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Set<String> getGenres(){
        try {
            return this.books.getBooks().stream().map(x->x.getBook().getGenre()).sorted().collect(Collectors.toCollection(LinkedHashSet::new));
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    public String listToString(List<TitleJSON> books){
        StringBuilder result = new StringBuilder();
        books.forEach(x->result.append("Автор: "+x.getBook().getAuthor()+"\n" +
                "Название: " + x.getTitle() + "\n" + "Жанр: " + x.getBook().getGenre()+ "\n" +
                "Год выпуска: " + x.getBook().getYear() + "\n\n"));
        return result.toString();
    }
    public String toString(){
        StringBuilder result = new StringBuilder();
        this.books.getBooks().forEach(x->result.append("Автор: "+x.getBook().getAuthor()+"\n" +
                "Название: " + x.getTitle() + "\n" + "Жанр: " + x.getBook().getGenre()+ "\n" +
                "Год выпуска: " + x.getBook().getYear() + "\n\n"));
        return result.toString();
    }
}
