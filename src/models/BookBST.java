/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.*;

public class BookBST {

    static final char DELIMITER = ',';
    private final TreeSet<Book> index;


    public BookBST() {
        index = new TreeSet<>();
    }

    public void makeTree(Scanner scan) {
        String line;
        String[] temp;
        while (scan.hasNextLine()) {
                line = scan.nextLine();
                temp = line.split(Character.toString(DELIMITER));
                int isbn = Integer.parseInt(temp[0]);
                String title = temp[1];
                String author = temp[2];
                String publisher = temp[3];
                String NumPages = temp[4];
                String PubDate = temp[5];
                String Format= temp[6];
                String genre = temp[7];
                String NumBorrows = temp[8];
                Book book = new Book(isbn,title,author,publisher,NumPages,PubDate,Format,genre,NumBorrows);
                index.add(book);
        }
    }
    public void printAll() {
        Iterator it = index.iterator();  
        while(it.hasNext())  
        {  
            System.out.println(it.next());  
        }  

    }

    
    public void printAuthor() {
        LinkedHashSet<String> temp = new LinkedHashSet<String>();
        for (Book next : index) {
          temp.add(next.getAuthor());
        }
        for (String element: temp) {
            System.out.println(element);
        }
    }

    
    public void printAllDesc() {
        Iterator it = index.descendingIterator();  
        while(it.hasNext())  
        {  
            System.out.println(it.next());  
        }  


    }

}