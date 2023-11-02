package utilities;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class MyArrayList<E> implements ListADT<E> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6641976547739553233L;

	private static final int DEFAULT_CAPACITY = 10;
	private E[] array;
    private int size;

    public MyArrayList() {
        this.array = (E[]) new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        array = (E[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
        if (toAdd == null) {
            throw new NullPointerException("Null elements not allowed");
        }
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
        
        checkCapacity();
        array[size] = toAdd;
        size++;
        /*
        ensureCapacity(size + 1);
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = toAdd;
        size++;*/
        return true;
    }

    private void checkCapacity() {
    	if(size == array.length) {
    		E[] newArray = (E[]) new Object[array.length*2];
    		for(int i=0;1<array.length; i++) {
    			newArray[i] = array[i];
    		}
    		array = newArray;
    	}
	}

	@Override
    public boolean add(E toAdd) throws NullPointerException {
        if (toAdd == null) {
            throw new NullPointerException("Null elements not allowed");
        }
        ensureCapacity(size + 1);
        array[size] = toAdd;
        size++;
        return true;
    }

    @Override
    public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
        if (toAdd == null)
            throw new NullPointerException("Null elements not allowed");

        ensureCapacity(size + toAdd.size());

        Iterator<? extends E> iterator = toAdd.iterator();
        while (iterator.hasNext()) {
            add(iterator.next());
        }

        return true;
    }

    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index out of range");

        @SuppressWarnings("unchecked")
        E element = (E) array[index];
        return element;
    }

    @Override
    public E remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index out of range");

        @SuppressWarnings("unchecked")
        E removedElement = (E) array[index];

        int numToMove = size - index - 1;
        if (numToMove > 0) {
            System.arraycopy(array, index + 1, array, index, numToMove);
        }
        array[size - 1] = null;
        size--;
        return removedElement;
    }

    @Override
    public E remove(E toRemove) throws NullPointerException {
        if (toRemove == null)
            throw new NullPointerException("Null elements not allowed");

        for (int i = 0; i < size; i++) {
            if (toRemove.equals(array[i])) {
                return remove(i);
            }
        }
        return null;
    }

    @Override
    public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
        if (toChange == null)
            throw new NullPointerException("Null elements not allowed");

        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index out of range");

        @SuppressWarnings("unchecked")
        E previousElement = (E) array[index];
        array[index] = toChange;
        return previousElement;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(E toFind) throws NullPointerException {
        if (toFind == null)
            throw new NullPointerException("Null elements not allowed");

        for (int i = 0; i < size; i++) {
            if (toFind.equals(array[i])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public E[] toArray(E[] toHold) throws NullPointerException {
        if (toHold == null)
            throw new NullPointerException("Specified array is null");

        if (toHold.length < size) {
            toHold = Arrays.copyOf(toHold, size);
        }

        System.arraycopy(array, 0, toHold, 0, size);
        return toHold;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(array, size);
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < size;
            }

            @Override
            public E next() {
                if (!hasNext())
                    throw new NoSuchElementException();
                return get(currentIndex++);
            }
        };
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity > array.length) {
            int newCapacity = array.length + (array.length >> 1);
            array = Arrays.copyOf(array, newCapacity);
        }
    }

}
