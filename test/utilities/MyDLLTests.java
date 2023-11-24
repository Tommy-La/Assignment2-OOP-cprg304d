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
    void testIsEmpty() {
        assertTrue(list.isEmpty());
        list.add("A");
        assertFalse(list.isEmpty());
    }

 

    @Test
    void testToArray() {
        list.add("A");
        list.add("B");
        list.add("C");

        String[] arr = new String[3];
        arr = list.toArray(arr);

        assertArrayEquals(new String[]{"A", "B", "C"}, arr);
    }
    
 
    @Test
    void testIterator() {
        list.add("A");
        list.add("B");
        list.add("C");

        Iterator<String> iterator = list.iterator();
        assertTrue(iterator.hasNext());
        assertEquals("A", iterator.next());
        assertEquals("B", iterator.next());
        assertEquals("C", iterator.next());
        assertFalse(iterator.hasNext());
    }
    
    @Test
    void testAddToEmptyList() {
        assertTrue(list.isEmpty());
        list.add("A");
        assertEquals(1, list.size());
        assertEquals("A", list.get(0));
    }

 

    @Test
    void testAddAtInvalidIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.add(1, "A"); // Invalid index as list is empty
        });
    }

    @Test
    void testGetFromInvalidIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.get(0); // Invalid index as list is empty
        });
    }

}
