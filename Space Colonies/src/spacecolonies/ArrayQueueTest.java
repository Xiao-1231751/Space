package spacecolonies;

import queue.EmptyQueueException;
// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Huhua Xiao (xiaohuhua2019)

/**
 * Create a calss to test the methods from the ArayQueue class
 * 
 * @author Huhua Xiao (xiaohuhua2019)
 * @version 04.09.2022
 */
public class ArrayQueueTest extends student.TestCase {

    private ArrayQueue<String> newArray;

    /**
     * It will be called before using every methods.
     *
     */
    public void setUp() {
        newArray = new ArrayQueue<String>(20);
    }


    /**
     * Test if the getSize() can return the correct number
     *
     */
    public void testGetSize() {
        assertEquals(0, newArray.getSize());
        newArray.enqueue("apple");
        assertEquals(1, newArray.getSize());
    }


    /**
     * Test if the getLengthOfUnderlyingArray() can return the correct number
     *
     */
    public void testGetLengthOfUnderlyingArray() {
        assertEquals(21, newArray.getLengthOfUnderlyingArray());
    }


    /**
     * Test if the ensureCapacity() can expand the capacity of the arrayQueue
     *
     */
    public void testEnsureCapacity() {
        for (int i = 0; i < 21; i++) {
            newArray.enqueue("apple");
        }
        assertEquals(41, newArray.getLengthOfUnderlyingArray());
    }


    /**
     * Test if getFront() can return the correct element
     *
     */
    public void testGetFront() {
        newArray.enqueue("apple");
        newArray.enqueue("banana");
        newArray.enqueue("orange");
        newArray.enqueue("car");
        assertEquals("apple", newArray.getFront());
    }


    /**
     * Test if getFront() methond in the error situation
     *
     */
    public void testGetFrontError() {
        Exception exception = null;
        try {
            newArray.getFront();
            fail("the array is empty");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue("getFront() is throwing the wrong type of exceptions",
            exception instanceof EmptyQueueException);
    }


    /**
     * Test if the dequeue() method can return the correct element
     *
     */
    public void testDequeue() {
        newArray.enqueue("apple");
        newArray.enqueue("banana");
        newArray.enqueue("orange");
        newArray.enqueue("car");
        assertEquals("apple", newArray.dequeue());
        assertEquals("banana", newArray.dequeue());
        assertEquals("orange", newArray.dequeue());
        assertEquals("car", newArray.dequeue());
    }


    /**
     * Test if the dequeue() method have the error
     *
     */
    public void testDequeError() {
        Exception exception = null;
        try {
            newArray.dequeue();
            fail("the array is empty");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(
            "newArray.dequeue() is throwing "
            + "the wrong type of exceptions",
            exception instanceof EmptyQueueException);
    }


    /**
     * Test if the clear() method can totally clear the arrayQueue
     *
     */
    public void testClear() {
        newArray.enqueue("apple");
        newArray.enqueue("banana");
        newArray.enqueue("orange");
        newArray.enqueue("car");
        newArray.clear();
        assertEquals(0, newArray.getSize());
    }


    /**
     * Test if the toArray() method can work correctly
     *
     */
    public void testToArray() {
        newArray.enqueue("apple");
        newArray.enqueue("apple");
        newArray.enqueue("apple");
        newArray.enqueue("apple");
        assertNotNull(newArray.toArray());
    }


    /**
     * Test if the toString() method can return the correct string.
     *
     */
    public void testToString() {
        assertEquals("[]", newArray.toString());
        newArray.enqueue("apple");
        newArray.enqueue("apple");
        newArray.enqueue("apple");
        newArray.enqueue("apple");
        assertEquals("[apple, apple, apple, apple]", newArray.toString());
    }
    
    
    /**
     * Test if the equals() method can work in the different situation
     *
     */
    public void testEquals() {
        assertFalse(newArray.equals(null));
        assertTrue(newArray.equals(newArray));
        String newOne = "apple";
        assertFalse(newArray.equals(newOne));
        newArray.enqueue("apple");
        newArray.enqueue("banana");
        newArray.enqueue("orange");
        newArray.enqueue("car");
        ArrayQueue<String> secondArray = new ArrayQueue<String>(20);
        secondArray.enqueue("apple");
        secondArray.enqueue("banana");
        secondArray.enqueue("orange");
        secondArray.enqueue("car");
        assertTrue(newArray.equals(secondArray));
        secondArray.enqueue("iphone");
        assertFalse(newArray.equals(secondArray));
        ArrayQueue<String> thirdArray = new ArrayQueue<String>(20);
        thirdArray.enqueue("iphone");
        thirdArray.enqueue("banana");
        thirdArray.enqueue("orange");
        thirdArray.enqueue("car");
        assertFalse(newArray.equals(thirdArray));
    }

}
