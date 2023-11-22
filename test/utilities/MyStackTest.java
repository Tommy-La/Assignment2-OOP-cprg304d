/**
 * 
 */
package utilities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link utilities.MyStack#push(java.lang.Object)}.
	 */
	@Test
	void testPush() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link utilities.MyStack#pop()}.
	 */
	@Test
	void testPop() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link utilities.MyStack#peek()}.
	 */
	@Test
	void testPeek() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link utilities.MyStack#clear()}.
	 */
	@Test
	void testClear() {
		 MyStack<Double> stack = new MyStack<>();
	        stack.push(3.14);
	        stack.push(2.71);

	        assertFalse(stack.isEmpty());
	        stack.clear();
	        assertTrue(stack.isEmpty());
	}

	/**
	 * Test method for {@link utilities.MyStack#isEmpty()}.
	 */
	@Test
	void testIsEmpty() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link utilities.MyStack#toArray()}.
	 */
	@Test
	void testToArray() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link utilities.MyStack#toArray(E[])}.
	 */
	@Test
	void testToArrayEArray() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link utilities.MyStack#contains(java.lang.Object)}.
	 */
	@Test
	void testContains() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link utilities.MyStack#search(java.lang.Object)}.
	 */
	@Test
	void testSearch() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link utilities.MyStack#iterator()}.
	 */
	@Test
	void testIterator() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link utilities.MyStack#equals(utilities.StackADT)}.
	 */
	@Test
	void testEqualsStackADTOfE() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link utilities.MyStack#size()}.
	 */
	@Test
	void testSize() {
		fail("Not yet implemented");
	}

}
