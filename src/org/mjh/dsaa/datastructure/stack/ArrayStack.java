package org.mjh.dsaa.datastructure.stack;

import org.mjh.dsaa.datastructure.EmptyCapacityException;
import org.mjh.dsaa.datastructure.Scalable;

import java.util.Arrays;

/**
 * 栈-顺序存储实现
 * @author: Neo Lia Marx
 * @date: 2021/05/13
 */
public class ArrayStack<E> implements Stack<E>, Scalable {
    private final int DEFAULT_INITIAL_CAPACITY = 10;
    private E[] elements;
    private int size;

    public ArrayStack() {
        elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
        size = 0;
    }

    private void resize(int newSize) {
        elements = Arrays.copyOf(elements, newSize);
    }

    @Override
    public void push(E value) {
        if (size >= elements.length) {
            resize(elements.length + (elements.length >> 1));
        }
        elements[size++] = value;
    }

    @Override
    public E poll() throws EmptyCapacityException {
        if (size <= 0) {
            throw new EmptyCapacityException("size <= 0");
        }
        return elements[--size];
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
        ArrayStack<Integer> arrayStack = new ArrayStack<>();

        for (int i = 0; i < 100; i++) {
            arrayStack.push(i + 1);
        }
        System.out.println(arrayStack);
        System.out.println(arrayStack.size());
        try {
            for (int i = 0; i < 11; i++) {
                System.out.println("poll: " + arrayStack.poll());
            }
        } catch (EmptyCapacityException e) {
            e.printStackTrace();
        }
        System.out.println(arrayStack);
        System.out.println(arrayStack.size());
        arrayStack.push(101);
        System.out.println(arrayStack);
        System.out.println(arrayStack.size());
    }
}
