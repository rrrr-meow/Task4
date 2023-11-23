package sructure;

public class TitleJSON {
    private String title;
    private BookJSON book;

    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public BookJSON getBook() {
        return this.book;
    }
    public void setBook(BookJSON book) {
        this.book = book;
    }
    public Boolean isNull()
    {
        if (title == null && book == null) return true;
        else return false;
    }
}