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
        assertTrue(newStack.isEmpty());
        assertEquals(0, newStack.size());
    }

    /**
     * Test method for {@link utilities.MyStack#push(java.lang.Object)}.
     */
    @Test
    void testPush() {
        stack.push(42);
        assertFalse(stack.isEmpty());
        assertEquals(1, stack.size());
    }

    /**
     * Test method for {@link utilities.MyStack#pop()}.
     */
    @Test
    void testPop() {
        stack.push(42);
        int poppedValue = stack.pop();
        assertEquals(42, poppedValue);
        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());
    }

    /**
     * Test method for {@link utilities.MyStack#peek()}.
     */
    @Test
    void testPeek() {
        stack.push(42);

        assertEquals(42, stack.peek());
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
        stack.clear();
        assertTrue(stack.isEmpty());
    }

    /**
     * Test method for {@link utilities.MyStack#isEmpty()}.
     */
    @Test
    void testIsEmpty() {
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

        assertEquals(1, stack.search(3));
        assertEquals(2, stack.search(2));
        assertEquals(-1, stack.search(42));
    }

    /**
     * Test method for {@link utilities.MyStack#iterator()}.
     */
    @Test
    void testIterator() {
        stack.push(1);
        stack.push(2);
        stack.push(3);

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
        assertEquals(0, stack.size());

        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.size());

        stack.pop();
        assertEquals(1, stack.size());
    }
}
