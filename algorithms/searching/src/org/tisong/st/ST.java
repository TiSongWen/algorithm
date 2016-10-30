package org.tisong.st;

import java.util.Iterator;

/**
 *
 */
public interface ST<Key, Value> {

    void put(Key key, Value value);

    Value get(Key key);

    void delete(Key key);

    boolean contains(Key key);

    boolean isEmpty();

    int size();

    Iterable<Key> keys();
}
