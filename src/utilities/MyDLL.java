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
	
	//Construct empty DLL.
	public MyDLL() {
		this.head = this.tail = null;
		this.size = 0;
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
        	if (index < 0 || index > size) {
            		throw new IndexOutOfBoundsException("Index out of range");
        }

        MyDLLNode<E> newNode = new MyDLLNode<>(toAdd);

        if (index == 0) { 
            	newNode.setNext(head);
            	head = newNode;

        	if (size == 0) { 
                	tail = newNode;
            	}
        } else if (index == size) {
            	tail.setNext(newNode);
            	newNode.setPrev(tail);
        	tail = newNode;
        } else {
        	MyDLLNode<E> current = getNode(index);
        	MyDLLNode<E> prev = current.getPrev();

            	prev.setNext(newNode);
            	newNode.setPrev(prev);
           	newNode.setNext(current);
            	current.setPrev(newNode);
        }

        size++;
        return true;
	}

	@Override
	public boolean add(E toAdd) throws NullPointerException {
		return add(size, toAdd);
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

        	MyDLLNode<E> node = getNode(index);
        	return node.getData();
	}

	@Override
	public E remove(int index) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E remove(E toRemove) throws NullPointerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public boolean contains(E toFind) throws NullPointerException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E[] toArray(E[] toHold) throws NullPointerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
