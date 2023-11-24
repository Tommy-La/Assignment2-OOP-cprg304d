package utilities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utilities.Iterator;


public class MyQueueTest {
	MyQueue <Integer> queue;
	
	
	@BeforeEach
    void setUp() throws Exception {
          
    }
	
	
	@Test
    void testMyQueue() {
        MyQueue<Integer> newQueue = new MyQueue<>();
        assertTrue(newQueue.isEmpty());
        assertEquals(0, newQueue.size());
    }
	
	@Test
	void testEnqueue() {
		MyQueue <Integer> queue = new MyQueue<>();
        queue.enqueue(42);
        assertFalse(queue.isEmpty());
        assertEquals(1, queue.size());
    }
	
	
	@Test
	void testDequeue() {
		queue = new MyQueue<>();
        queue.enqueue(42);
        queue.enqueue(2);

        queue.dequeue();
        assertFalse(queue.isEmpty());
        assertEquals(1, queue.size());
    }
	
	@Test
	void testPeek() {
		queue = new MyQueue<>();
		 queue.enqueue(42);
		 queue.enqueue(7);
		 
		 assertEquals(42, queue.peek());
	}
	
	@Test
	void testDequeueAll() {
		queue = new MyQueue<>();
		queue.enqueue(42);
		queue.enqueue(7);
		
		queue.dequeueAll();
		
		
        assertEquals(0, queue.size());
	}
	
	
	@Test
	void testIsEmpty() {
		queue = new MyQueue<>();
		queue.enqueue(42);
		queue.enqueue(7);
		
	
		
		assertFalse(queue.isEmpty());
	}
	

	@Test
    void testToArray() {
		queue = new MyQueue<>();
  
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        Object[] array = queue.toArray();
        assertArrayEquals(new Object[]{1, 2, 3}, array);
	 }
	
	
	@Test
    void testToArrayEArray() {
		queue = new MyQueue<>();
	    queue.enqueue(1);
	    queue.enqueue(2);
	    queue.enqueue(3);
	
	    Integer[] array = new Integer[3];
	    queue.toArray(array);
	    assertArrayEquals(new Integer[]{1, 2, 3}, array);
    }
	
	@Test
    void testIterator() {
		queue = new MyQueue<>();
	    queue.enqueue(1);
	    queue.enqueue(2);
	    queue.enqueue(3);
	    
	    
        StringBuilder result = new StringBuilder();
        Iterator<Integer> iterator = queue.iterator(); 

        while (iterator.hasNext()) {
            Integer value = iterator.next();
            result.append(value);
        }
        assertEquals("123", result.toString());
    }
	
	
	
	@Test
	void testIsFull() {
		
		queue = new MyQueue<>();
		queue.maxSize(3);
		
		
	    queue.enqueue(1);
	    queue.enqueue(2);
	    queue.enqueue(3);
	    
	    
	    
	    assertTrue(queue.isFull());
		
	}
	
	@Test
	void testSize() {
		
		queue = new MyQueue<>();

		
        assertEquals(0, queue.size());

	    queue.enqueue(1);
	    queue.enqueue(2);
	    assertEquals(2, queue.size());
	
	    queue.dequeue();
        assertEquals(1, queue.size());
	    
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
