package org.tisong.st;

import org.tisong.util.VisualAccumulator;

import java.util.Iterator;

/**
 * The {@code SequentialSearchST} class represents an (unordered)
 * symbol table of generic key-value pairs.
 */
public class SequentialSearchST<Key, Value> extends AbstractedST<Key,Value>{

    private Node first;

    private int size;

    private VisualAccumulator a;

    public SequentialSearchST() {
        first = null;
        size  = 0;
        a = new VisualAccumulator(15000, 6000);
    }

    private class Node {
        Key key;
        Value value;
        Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    @Override
    public void put(Key key, Value value) {
        if (key == null) throw new IllegalArgumentException("key can't be null pointer");
        if (value == null) {
            delete(key);
            return ;
        }
        int comNum = 0;
        for (Node x = first; x != null; x = x.next) {
            comNum++;
            if (x.key.equals(key)) {
                x.value = value;
                a.addDataValue(comNum);
                return ;
            }
        }
        a.addDataValue(comNum);
        first = new Node(key, value, first);
        size++;
    }

    @Override
    public Value get(Key key) {
        if (key == null)
            throw new IllegalArgumentException("key can't be null pointer");

        for (Node x = first; x != null; x = x.next) {
            if (x.key.equals(key)) {
               return x.value;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<Key>();
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
