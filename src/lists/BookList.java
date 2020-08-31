/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lists;

import models.Book;


public class BookList extends Book {

    public BookLinkedList linkedList = new BookLinkedList();
    static char DELIMITER = ',';

    public void addBook(Book book) {
        linkedList.insert(book);
        System.out.println("Number of books in the tracklist: " + Count());
    }

    public int Count() {
        return linkedList.length();
    }

    public void displayAllBooks() {
        linkedList.printList();
    }

    public void displayByGenre(String genre) {
        int index = 0;
        while (index < Count()) {
            Book book = linkedList.getItemAtIndex(index);
            if (book.getGenre().equals(genre)) {
                System.out.println(book.toString());
            }
            index++;
        }

    }
    public Book findBookAtIndex(int index) {
        Book book = linkedList.getItemAtIndex(index);
        return book;
    }
    public Book findBook(int id) {
        int index = 0;
        while (index < Count()) {
            Book book = linkedList.getItemAtIndex(index);
            if (book.getBookISBN()== id) {
                return book;
            }
            index++;
        }
        return null;
    }
    public Book findBookTitle(String Title) {
        int index = 0;
        while (index < Count()) {
            Book book = linkedList.getItemAtIndex(index);
            if (book.getBookTitle().equals(Title)) {
                return book;
            }
            index++;
        }
        return null;
    }
    public Book findBookArtist(String Artist) {
        int index = 0;
        while (index < Count()) {
            Book book = linkedList.getItemAtIndex(index);
            if (book.getAuthor().equals(Artist)) {
                return book;
            }
            index++;
        }
        return null;
    }
}
