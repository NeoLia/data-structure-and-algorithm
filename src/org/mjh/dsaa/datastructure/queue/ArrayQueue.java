package org.mjh.dsaa.datastructure.queue;

import org.mjh.dsaa.datastructure.EmptyCapacityException;
import org.mjh.dsaa.datastructure.Scalable;

import java.util.Arrays;

/**
 * 队列-顺序存储
 * @author: Neo Lia Marx
 * @date: 2021/05/13
 */
public class ArrayQueue<E> implements Queue<E>, Scalable {
    private final int DEFAULT_INITIAL_CAPACITY = 10;
    private E[] elements;
    private int size;

    public ArrayQueue() {
        elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
        size = 0;
    }

    private void resize(int newSize) {
        elements = Arrays.copyOf(elements, newSize);
    }

    @Override
    public void enqueue(E value) {
        if (size >= elements.length) {
            resize(elements.length + (elements.length >> 1));
        }
        elements[size++] = value;
    }

    @Override
    public E dequeue() throws EmptyCapacityException {
        if (size <= 0) {
            throw new EmptyCapacityException("size <= 0");
        }

        E element = elements[0];
        for (int i = 1; i < size; i++) {
            elements[i-1] = elements[i];
        }
        size--;
        if (size < (elements.length >> 2)) {
            resize(elements.length >> 2);
        }
        return element;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(elements[i]);
            if (i == size - 1) {
                break;
            }
            sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();

        for (int i = 0; i < 100; i++) {
            arrayQueue.enqueue(i + 1);
        }
        System.out.println(arrayQueue);
        System.out.println(arrayQueue.size());
        try {
            for (int i = 0; i < 11; i++) {
                System.out.println("dequeue: " + arrayQueue.dequeue());
            }
        } catch (EmptyCapacityException e) {
            e.printStackTrace();
        }
        System.out.println(arrayQueue);
        System.out.println(arrayQueue.size());
        arrayQueue.enqueue(101);
        System.out.println(arrayQueue);
        System.out.println(arrayQueue.size());
    }
}
