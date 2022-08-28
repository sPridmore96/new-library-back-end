package org.nology;



public class LibraryBook {

    private int id;
    private String title;
    private String author;
    private String genre;
    private String subGenre;
    private String publisher;
    private boolean stock;


    public LibraryBook(int id, String title, String author,
                       String genre, String subGenre, String publisher, boolean stock) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.subGenre = subGenre;
        this.publisher = publisher;
        this.stock = stock;
    }

    public void printBook(){
        System.out.println("id : " + id +
                "\nTitle : " + title +
                "\nAuthor : " + author +
                "\nGenre : " + genre +
                "\nSubGenre : " + subGenre +
                "\nPublisher : " + publisher +
                "\nIs in stock : " + stock +
                "\n");
    }

    public String getSubGenre() {
        return subGenre;
    }

    public void setSubGenre(String subGenre) {
        this.subGenre = subGenre;
    }

    public boolean getStock() {
        return stock;
    }

    public void setStock(boolean stock) {
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

}
