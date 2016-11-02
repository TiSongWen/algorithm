package org.tisong.bst;

import org.tisong.st.OrderedST;

import java.util.Iterator;

/**
 * Created by tisong on 11/1/16.
 */
public class BST<Key extends Comparable<Key>, Val>  {

    private Node  root;


    private class Node {
        private Key  key;
        private Val  val;
        private int  size;
        private Node left;
        private Node right;

        public Node(Key key, Val val) {
            this.key = key;
            this.val = val;
        }
    }



    
    public void put(Key key, Val val) {
        if (key == null) throw new NullPointerException("argument key is null to put()");

        Node curr = root;
        Node pare = root;
        int  cmp  = 0;

        while(curr != null) {
            cmp  = key.compareTo(curr.key);
            pare = curr;
            if (cmp < 0)      curr = curr.left;
            else if (cmp > 0) curr = curr.right;
            else            { curr.val = val; return; }
        }

        curr = new Node(key, val);
        curr.size  = 1;
        curr.right = null;
        curr.left  = null;
        if (cmp > 0)      pare.right = curr;
        else if (cmp < 0) pare.left  = curr;
    }



    
    public Val get(Key key) {
        if (key == null) throw new NullPointerException("");

        Node curr = root;
        while (curr != null) {
            int cmp = key.compareTo(curr.key);
            if (cmp < 0)      curr = curr.left;
            else if (cmp > 0) curr = curr.right;
            else return curr.val;
        }

        return null;
    }


    public int size() {
        return (root == null ?  0 : root.size);
    }


    public Iterable<Key> keys() {
        return null;
    }


    public Node min(Node node) {
        return null;
    }


    public Node max(Node node) {
        return null;
    }


    

    public Key floor(Key key) {
        return null;
    }


    public Key ceiling(Key key) {
        return null;
    }


    public Key select(int k) {
        return null;
    }
    

    public void delete(Key key) {
        Node dele = root;
        
    }
    
    public Node delete(Node node, Key key) {
        
        int cmp = key.compareTo(node.key);
        if (cmp < 0) node = delete(node.left, key);
        else if (cmp > 0) node = delete(node.right, key);
        else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            } else {
                Node t = node;
                node = min(node.right);
                node.right = deleteMin(node.right);
                node.left = t.left;
            }
        }
   
        return null;
    }
    
    
    public Node deleteMin(Node node) {
        return null;
    }


    public Node deleteMax(Node node) {
        return null;
    }


    public int size(Key lo, Key hi) {
        return 0;
    }


    public Iterator<Key> keys(Key lo, Key hi) {
        return null;
    }
}
