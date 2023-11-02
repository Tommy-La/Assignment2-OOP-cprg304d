package utilities;

import java.util.EmptyStackException;

public class MyStack<E> implements StackADT<E> {

	private Node<E> top;
	
	private static class Node<E> {
        E data;
        Node<E> next;

        Node(E data) {
            this.data = data;
            this.next = null;
        }
    }

    public MyStack() {
        top = null;
    }
	
	@Override
	public void stackPush(E element) {
		Node<E> newNode = new Node<>(element);
        newNode.next = top;
        top = newNode;
	}

	@Override
	public E stackPop() {
		if (isEmpty()) {
            throw new EmptyStackException();
        }
        E poppedData = top.data;
        top = top.next;
        return poppedData;
	}

	@Override
	public E stackPeek() {
		if (isEmpty()) {
            throw new EmptyStackException();
        }
        return top.data;
	}

	@Override
	public int stackSearch(E element) {
		int position = 1;
        Node<E> curr = top;
        while (curr != null) {
            if (curr.data.equals(element)) {
                return position;
            }
            curr = curr.next;
            position++;
        }
        return -1;
	}

	@Override
	public boolean isEmpty() {
		return top == null;
	}

}
