package spacecolonies;

import queue.EmptyQueueException;
import queue.QueueInterface;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Huhua Xiao (xiaohuhua2019)

/**
 * It is a fixed size circle array based queue class.
 * 
 * @param <T>
 *            It will be replaced as other object
 * 
 * @author Huhua Xiao (xiaohuhua2019)
 * @version 04.09.2022
 */
public class ArrayQueue<T> implements QueueInterface<T> {

    private T[] queue;
    /**
     * This is the max capacity of the arrayQueue.
     */
    public static final int DEFAULT_CAPACITY = 20;
    private int enqueueIndex;
    private int dequeueIndex;
    private int size;

    /**
     * Creates a new instance of the ArrayQueue<T> class
     * 
     * @param capacity
     *            the number that arrayQueue can store
     */
    @SuppressWarnings("unchecked")
    public ArrayQueue(int capacity) {
        this.queue = (T[])new Object[capacity + 1];
        this.dequeueIndex = 0;
        this.enqueueIndex = this.queue.length - 1;
        this.size = 0;
    }


    /**
     * Create a method to get the number of stored element in the arrayQueue.
     * 
     * @return The number of the element in the arrayQueue
     */
    public int getSize() {
        return this.size;
    }


    /**
     * Creates a new method to get the length of underlying of the array.
     * 
     * @return The length of underlying of array.
     */
    public int getLengthOfUnderlyingArray() {
        return this.queue.length;
    }


    /**
     * Creates a method to check is the arrayQueue is full or not.
     * 
     * @return Return true if it is full
     */
    private boolean isFull() {
        return this.dequeueIndex == (this.enqueueIndex + 2) % this.queue.length;
    }


    /**
     * Creates a new method to clear everything in the arrayQueue
     */
    @Override
    @SuppressWarnings({ "unchecked", "static-access" })
    public void clear() {
        // TODO Auto-generated method stub
        this.queue = (T[])new Object[this.DEFAULT_CAPACITY + 1];
        this.dequeueIndex = 0;
        this.enqueueIndex = this.queue.length - 1;
        this.size = 0;

    }


    /**
     * Creates a new method to expand the capacity of the arrayQueue
     */
    @SuppressWarnings("unchecked")
    private void ensureCapacity() {
        T[] oldQueue = this.queue;
        int oldSize = this.size;
        oldQueue = (T[])new Object[(oldSize * 2) + 1];
        int value = this.dequeueIndex;
        for (int i = 0; i < oldSize; i++) {
            oldQueue[i] = this.queue[value];
            value = (value + 1) % this.queue.length;
        }
        this.dequeueIndex = 0;
        this.enqueueIndex = oldSize - 1;
        this.queue = oldQueue;   
    }


    /**
     * Create a method to delete an element from the arrayQueue.
     * 
     * @return return the dequeue element
     */
    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        // TODO Auto-generated method stub
        T value = this.getFront();
        this.queue[this.dequeueIndex] = null;
        this.dequeueIndex = (this.dequeueIndex + 1) % this.queue.length;
        this.size--;
        return value;
    }


    /**
     * Creates a new method to add an element in the arrayQueue
     * 
     * @param newElement
     *            the element will be added
     */
    @Override
    public void enqueue(T newElement) {
        // TODO Auto-generated method stub
        if (this.isFull()) {
            this.ensureCapacity();
        }
        this.enqueueIndex = (this.enqueueIndex + 1) % this.queue.length;
        this.queue[this.enqueueIndex] = newElement;
        this.size++;
    }


    /**
     * Creates a new method to get the element in dequeueIndex index.
     * 
     * @return return the element in the dequeueIndex index from the arrayQueue.
     */
    @Override
    public T getFront() {
        // TODO Auto-generated method stub
        if (this.isEmpty()) {
            throw new EmptyQueueException();
        }
        return this.queue[this.dequeueIndex];
    }


    /**
     * Creates a method to check if the arrayQueue is empty or not
     * 
     * @return return true if the arrayQueue is empty
     * 
     */
    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return this.dequeueIndex == (this.enqueueIndex + 1) % this.queue.length;
    }


    /**
     * Creates a new method to get the T[] elements to the Object[]
     * 
     * @return the Object[] that stored the elements of the T[]
     */
    @SuppressWarnings("unchecked")
    public Object[] toArray() {
        T[] newArray = (T[])new Object[this.size];
        int oldIndex = this.dequeueIndex;
        for (int i = 0; i < this.size; i++) {
            newArray[i] = this.queue[oldIndex];
            oldIndex = (oldIndex + 1) % this.queue.length;
        }
        return newArray;
    }


    /**
     * Creates a new method to return the elements as a string
     * 
     * @return return an string
     */
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (this.isEmpty()) {
            return "[]";
        }
        stringBuilder.append("[");
        int index = this.dequeueIndex;
        for (int i = 0; i < this.size; i++) {
            if (i != this.size - 1) {
                stringBuilder.append(this.queue[index].toString());
                stringBuilder.append(", ");
            }
            else {
                stringBuilder.append(this.queue[index].toString());
            }
            index = (index + 1) % this.queue.length;
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }


    /**
     * Creates a new method to check if two objects are equals or not
     * 
     * @param obj
     *            the object will be used to check
     * @return return true if the two objects are same
     */
    @SuppressWarnings("unchecked")
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (this.getClass() == obj.getClass()) {
            ArrayQueue<T> newArray = ((ArrayQueue<T>)obj);
            // test if the dequeueIndex and enqueueIndex same
            if (this.getSize() == newArray.getSize()) {
                for (int i = 0; i < this.size; i++) {
                    T myElement = this.queue[(this.dequeueIndex + i)
                        % this.queue.length];
                    T otherElement = newArray.queue[(newArray.dequeueIndex + i)
                        % newArray.queue.length];
                    if (!myElement.equals(otherElement)) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }
}
