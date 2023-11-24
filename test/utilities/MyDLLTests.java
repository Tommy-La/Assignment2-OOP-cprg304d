package utilities;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MyDLLTests {

    private ListADT<String> list;

    @BeforeEach
    void setUp() {
        list = new MyDLL<>();
    }

    @Test
    void testSizeEmpty() {
        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
    }

    @Test
    void testClear() {
        list.add("A");
        list.add("B");
        list.add("C");

        list.clear();

        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
    }

    @Test
    void testAdd() {
        assertTrue(list.add("A"));
        assertEquals(1, list.size());
        assertFalse(list.isEmpty());
    }

    @Test
    void testAddAtIndex() {
        list.add("A");
        list.add("B");
        list.add(1, "X");

        assertEquals("X", list.get(1));
    }

    @Test
    void testRemoveAtIndex() {
        list.add("A");
        list.add("B");
        list.add("C");

        String removed = list.remove(1);

        assertEquals("B", removed);
        assertEquals(2, list.size());
        assertFalse(list.contains("B"));
    }

    @Test
    void testGet() {
        list.add("A");
        list.add("B");
        list.add("C");

        assertEquals("B", list.get(1));
    }

    @Test
    void testRemoveByElement() {
        list.add("A");
        list.add("B");
        list.add("C");

        String removed = list.remove("B");

        assertEquals("B", removed);
        assertEquals(2, list.size());
        assertFalse(list.contains("B"));
    }

    @Test
    void testSet() {
        list.add("A");
        list.add("B");
        list.add("C");

        String previous = list.set(1, "X");

        assertEquals("B", previous);
        assertEquals("X", list.get(1));
    }

    @Test
    void testIsEmpty() {
        assertTrue(list.isEmpty());
        list.add("A");
        assertFalse(list.isEmpty());
    }

    @Test
    void testContains() {
        list.add("A");
        list.add("B");
        assertTrue(list.contains("B"));
        assertFalse(list.contains("C"));
    }

    // ....
  
}
