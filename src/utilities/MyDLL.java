package utilities;

public class MyDLL<E> implements ListADT<E> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7140796753013938413L;

	//attributes
	private MyDLLNode<E> head;   
	private MyDLLNode<E> tail; 
	private int size;
	private int maxSize = 0;
	
	public void setMaxSize(int listSize) {
		
		this.maxSize = listSize;
	}
	
	public int getMaxSize() {
		return maxSize;
	}
	
	//Construct empty DLL.
	public MyDLL() {
		this.head = this.tail = null;
		this.size = 0;
	}
	
	public MyDLLNode<E> getHead() {
		return head;
	}

	public void setHead(MyDLLNode<E> head) {
		this.head = head;
	}

	public MyDLLNode<E> getTail() {
		return tail;
	}

	public void setTail(MyDLLNode<E> tail) {
		this.tail = tail;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void clear() {
		head = tail = null;
		size = 0;
	}

	@Override
	public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
	    if (toAdd == null) {
	        throw new NullPointerException("Null element was given");
	    }
	    if (index < 0 || index > size()) {
	        throw new IndexOutOfBoundsException("Index out of range");
	    }

	    MyDLLNode<E> newNode = new MyDLLNode<>(toAdd);

	    if (index == 0) {
	        newNode.setNext(getHead());
	        setHead(newNode);

	        if (size() == 0) {
	            setTail(newNode);
	        }
	    } else if (index == size()) {
	        getTail().setNext(newNode);
	        newNode.setPrev(getTail());
	        setTail(newNode);
	    } else {
	        MyDLLNode<E> current = getHead();
	        // Traverse the list to the specified index
	        for (int i = 0; i < index; i++) {
	            current = current.getNext();
	        }

	        MyDLLNode<E> prev = current.getPrev();

	        prev.setNext(newNode);
	        newNode.setPrev(prev);
	        newNode.setNext(current);
	        current.setPrev(newNode);
	    }

	    setSize(size() + 1);
	    return true;
	}


	@Override
    public boolean add(E data) {
        MyDLLNode newNode = new MyDLLNode(data);

        // If the list is empty, set the new node as the head
        if (head == null) {
            head = newNode;
            size++;
            return true;
        }

        // Traverse to the end of the list
        MyDLLNode last = head;
        while (last.getNext() != null) {
            last = last.getNext();
        }

        // Set the next of the last node to the new node
        last.setNext(newNode) ;

        // Set the previous of the new node to the last node
        newNode.setPrev(last);
        size ++;
		return true;
    }

	@Override
	public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
		if (toAdd == null) {
            		throw new NullPointerException("Null element was given");
        	}

        	boolean modified = false;
        	Iterator<? extends E> iterator = toAdd.iterator();
        	while (iterator.hasNext()) {
            		if (add(iterator.next())) {
               			modified = true;
            	}
        }

        	return modified;
   	}

	@Override
	public E get(int index) throws IndexOutOfBoundsException {
	    if (index < 0 || index >= size) {
	        throw new IndexOutOfBoundsException("Index out of range");
	    }

	    MyDLLNode<E> currentNode = head;

	    // Traverse the list to the specified index
	    for (int i = 0; i < index; i++) {
	        currentNode = currentNode.getNext();
	    }

	    return currentNode.getElement();
	}


	@Override
	public E remove(int index) throws IndexOutOfBoundsException {
	    if (index < 0 || index >= size()) {
	        throw new IndexOutOfBoundsException("Index out of range");
	    }

	    MyDLLNode<E> removedNode = null;

	    if (index == 0) {
	        removedNode = getHead();
	        setHead(getHead().getNext());

	        if (getHead() == null) {
	            setTail(null);
	        } else {
	            getHead().setPrev(null);
	        }
	    } else if (index == size() - 1) {
	        removedNode = getTail();
	        setTail(getTail().getPrev());
	        getTail().setNext(null);
	    } else {
	        MyDLLNode<E> current = getHead();

	        // Traverse the list to the specified index
	        for (int i = 0; i < index; i++) {
	            current = current.getNext();
	        }

	        MyDLLNode<E> prevNode = current.getPrev();
	        MyDLLNode<E> nextNode = current.getNext();

	        prevNode.setNext(nextNode);
	        nextNode.setPrev(prevNode);

	        removedNode = current;
	    }

	    setSize(size - 1);
	    return removedNode.getElement();
	}



	@Override
	public E remove(E toRemove) throws NullPointerException {
		if (toRemove == null) {
            throw new NullPointerException("Specified element is null");
        }

        //Iterate through the list to find the node to remove
        MyDLLNode<E> current = head;
        while (current != null) {
            if (toRemove.equals(current.getElement())) {
                //Found the element to remove
                if (current.getPrev() != null) {
                    //Adjust the previous node's next pointer using the setter
                    current.getPrev().setNext(current.getNext());
                } else {
                    //Update the head if the element to remove is the first in the list
                    head = current.getNext();
                }

                if (current.getNext() != null) {
                    current.getNext().setPrev(current.getPrev());
                }
                setSize(getSize() - 1);
                // Return the removed element
                return current.getElement(); 
            }
            current = current.getNext();
        }

        // Element not found in the list
        return null;
    }

	@Override
	public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
		if (toChange == null) {
            throw new NullPointerException("Specified element is null");
        }

        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index out of range: " + index);
        }

        // Traverse the list to find the node at the specified index
        MyDLLNode<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }

        // Save the current data to return later
        E previousElement = current.getElement();

        // Update the data of the node with the new element
        current.setElement(toChange);

        return previousElement;
    }

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public boolean contains(E toFind) throws NullPointerException {
		if (toFind == null) {
            throw new NullPointerException("Specified element is null");
        }

        // Traverse the list to find the element
        MyDLLNode<E> current = head;
        while (current != null) {
            if (toFind.equals(current.getElement())) {
            	 // Element found in the list
            	return true;
            }
            current = current.getNext();
        }

        // Element not found in the list
        return false;
	}

	@SuppressWarnings("unchecked")
	@Override
    public E[] toArray(E[] toHold) throws NullPointerException {
        if (toHold == null) {
            throw new NullPointerException("The provided array cannot be null.");
        }
        if (toHold.length < size) {
            toHold = (E[])java.lang.reflect.Array.newInstance(
                    toHold.getClass().getComponentType(), size);
        }
        int i = 0;
        for (MyDLLNode<E> x = head; x != null; x = x.getNext()) {
            toHold[i++] = x.getElement();
        }
        if (toHold.length > size) {
            toHold[size] = null;
        }
        return toHold;
    }

	
	@Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        int i = 0;
        for (MyDLLNode<E> x = head; x != null; x = x.getNext())
            result[i++] = x.getElement();
        return result;
    }
 

	@Override
	public Iterator<E> iterator() {
	    return new DLLIterator();
	}

	private class DLLIterator implements Iterator<E> {
	    // Attributes
	    private MyDLLNode<E> current;

	    // Constructors
	    public DLLIterator() {
	        current = head; // Use the head of the DLL
	    }

	    @Override
	    public boolean hasNext() {
	        return current != null;
	    }

	    @Override
	    public E next() {
//	        if (!hasNext()) {
//	            throw new NoSuchElementException("No more elements in the list.");
//	        }

	        E element = current.getElement();
	        current = current.getNext();
	        return element;
	    }
	}



}
