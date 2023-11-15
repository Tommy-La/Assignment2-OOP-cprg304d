/**
 * 
 */
package utilities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


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
	 * Test method for {@link utilities.MyStack#stackPush(java.lang.Object)}.
	 */
	@Test
	void testStackPush() {
		stack.stackPush(10);
        stack.stackPush(2);
        assertEquals(2, stack.stackPeek());
	}

	/**
	 * Test method for {@link utilities.MyStack#stackPop()}.
	 */
	@Test
	void testStackPop() {
		stack.stackPush(10);
        stack.stackPush(2);

        Integer poppedValue = stack.stackPop();
        assertEquals(2, poppedValue);
        assertEquals(10, stack.stackPeek());
	}

	/**
	 * Test method for {@link utilities.MyStack#stackPeek()}.
	 */
	@Test
	void testStackPeek() {
		stack.stackPush(10);
        stack.stackPush(100);

        assertEquals(100, stack.stackPeek());
        assertEquals(100, stack.stackPeek()); //Check again if stackPeek remove the element
	}

	/**
	 * Test method for {@link utilities.MyStack#stackSearch(java.lang.Object)}.
	 */
	@Test
	void testStackSearch() {
		stack.stackPush(10);
        stack.stackPush(20);
        stack.stackPush(30);

        assertEquals(1, stack.stackSearch(30)); // 30 is at position 1
        assertEquals(2, stack.stackSearch(20)); // 20 is at position 2
        assertEquals(-1, stack.stackSearch(40)); // 40 is not in the stack
	}

	/**
	 * Test method for {@link utilities.MyStack#isEmpty()}.
	 */
	@Test
	void testIsEmpty() {
		assertTrue(stack.isEmpty());
		stack.stackPush(100);
		assertFalse(stack.isEmpty());
	}

}
