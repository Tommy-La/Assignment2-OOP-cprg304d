package utilities;


import utilities.MyDLL;
import utilities.MyDLLNode;


public class MyQueue<E> implements QueueADT<E>{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5842659507977482902L;
	private MyDLL<E> queue;
	
	public MyQueue() {
		this.queue = new MyDLL<>();
	}
	     
	
	@Override
	public void enqueue(E data) {
		queue.add(data);
	}
	

	@Override
	public E dequeue()  {
		
//		 if (queue.getHead() == null) { throw EmptyQueueException }
		 
		
		E temp = queue.getHead().getElement();
		queue.setHead(queue.getHead().getNext());
		queue.setSize(queue.getSize()-1);
		return (E) queue.getHead();
	}
	

	  
	@Override
	public E peek() //throws EmptyQueueException 
	{
		E head = (E) queue.getHead().getElement();
		return head;
	}
 
	@Override
	public void dequeueAll() {
		queue.clear();
	}

	@Override
	public boolean isEmpty() {
		return queue.getSize()== 0;
		
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return queue.iterator();
	}

	@Override
	 public boolean equals(QueueADT<E> that) {
        if (that == null || this.size() != that.size()) {
            return false;
        }

        Iterator<E> thisIterator = this.iterator();
        Iterator<E> thatIterator = that.iterator();

        while (thisIterator.hasNext()) {
            E thisElement = thisIterator.next();
            E thatElement = thatIterator.next();

            if (!thisElement.equals(thatElement)) {
                return false;
            }
        }

        return true;
    }

	@Override
	public Object[] toArray() {
		
		return queue.toArray();
	}

	@Override
	public E[] toArray(E[] holder) throws NullPointerException {
		
		return queue.toArray(holder);
	}



	@Override
	public int size() {
		
		return queue.getSize();
	}

	
	




	@Override
	public boolean isFull() {     
		
		
		
		return queue.getSize() == queue.size();
	}
	
	
	

}
