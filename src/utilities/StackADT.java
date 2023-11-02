package utilities;

public interface StackADT<E> {
	
	
    /**
     * Pushes a given element to the top of the stack.
     *
     * @param element The element to be pushed on top of the stack.
     */
	public void stackPush(E element);

    /**
     * Remove and return the top element of the stack.
     *
     * @return The element removed from the top of the stack.
     * @throws EmptyStackException if the stack is empty.
     */
    public E stackPop();

    /**
     * Retrieves, but does not remove, the element at the top of the stack.
     *
     * @return The element at the top of the stack.
     * @throws EmptyStackException if the stack is empty.
     */
    public E stackPeek();

    /**
     * Searches for the given element in the stack and return its position in the stack starting at 1 instead of 0.
     * With 1 as the top of the stack.
     * 
     * @param element The element to search for in the stack.
     * @return The position of the element in the stack, or -1 if the element is not found.
     */
    public int stackSearch(E element);
    
    /**
     * Checks if the stack is empty.
     *
     * @return true if the stack is empty, false otherwise.
     */
    public boolean isEmpty();
    
}
