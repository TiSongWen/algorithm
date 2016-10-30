package org.tisong.st;

import java.util.Iterator;

/**
 * Created by tisong on 10/28/16.
 */
public abstract class OrderedST<Key, Value> extends AbstractedST<Key, Value> {

    @Override
    public abstract void put(Key key, Value value);

    @Override
    public abstract Value get(Key key);

    @Override
    public abstract int size();

    @Override
    public abstract Iterable<Key> keys();


    public abstract Key min();


    public abstract Key max();

    public abstract Key floor(Key key);

    public abstract Key ceiling(Key key);


    public abstract Key select(int k);

    public abstract void deleteMin();

    public abstract void deleteMax();

    public abstract int size(Key lo, Key hi);

    public abstract Iterator<Key> keys(Key lo, Key hi);
}
