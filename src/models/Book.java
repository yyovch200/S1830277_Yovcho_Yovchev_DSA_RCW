/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Yovcho Yovchev
 */
public class Book implements Comparable<Book>{
    private final int bookISBN;
    private String bookTitle;
    private String author;
    private String Publisher;
    private String NumPages;
    private String PublicDate;
    private String Format;
    private String Genre;
    private String NumBorrows;
    
    
    private static int lastISBNAllocated = 0;

 public Book () {
        this.bookISBN = ++lastISBNAllocated;
        this.bookTitle = "TBC";
        this.author = "TBC";
        this.Publisher = "TBC";
        this.NumPages = "TBC";
        this.PublicDate = "TBC";
        this.Format = "TBC";
        this.Genre = "TBC";
        this.NumBorrows= "TBC";
    }

    public Book(int bookISBN, String bookTitle, String author,  String Publisher, String NumPages, String PublicDate, String Format, String Genre) {
        this.bookISBN = bookISBN;
        this.bookTitle = bookTitle;
        this.author = author;
        this.Publisher = Publisher;
        this.NumPages = NumPages;
        this.PublicDate = PublicDate;
        this.Format = Format;
        this.Genre = Genre;
        this.NumBorrows= NumBorrows;
    }
    
    public Book(String bookTitle) {
    this.bookISBN = ++lastISBNAllocated;
    this.bookTitle = bookTitle;
    }

    public int getBookISBN() {
    return bookISBN;
    }
    
    public String getbookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String Author) {
        this.author = author;
    }
  public String getPublisher() {
        return Publisher;
    }

    public void setPublisher(String Publisher) {
        this.Publisher= Publisher;
    }
    public String getNumPages() {
        return NumPages;
    }

    public void setNumPages(String NumPages) {
        this.NumPages = NumPages;
    }

   
    public String getPublicDate() {
        return PublicDate;
    }

    public void setPublicDate(String PublicDate) {
        this.PublicDate = PublicDate;
    }

    public String getFormat() {
        return Format;
    }

    public void setFormat(String Format) {
        this.Format = Format;
    }

    public String getGenre() {
        return Genre;
    }

    public void setGenre(String Genre) {
        this.Genre = Genre;
    }
    
    public String getNumBorrows(){
            return NumBorrows;
    }
    public String setNumBorrows(String NumBorrows) {
        this.NumBorrows= NumBorrows;
    }
    public static int getLastISBNAllocated() {
        return lastISBNAllocated;
    }

    public static void setLastISBNAllocated(int lastISBNAllocated) {
        Book.lastISBNAllocated = lastISBNAllocated;
    }
    
    public void display() {
        
        String s = this.getBookISBN() + " " + this.getbookTitle() + " " + this.getAuthor() + " " + this.getPublisher() + " " + this.getNumPages() + " " + this.getPublicDate() + " " + this.getFormat() + " " + this.getGenre()+ " " + this.getNumBorrows() ;
        System.out.println(s);
    }

    public String toString(){
        return "\nBookISBN:"+ this.bookISBN
         + "\nTitle:"+ this.bookTitle
         + "\nAuthor:"+ this.author
         + "\nPublisher:"+ this.Publisher
         + "\nNumberPages:"+ this.NumPages
         + "\nPublicDate:"+ this.PublicDate
         + "\nFormat:"+ this.Format
         + "\nGenre:"+ this.Genre
         + "\nNumberBorrows:"+ this.NumBorrows;     
    }
   
    @Override
    public int compareTo(Book book) {
     return this.author.compareTo(Book.author);
        }
}
