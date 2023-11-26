/**
 * 
 */
package utilities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utilities.Iterator;
/**
 * 
 */
class MyStackTest {

    private MyStack<Integer> stack;

    /**
     * @throws java.lang.Exception
     */
    @BeforeEach
    void setUp() throws Exception {
        stack = new MyStack<>();
    }

    /**
     * Test method for {@link utilities.MyStack#MyStack()}.
     */
    @Test
    void testMyStack() {
        MyStack<Integer> newStack = new MyStack<>();
        //Verifies that a new stack is empty and has a size of 0
        assertTrue(newStack.isEmpty());
        assertEquals(0, newStack.size());
    }

    /**
     * Test method for {@link utilities.MyStack#push(java.lang.Object)}.
     */
    @Test
    void testPush() {
        stack.push(13);
        stack.push(-1);

        //Verifies that an element is successfully pushed onto the stack
        assertFalse(stack.isEmpty());
        assertEquals(2, stack.size());
    }

    /**
     * Test method for {@link utilities.MyStack#pop()}.
     */
    @Test
    void testPop() {
        stack.push(4);
        int poppedValue = stack.pop();
        //Verifies that an element is successfully popped from the stack.
        assertEquals(4, poppedValue);
        
        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());
    }

    /**
     * Test method for {@link utilities.MyStack#peek()}.
     */
    @Test
    void testPeek() {
        stack.push(32);
        //Verifies that the peek method returns the top element without removing it.
        assertEquals(32, stack.peek());
        assertFalse(stack.isEmpty());
    }

    /**
     * Test method for {@link utilities.MyStack#clear()}.
     */
    @Test
    void testClear() {
    	MyStack<Integer> stack = new MyStack<>();
        stack.push(3);
        stack.push(2);
        stack.push(1);

        assertFalse(stack.isEmpty());
        //Verifies that the stack is successfully cleared.
        stack.clear();
        assertTrue(stack.isEmpty());
    }

    /**
     * Test method for {@link utilities.MyStack#isEmpty()}.
     */
    @Test
    void testIsEmpty() {
    	//Verifies that the isEmpty method correctly identifies a stack is empty or not.
        assertTrue(stack.isEmpty());
        stack.push(42);
        assertFalse(stack.isEmpty());
    }

    /**
     * Test method for {@link utilities.MyStack#toArray()}.
     */
    @Test
    void testToArray() {
        stack.push(1);
        stack.push(2);
        stack.push(3);

        //Verifies that the stack is successfully converted to an array.
        Object[] array = stack.toArray();
        assertArrayEquals(new Object[]{1, 2, 3}, array);
    }

    /**
     * Test method for {@link utilities.MyStack#toArray(E[])}.
     */
    @Test
    void testToArrayEArray() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        //Verifies that the stack is successfully copied to the specified array.
        Integer[] array = new Integer[3];
        stack.toArray(array);
        assertArrayEquals(new Integer[]{1, 2, 3}, array);
    }

    /**
     * Test method for {@link utilities.MyStack#contains(java.lang.Object)}.
     */
    @Test
    void testContains() {
        assertFalse(stack.contains(42));
        stack.push(42);
        //Verifies that the stack correctly identifies if it contain an element.
        assertTrue(stack.contains(42));
    }

    /**
     * Test method for {@link utilities.MyStack#search(java.lang.Object)}.
     */
    @Test
    void testSearch() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        //Verifies that the position of an element is correctly identified in the stack.
        assertEquals(1, stack.search(3));
        assertEquals(2, stack.search(2));
        assertEquals(-1, stack.search(30));
    }

    /**
     * Test method for {@link utilities.MyStack#iterator()}.
     */
    @Test
    void testIterator() {
        stack.push(1);
        stack.push(2);
        stack.push(3);

        //Verifies that the iterator correctly iterates through the elements of the stack.
        StringBuilder result = new StringBuilder();
        Iterator<Integer> iterator = stack.iterator(); 

        while (iterator.hasNext()) {
            Integer value = iterator.next();
            result.append(value);
        }
        assertEquals("123", result.toString());
    }

    /**
     * Test method for {@link utilities.MyStack#equals(utilities.StackADT)}.
     */
    @Test
    void testEqualsStackADTOfE() {
        MyStack<Integer> stack2 = new MyStack<>();
        //Verifies that the equality of two stacks is correctly determined.
        stack.push(10);
        stack2.push(10);

        assertTrue(stack.equals(stack2));

        stack.push(1);
        assertFalse(stack.equals(stack2));

        stack2.push(1);
        assertTrue(stack.equals(stack2));
    }

    /**
     * Test method for {@link utilities.MyStack#size()}.
     */
    @Test
    void testSize() {
    	//Verifies that the size of the stack is correctly return.
        assertEquals(0, stack.size());

        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.size());

        stack.pop();
        assertEquals(1, stack.size());
    }
}
