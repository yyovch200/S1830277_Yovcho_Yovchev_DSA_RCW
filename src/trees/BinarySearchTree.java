/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trees;

import java.util.List;
import java.util.ArrayList;
import trees.SearchTree;

/**
 * A class to represent a binary search tree.
 * @author Koffman and Wolfgang
 * @param <E>
 */
public class BinarySearchTree<E extends Comparable<E>>
        extends BinaryTree<E>
        implements SearchTree<E>
{

    protected boolean addReturn;
   
    protected E deleteReturn;

    
    public E find(E target) {
        return find(root, target);
    }

    private E find(Node<E> localRoot, E target) {
        if (localRoot == null) {
            return null;
        }

        int compResult = target.compareTo(localRoot.data);
        if (compResult == 0) {
            return localRoot.data;
        } else if (compResult < 0) {
            return find(localRoot.left, target);
        } else {
            return find(localRoot.right, target);
        }
    }
    
    public boolean add(E item) {
        root = add(root, item);
        return addReturn;
    }

   
    private Node<E> add(Node<E> localRoot, E item) {
        if (localRoot == null) {
           
            addReturn = true;
            return new Node<>(item);
        } else if (item.compareTo(localRoot.data) == 0) {
           
            addReturn = false;
            return localRoot;
        } else if (item.compareTo(localRoot.data) < 0) {
           
            localRoot.left = add(localRoot.left, item);
            return localRoot;
        } else {
         
            localRoot.right = add(localRoot.right, item);
            return localRoot;
        }
    }
    
    public E delete(E target) {
        root = delete(root, target);
        return deleteReturn;
    }

    private Node<E> delete(Node<E> localRoot, E item) {
        if (localRoot == null) {
            
            deleteReturn = null;
            return localRoot;
        }

       
        int compResult = item.compareTo(localRoot.data);
        if (compResult < 0) {
            
            localRoot.left = delete(localRoot.left, item);
            return localRoot;
        } else if (compResult > 0) {
            
            localRoot.right = delete(localRoot.right, item);
            return localRoot;
        } else {
            
            deleteReturn = localRoot.data;
            if (localRoot.left == null) {
               
                return localRoot.right;
            } else if (localRoot.right == null) {
               
                return localRoot.left;
            } else {
                
                if (localRoot.left.right == null) {
                    
                    localRoot.data = localRoot.left.data;
                    
                    localRoot.left = localRoot.left.left;
                    return localRoot;
                } else {
                    
                    localRoot.data = findLargestChild(localRoot.left);
                    return localRoot;
                }
            }
        }
    }
    
    public boolean remove(E target) {
        return delete(target) != null;
    }

    public boolean contains(E target) {
        return find(target) != null;
    }
    
    private E findLargestChild(Node<E> parent) {
        
        if (parent.right.right == null) {
            E returnValue = parent.right.data;
            parent.right = parent.right.left;
            return returnValue;
        } else {
            return findLargestChild(parent.right);
        }
    }
   
    public E deletePrime(E target) {
        root = deletePrime(root, target);
        return deleteReturn;
    }

    private Node<E> deletePrime(Node<E> localRoot, E item) {
        if (localRoot == null) {
            
            deleteReturn = null;
            return localRoot;
        }

       
        int compResult = item.compareTo(localRoot.data);
        if (compResult < 0) {
            
            localRoot.left = deletePrime(localRoot.left, item);
            return localRoot;
        } else if (compResult > 0) {
           
            localRoot.right = deletePrime(localRoot.right, item);
            return localRoot;
        } else {
            
            deleteReturn = localRoot.data;
            if (localRoot.left == null) {
                
                return localRoot.right;
            } else if (localRoot.right == null) {
               
                return localRoot.left;
            } else {
                
                if (localRoot.right.left == null) {
                    
                    localRoot.data = localRoot.right.data;
                   
                    localRoot.right = localRoot.right.right;
                    return localRoot;
                } else {
                   
                    localRoot.data = findSmallestChild(localRoot.right);
                    return localRoot;
                }
            }
        }
    }

    private E findSmallestChild(Node<E> parent) {
        
        if (parent.left.left == null) {
            E returnValue = parent.left.data;
            parent.left = parent.left.right;
            return returnValue;
        } else {
            return findSmallestChild(parent.left);
        }
    }
    
    public List<E> toList() {
        List<E> result = new ArrayList<>();
        toList(result, root);
        return result;
    }

    private void toList(List<E> result, Node<E> node) {
        if (node == null) {
            return;
        }
        toList(result, node.left);
        result.add(node.data);
        toList(result, node.right);
    }
    
}
