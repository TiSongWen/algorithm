package qg.link;

import java.util.Arrays;

/**
 * Created by tisong on 12/5/16.
 */
public class ArrayedList<E> {
    private static final int DEFAULT_CAPACITY = 10;

    private static final Object[] EMPTY_ELEMENTDATA = {};

    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};


    private transient E elementData[];

    private int size;

    protected transient int modCount = 0;


    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;


    public void add(int index, E element) {
        rangeCheckForAdd(index);
        ensureCapacityInternal(size + 1);
        System.arraycopy(elementData, index, elementData, index + 1, size - index);
        size++;
    }

    public E get(int index) {
        rangeCheckForAdd(index);

        return elementData[index];
    }


    public E remove(int index) {
        rangeCheckForAdd(index);
        modCount++;
        E oldValue = elementData[index];
        // 错误1 : 忽略了这种情况，如果是最后一个尾结点，是不用移动数组的
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elementData, index + 1, elementData, index, size - index);
        }
        // 错误2 ： 忽略了最后一个依然存在的尾结点
        elementData[--size] = null;
        return oldValue;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    private void ensureCapacityInternal(int minCapacity) {
        if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
            minCapacity = DEFAULT_CAPACITY;
        }

        ensureExplicitCapacity(minCapacity);
    }

    private void ensureExplicitCapacity(int minCapacity) {
        modCount++;

        if (minCapacity - elementData.length > 0)
            grow(minCapacity);
    }

    private void grow(int minCapacity) {
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + oldCapacity >> 1;
        if (minCapacity > newCapacity)
            newCapacity = minCapacity;
        if (newCapacity - MAX_ARRAY_SIZE > 0)
            newCapacity = hugeCapacity(minCapacity);

        // Note : the function of Arrays.copyOf
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    private void rangeCheckForAdd(int index) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    private int hugeCapacity(int minCapacity) {
        return minCapacity > MAX_ARRAY_SIZE ? Integer.MAX_VALUE : MAX_ARRAY_SIZE;
    }

    private String outOfBoundsMsg(int index) {
        return "Index: "+index+", Size: "+size;
    }
}
