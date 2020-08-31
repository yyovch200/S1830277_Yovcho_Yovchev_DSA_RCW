/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trees;

/**
 * Interface to define a search tree
 * @author Koffman and Wolfgang
 * @param <E>
 **/
public interface SearchTree<E extends Comparable<E>>  {

 
    boolean add(E item);

    boolean contains(E target);

    E find(E target);

    E delete(E target);

    boolean remove(E target);
}