package org.tisong.st;

import java.util.Iterator;

/**
 * Created by tisong on 10/28/16.
 */
public abstract class AbstractedST<Key, Value> implements ST<Key, Value>{

    @Override
    public abstract void put(Key key, Value value);

    @Override
    public abstract Value get(Key key);

    @Override
    public void delete(Key key) {
        put(key, null);
    }

    @Override
    public boolean contains(Key key) {
        return get(key) != null;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public abstract int size();

    @Override
    public abstract Iterable<Key> keys();
}
