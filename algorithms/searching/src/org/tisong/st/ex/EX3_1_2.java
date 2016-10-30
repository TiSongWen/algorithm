package org.tisong.st.ex;

import org.tisong.st.AbstractedST;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by tisong on 10/28/16.
 */
public class EX3_1_2<Key, Value> extends AbstractedST<Key, Value>{
    private Key[] keys;

    private Value[] values;

    private int current;

    private int capacity = 16;

    public EX3_1_2() {
        keys = (Key[])new Object[capacity];
        values = (Value[]) new Object[capacity];
    }

    public EX3_1_2(int capacity) {
        keys = (Key[])new Object[capacity];
        values = (Value[]) new Object[capacity];
        this.capacity = capacity;
    }

    @Override
    public void put(Key key, Value value) {
        if (key == null) {
            throw new IllegalArgumentException("key can't be null pointer");
        }

        int current = this.current;
        if (current >= capacity) {

        }

        for (int i = 0; i < current; i++) {
            if (keys[i].equals(key)) {
                values[i] = value;
                return ;
            }
        }

        keys[current] = key;
        values[current] = value;

        current++;
        this.current = current;
    }

    @Override
    public Value get(Key key) {
        if (key == null){
            throw new IllegalArgumentException("key can't be null pointer");
        }

        for (int i = 0; i < current; i++) {
           if (keys[i].equals(key)) {
               return values[i];
           }
       }

       return null;
    }

    @Override
    public int size() {
        return this.current;
    }

    @Override
    public Iterable<Key> keys() {
        return Arrays.asList(keys);
    }
}
