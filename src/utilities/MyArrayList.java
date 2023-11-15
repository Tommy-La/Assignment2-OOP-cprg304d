package utilities;

import java.lang.reflect.Array;
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

    @SuppressWarnings("unchecked")
	public MyArrayList() {
        this.array = (E[]) new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @SuppressWarnings("unchecked")
	@Override
    public void clear() {
        array = (E[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
        if (toAdd == null) {
            throw new NullPointerException("Null element was given");
        }
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
        
        checkCapacity();
        //array[size] = toAdd;
        //Shift all element from the provided index to the right
        for(int i = size -1; i > index; i--) {
        	array[i+1] = array[i];
        }
        array[index] = toAdd;
        size++;
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
            throw new NullPointerException("Null element was given");
        }
        checkCapacity();
        array[size] = toAdd;
        size++;
        return true;
    }

    @Override
    public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
        if (toAdd == null)
            throw new NullPointerException("Null element was given");

        checkCapacity();

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

        E element = (E) array[index];
        return element;
    }

    @Override
    public E remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index out of range");

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
            throw new NullPointerException("Null element was given");

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
            throw new NullPointerException("Null element was given");

        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index out of range");

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
            throw new NullPointerException("Null element was given");

        for (int i = 0; i < size; i++) {
            if (toFind.equals(array[i])) {
                return true;
            }
        }
        return false;
    }

    
	@SuppressWarnings("unchecked")
	@Override
	public E [] toArray (E [] toHold) throws NullPointerException
	{
		if(toHold == null)
		{
			throw new NullPointerException("Cannot copy to a null array.");
		}
		
		if (toHold.length < size)
		{
			toHold = (E[]) (Array.newInstance(toHold.getClass().getComponentType(), size));
		}
		
		for (int i = 0; i < size; i++)
		{
			toHold[i] = (E) array[i];
		}
		
		if(toHold.length > size)
		{
			for (int i = size; i < toHold.length; i++) {
			toHold[i] = null;
			}
		}
		
		
		return toHold;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Object[] toArray()
	{
		//E[] toReturn = (E[]) (new Object[size]);
		E[] toReturn = (E[])(Array.newInstance(Object.class, size));
		/*for(int i = 0; i < size(); i++)
		{
			toReturn[i] = ((E)array[i]).
		}*/
		System.arraycopy(array, 0, toReturn, 0, size());
		return toReturn;
	}

    @Override
    public Iterator<E> iterator() {
        return new ArrayBasedIterator();
    }
    
	private class ArrayBasedIterator implements Iterator<E>
	{
		//Attributes
		private E[] 		copyOfElements;
		private int 		pos;
		
		//Constructors
		@SuppressWarnings("unchecked")
		public ArrayBasedIterator()
		{
			copyOfElements = (E[]) (new Object[size]);
			System.arraycopy(array, 0, copyOfElements, 0, copyOfElements.length);
		}
		
		/* (non-Javadoc)
		 * @see linearUtilities.Iterator#hasNext()
		 */
		@Override
		public boolean hasNext()
		{
			return pos < copyOfElements.length;
		}
	
		/* (non-Javadoc)
		 * @see linearUtilities.Iterator#next()
		 */
		@Override
		public E next() throws NoSuchElementException
		{
			if(pos == copyOfElements.length) {
				throw new NoSuchElementException();
			}
			E toReturn = copyOfElements[pos];
			pos++;
			return toReturn;
		}
	}

 

}
