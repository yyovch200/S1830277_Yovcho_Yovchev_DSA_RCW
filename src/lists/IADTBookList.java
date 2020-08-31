/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lists;

import models.Book;



public interface IADTBookList {

    public void createList();

    public void printList();
    
    public int length();
    
    public Object getItemAtIndex(int n);
    
    public boolean insert(Book s);

    public String remove(String s);

    public boolean find(String s);
    
}