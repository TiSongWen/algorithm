package org.tisong.st;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * The {@code queue} class represents a first-in-first-out (FIFO)
 * queue of generic items
 * @author tisong
 * @param <Item> the generic type of an item in this queue
 */
public class Queue<Item> implements Iterable<Item>{

    private Node<Item> first;
    private Node<Item> last;
    private int n;

    private class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    public Queue() {
        first = null;
        last  = null;
        n = 0;
    }

    /**
     * Returns true if this queue is empty
     * @return {@code true} if this queue is empty; {@code false} otherwise
     */
    public boolean isEmpty() {
        return n == 0;
    }

    /**
     * Returns the number of items in this queue
     * @return the number of items in this queue
     */
    public int size() {
        return n;
    }

    /**
     * Returns the item in this queue that was least recently added
     * @return the item least recently added to this queue
     * @throws NoSuchElementException if queue is empty
     */
    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        return first.item;
    }




    /**
     * Adds the item to this queue
     * @param item the item to add
     */
    public void enQueue(Item item) {
        Node<Item> oldlast = last;
        last = new Node<>();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else           oldlast.next = last;
        n++;
    }

    /**
     * Removes and returns the item on this queue that was least recently added
     * @return the item on this queue that was least recently added
     * @throws NoSuchElementException if this queue is empty
     */
    public Item deQueue() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        Item item = first.item;
        first = first.next;
        n--;
        if (isEmpty()) last = null;
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator<Item>(first);
    }

    private class ListIterator<Item> implements Iterator<Item> {
        private Node<Item> current;

        public ListIterator(Node<Item> first) {
            current = first;
        }

        /**
         * Return true if current item is not null
         * @return {@code true} if current item is not null; {@code false} otherwise
         */
        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /*
    public static void main(String[] args) {
        System.out.println(new Queue<String>().a.t());
    }

    int t() { return 1; }
    Queue a =  new Queue() { int t() { return 2; } };
    */
}
