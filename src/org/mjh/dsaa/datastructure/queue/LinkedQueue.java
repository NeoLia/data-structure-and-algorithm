package org.mjh.dsaa.datastructure.queue;

import org.mjh.dsaa.datastructure.EmptyCapacityException;

/**
 * 队列-链式存储
 * @author: Neo Lia Marx
 * @date: 2021/05/13
 */
public class LinkedQueue<E> implements Queue<E> {
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

    public LinkedQueue() {
        this.size = 0;
    }

    @Override
    public void enqueue(E value) {
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
    public E dequeue() throws EmptyCapacityException {
        if (head == tail && head == null) {
            throw new EmptyCapacityException("Empty queue.");
        }

        E element = head.data;
        Node<E> temp = head;
        head = head.next;
        temp.next = null;
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
        LinkedQueue<Integer> linkedQueue = new LinkedQueue<>();

        for (int i = 0; i < 100; i++) {
            linkedQueue.enqueue(i + 1);
        }
        System.out.println(linkedQueue);
        System.out.println(linkedQueue.size());
        try {
            for (int i = 0; i < 11; i++) {
                System.out.println("dequeue: " + linkedQueue.dequeue());
            }
        } catch (EmptyCapacityException e) {
            e.printStackTrace();
        }
        System.out.println(linkedQueue);
        System.out.println(linkedQueue.size());
        linkedQueue.enqueue(101);
        System.out.println(linkedQueue);
        System.out.println(linkedQueue.size());
    }
}
