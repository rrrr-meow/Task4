package sructure;

public class BookJSON {
    private String genre;
    private String author;
    private Integer year;

    public String getAuthor() {return this.author;}
    public Integer getYear() {return this.year;}
    public void setYear(Integer year) {
        this.year = year;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getGenre() {
        return this.genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
}
