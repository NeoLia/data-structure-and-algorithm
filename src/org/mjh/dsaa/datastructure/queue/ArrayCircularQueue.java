package org.mjh.dsaa.datastructure.queue;

import org.mjh.dsaa.datastructure.EmptyCapacityException;
import org.mjh.dsaa.datastructure.Scalable;

import java.util.Arrays;

/**
 * 循环队列-顺序存储
 * @author: Neo Lia Marx
 * @date: 2021/05/13
 */
public class ArrayCircularQueue<E> implements Queue<E>, Scalable {
    private final int DEFAULT_INITIAL_CAPACITY = 10;
    private E[] elements;
    private int head, tail;
    private int size;

    public ArrayCircularQueue() {
        elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY + 1];
        head = 0;
        tail = 0;
        size = 0;
    }

    private void resize(int newSize) {
        elements = Arrays.copyOf(elements, newSize);
    }

    @Override
    public void enqueue(E value) {
        if (head == (tail + 1) % elements.length) {
            resize(elements.length + (elements.length >> 1));
        }

        elements[tail] = value;
        tail = (tail + 1) % elements.length;
        size++;
    }

    @Override
    public E dequeue() throws EmptyCapacityException {
        if (head == tail) {
            throw new EmptyCapacityException("head == tail");
        }
        E element = elements[head];
        head = (head + 1) % elements.length;
        size--;
        return element;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        int iterator = head;
        while (iterator != tail) {
            sb.append(elements[iterator]);
            if ((iterator + 1) == tail) {
                break;
            }
            sb.append(", ");
            iterator = (iterator + 1) % elements.length;
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        ArrayCircularQueue<Integer> arrayCircularQueue = new ArrayCircularQueue<>();

        for (int i = 0; i < 100; i++) {
            arrayCircularQueue.enqueue(i + 1);
        }
        System.out.println(arrayCircularQueue);
        System.out.println(arrayCircularQueue.size());
        try {
            for (int i = 0; i < 11; i++) {
                System.out.println("dequeue: " + arrayCircularQueue.dequeue());
            }
        } catch (EmptyCapacityException e) {
            e.printStackTrace();
        }
        System.out.println(arrayCircularQueue);
        System.out.println(arrayCircularQueue.size());
        arrayCircularQueue.enqueue(101);
        System.out.println(arrayCircularQueue);
        System.out.println(arrayCircularQueue.size());
    }
}
