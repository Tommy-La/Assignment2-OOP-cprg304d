package utilities;

public interface QueueADT<E> {
	 /**
     * Adds an element to the back of the queue.
     *
     * @param element the element to be added
     * @throws NullPointerException if the specified element is null
     */
    void enqueue(E element);

    /**
     * Removes and returns the element at the front of the queue.
     *
     * @return the element at the front of the queue
     * @throws EmptyQueueException if the queue is empty
     */
    E dequeue();

    /**
     * Returns the element at the front of the queue without removing it.
     *
     * @return the element at the front of the queue
     * @throws EmptyQueueException if the queue is empty
     */
    E peek();

    /**
     * Checks if the queue is empty.
     *
     * @return true if the queue is empty, false otherwise
     */
    boolean isEmpty();

    /**
     * Returns the number of elements in the queue.
     *
     * @return the number of elements in the queue
     */
    int size();
}
