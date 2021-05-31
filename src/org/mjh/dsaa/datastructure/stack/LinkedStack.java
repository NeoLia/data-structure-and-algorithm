package org.mjh.dsaa.datastructure.stack;

import org.mjh.dsaa.datastructure.EmptyCapacityException;
import org.mjh.dsaa.datastructure.Scalable;

/**
 * 栈-链式存储实现
 * @author: Neo Lia Marx
 * @date: 2021/05/13
 */
public class LinkedStack<E> implements Stack<E>, Scalable {
    private static class Node<E> {
        E data;
        Node<E> next;

        Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }
    private Node<E> head, tail;
    private int size;

    public LinkedStack() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public void push(E value) {
        Node<E> newNode = new Node<>(value, null);
        if (head == tail && head == null) {
            tail = newNode;
            head = tail;
            size++;
            return;
        }

        tail.next = newNode;
        tail = newNode;
        size++;
    }

    @Override
    public E poll() throws EmptyCapacityException {
        if (head == tail && head == null) {
            throw new EmptyCapacityException("Empty Stack.");
        }

        E e = tail.data;
        Node<E> po = head;
        while (po.next != tail) {
            po = po.next;
        }
        po.next = null;
        tail = po;
        size--;
        return e;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<E> iterator = head;
        while (iterator != null) {
            sb.append(iterator.data);
            if (iterator.next == null) {
                break;
            }
            sb.append(", ");
            iterator = iterator.next;
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        LinkedStack<Integer> linkedStack = new LinkedStack<>();

        for (int i = 0; i < 100; i++) {
            linkedStack.push(i + 1);
        }
        System.out.println(linkedStack);
        System.out.println(linkedStack.size());
        try {
            for (int i = 0; i < 11; i++) {
                System.out.println("poll: " + linkedStack.poll());
            }
        } catch (EmptyCapacityException e) {
            e.printStackTrace();
        }
        System.out.println(linkedStack);
        System.out.println(linkedStack.size());
        linkedStack.push(101);
        System.out.println(linkedStack);
        System.out.println(linkedStack.size());
    }
}
