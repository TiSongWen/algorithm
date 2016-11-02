package org.tisong.st;

import org.tisong.util.VisualAccumulator;

import java.util.Iterator;

/**
 * The {@code SequentialSearchST} class represents an (unordered)
 * symbol table of generic key-value pairs.
 */
public class SequentialSearchST<Key, Value> extends AbstractedST<Key,Value>{
    private Node first;       // the linked list of key-value pairs
    private int n;            // the number of key-value pairs
    private VisualAccumulator a;

    /**
     * Initializes an empty symbol table
     */
    public SequentialSearchST() {
        first = null;
        n  = 0;
        a = new VisualAccumulator(15000, 6000);
    }

    // a helper linked list data type
    private class Node {
        private Key key;
        private Value value;
        private Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    @Override
    public void put(Key key, Value val) {
        if (key == null) throw new NullPointerException("first argument to put() is null");
        if (val == null) {
            delete(key);
            return ;
        }
        int comNum = 0;
        for (Node x = first; x != null; x = x.next, comNum++) {
            if (x.key.equals(key)) {
                x.value = val;
                a.addDataValue(comNum);
                return ;
            }
        }
        a.addDataValue(comNum);
        first = new Node(key, val, first);
        n++;
    }

    @Override
    public Value get(Key key) {
        if (key == null) throw new NullPointerException("argument to get() is null");
        for (Node x = first; x != null; x = x.next) {
            if (x.key.equals(key)) {
               return x.value;
            }
        }
        return null;
    }


    @Override
    public int size() {
        return n;
    }

    @Override
    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<>();
        for (Node x = first; x != null; x = x.next) {
            queue.enQueue(x.key);
        }
        return queue;
    }

    public void delete(Key key) {
        if (key == null) throw new NullPointerException("argument to delete is null");
        if (first.key.equals(key)) {
            first = first.next;
        }
        else {
            for (Node n = first.next, p = first; n != null; p = p.next, n = n.next) {
                if (n.key.equals(key)) {
                    p.next = n.next;
                    break;
                }
            }
        }
    }
}
