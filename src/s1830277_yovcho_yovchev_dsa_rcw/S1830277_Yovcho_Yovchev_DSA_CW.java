/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s1830277_yovcho_yovchev_dsa_rcw;

import models.BookBST;
import models.Book;
import lists.BookList;
import java.util.*;
import java.io.File;
import java.io.IOException;
import helpers.InputHelper;
import java.io.FileNotFoundException;

/**
 *
 * @author Yovcho Yovchev
 */
public class S1830277_Yovcho_Yovchev_DSA_CW {

    static char DELIMITER = ',';

    BookList bookList = new BookList();

   
    public static void main(String[] args) throws IOException {
        S1830277_Yovcho_Yovchev_DSA_CW s1830277_Yovcho_Yovchev_DSA_CW = new S1830277_Yovcho_Yovchev_DSA_CW();
        s1830277_Yovcho_Yovchev_DSA_CW.testHarness2();
        s1830277_Yovcho_Yovchev_DSA_CW.run();
    }

 
    private static void testHarness1() {
        System.out.println("Test Harness\n=====================\n\n");
        Book book = new Book();
        System.out.println("ISBN: " + book.getBookISBN());
        System.out.println("Book Title: " + book.getBookTitle());
        System.out.println("Author: " + book.getAuthor());
        System.out.println("Publisher: " + book.getPublisher());
        System.out.println("Number of Pages: " + book.getNumPages());
        System.out.println("Publishing Date: " + book.getPublicDate());
        System.out.println("Format: " + book.getFormat());
        System.out.println("Genre: " + book.getGenre());
        System.out.println("Number of Borrows"+ book.getNumBorrows());
    }
   
    private void testHarness2() {
        Book book1 = new Book(1,"Pod Igoto","Ivan Vazov","Prosveta","418","08.07.1894","E-Book","Historical","10");
        Book book2 = new Book(2,"Harry Potter and the Half-Blood Prince","J. K. Rowling","Bloomsbury","607","16.07.2005","Audio Book","Fantasy","3");
        Book book3 = new Book(3,"IT","Stephen King","Viking","1138","15.09.1986","E-Book","Horror", "6");
        Book book4 = new Book(4,"The Fellowship of the Ring","J. R. R. Tolkien","Allen & Unwin","‎423","29.07.1954","Audio Book","Fantasy", "15");
        Book book5 = new Book(5,"The Two Towers","J. R. R. Tolkien","Allen & Unwin","352","24.07.2007","Audio Book","Fantasy", "10");
        BookList.addBook(book1);
        BookList.addBook(book2);
        BookList.addBook(book3);
        BookList.addBook(book4);
        BookList.addBook(book5);
    }  
    
   
        private void run() {
        boolean finished = false;
        do {
            char choice = displayMenu();
            switch (choice) {
                case 'A':
                    addBook();
                    break;
                case 'B':
                    findBookByISBN();
                    break;
                case 'C':
                    findBookByTitle();
                    break;
                case 'D':
                    findBookByAuthor();
                    break;
                case 'E':
                    findBookByGenre();
                    break;
                case 'F':
                    BookList.displayAllBooks();
                    break;                    
                case 'G':
                    finished = true;
            }
        } while (!finished);
    }
            
    /**
     * Shows the menu options [A-Q]
     */
        private char displayMenu() {
        InputHelper inputHelper = new InputHelper();
        System.out.print("\nA. Add a book");
        System.out.print("\tB. Display a book");
        System.out.print("\tC. Search for a specific book by Title");
        System.out.print("\tD. Search for a specific book by Author");
        System.out.print("\tE. Display all books for a given genre in the list");
        System.out.print("\tF. Display all books in the list");
        System.out.print("\tG. Exit\n");
        return inputHelper.readChar("Enter choice", "ABCDEFQ");
    }

    /**
     * Adds a song to the Tracklist
     */
        public void addBook() {
        System.out.format("\033[32m%s\033[0m%n", "Add new Book");
        System.out.format("\033[32m%s\033[0m%n", "==============");
        InputHelper inputHelper = new InputHelper();
        boolean validBook = false;
        Book requiredBook = null;
        do {
            int bookISBN = inputHelper.readInt("Enter Book ISBN");
            requiredBook = BookList.findBook(bookISBN);
            if (requiredBook == null) {
                validBook = true;
                String bookTitle = inputHelper.readString("Enter Book Title");
                String Author = inputHelper.readString("Enter Author Name");
                String Publisher = inputHelper.readString("Enter Publisher Name");
                String NumPages = inputHelper.readString("Enter Number of Pages");
                String PubDate = inputHelper.readString("Enter Publishing Date");
                String Format = inputHelper.readString("Enter Format");
                String Genre = inputHelper.readString("Enter Genre");
                String NumBorrows= inputHelper.readString("Enter Number of Borrows");
                Book book = new Book(bookISBN, bookTitle, Author, Publisher, NumPages, PubDate, Format, Genre, NumBorrows);
                BookList.addBook(book);
                System.out.println(book);
                System.out.format("\033[32m%s\033[0m%n", "New Book Successfully added!");
            }
        } while (!validBook);
    }
        
   
    public void findBookISBN() {
        InputHelper inputHelper = new InputHelper();
        Book requiredBook = null;
        int bookISBN = inputHelper.readInt("Enter Book ISBN");
        requiredBook = BookList.findBook(bookISBN);
        if (requiredBook != null) {
            System.out.println(requiredBook.toString());
        } else {
            System.out.println("Book is not found, please try again with different ISBN");
        }
    }

    /**
     * Searches for a specific song by Song Title
     */
    public Book findBookTitle() throws FileNotFoundException {
        InputHelper inputHelper = new InputHelper();
        File file = new File("ExternalData.txt");
        Scanner scanner = new Scanner(file);
        String Author = inputHelper.readString("Enter Author");
        Book bookType = null;
        bookType = BookList.findBookAuthor(Author);
        BookBST BookBST = new BookBST();
        BookBST.makeTree(scanner);
        BookBST.printAuthor();
        return null;
    }
   
   
    private void findBookByISBN() {
        InputHelper inputHelper = new InputHelper();
        Book requiredBook = null;
        int bookISBN = inputHelper.readInt("Enter Book ISBN");
        requiredBook = BookList.findBookByISBN(bookISBN);
        if (requiredBook != null) {
            System.out.println(requiredBook.toString());
        } else {
            System.out.println("Book is not found, please try again with a different ID");
        }
    }
  
   
    private void findBookByTitle() {
        InputHelper inputHelper = new InputHelper();
        Book requiredBook = null;
        String bookTitle = inputHelper.readString("Enter Book Title");
        requiredBook = BookList.findBookByTitle(bookTitle);
        if (requiredBook != null) {
            System.out.println(requiredBook.toString());
        } else {
            System.out.println("Book is not found, please try again with a different Title");
        }
    }
    
    /**
     * Searches for a specific song by Artist name
     */
    private void findBookByAuthor() {
        InputHelper inputHelper = new InputHelper();
        Book requiredBook = null;
        String bookAuthor = inputHelper.readString("Enter Book Author");
        requiredBook = BookList.findBookByAuthor(bookAuthor);
        if (requiredBook != null) {
            System.out.println(requiredBook.toString());
        } else {
            System.out.println("Book is not found, please try again with a different Author");
        }
    }
    
    /**
     * Searches for a specific song by Genre
     */
    private void findBookByGenre() {
        InputHelper inputHelper = new InputHelper();
        String bookGenre = inputHelper.readString("Enter Song Genre");
        BookList.displayByGenre(bookGenre);
    }
}