/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lists;

import java.util.LinkedList;
import models.Book;


public class BookLinkedList implements IADTBookList{
    
    
     public BookLinkedList () {
 
    }
    
    
    @Override
    public void createList() {
        this.start = 0;       
        this.noOfElements = 0;     
    }


    @Override
    public void printList() {
        int blp = this.start;
        System.out.println( String.format( "Printing book list of %d books", this.noOfElements ) );
        int count = 0;
        while ( validAccess( blp ) ) {
            count ++;
            Book book = linkedList.get(blp);
            System.out.println( String.format( "Book(%d):%s", count, book.getBookTitle() ) );
            blp --;
        }
    }
    @Override
    public boolean insert( Book b ) {
        boolean ok = true;
        int nextPosition = this.noOfElements;
        System.out.println( String.format( "Trying to insert books: %s at position %d", b, nextPosition ) );
        if ( ! arrayListFull( nextPosition ) ) {
           
            linkedList.add(b);
            this.start = nextPosition;
            this.noOfElements ++;
        } else {
          
            System.out.println( "List Full - Unable to add books " + b );
            ok = false;
        }
        return ok;
    }
    @Override
    public Book getItemAtIndex(int n){
        if(validAccess(n)){
            return linkedList.get(n);
        }
        return null;
    }
   
    @Override
    public boolean find(String searchString) {
        int blp = start;

        while ( validAccess( blp ) )  {
            System.out.println( String.format( "checking Data: %s at positon %d", searchString, blp ) );
            if ( searchString.equals( linkedList.get(blp) ) ) return true;
            blp --;
        }
        
        return false;
    }
    
    @Override
    public String remove(String searchString) {
        int current = start;  
        boolean stillSearching = true;
        while ( validAccess( current ) && stillSearching )  {
            System.out.println( "Comparing: " + searchString + " with " + linkedList.get(current) );
            if ( ! searchString.equals( linkedList.get(current) ) ) {
                
                current --;
            } else {
               
               for ( int index = current + 1; index < this.noOfElements ; index ++ )
                   linkedList.set( index - 1, linkedList.get(index) );
               this.noOfElements --;  
               this.start = this.noOfElements - 1;
               current = ILLEGALARRAYINDEX; 
               stillSearching = false;
            }
        }
        if ( stillSearching ) {
            
            return "Element not found in list";
        } else {
            return searchString;
        }
}

    public int length() {
        return this.noOfElements;
    }

    public String toString() {
        int blp = this.start;
        String listString =  "";
        int count = 0;
        while ( validAccess( blp ) ) {
            count ++;
            listString += String.format( "(%d) ==> %s", count, linkedList.get(blp) );
            blp ++;
        }
        return listString;
    }


    protected int start = 0;


    private final int MAXNOOFELEMENTS = 10;    
    private int noOfElements = 0;
    private int ILLEGALARRAYINDEX = -999;   // anything outside the array subscript range

    private LinkedList<Book> linkedList = new LinkedList<Book>();

    private boolean inRange( int index, int min, int max ) {
        return ( ( min <= index ) && ( index < max ) );
    }

    private boolean validAccess( int index ) {
        return ( inRange( index, 0, this.noOfElements ) );
    }

    private boolean arrayListFull( int index ) {
        return ( ! inRange( index, 0, MAXNOOFELEMENTS ) );
    }

    private enum WhereInList { FIRST, MIDDLE, LAST };


}