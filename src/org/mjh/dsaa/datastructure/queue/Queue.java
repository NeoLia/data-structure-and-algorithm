package org.mjh.dsaa.datastructure.queue;

import org.mjh.dsaa.datastructure.EmptyCapacityException;

/**
 * 队列
 * @author: Neo Lia Marx
 * @date: 2021/05/13
 */
public interface Queue<E> {
    /**
     * 入队列
     * @author Neo Lia Marx
     * @date 2021/5/13
     * @param value A element
     */
    void enqueue(E value);

    /**
     * 出队列
     * @author Neo Lia Marx
     * @date 2021/5/13
     * @return E A element.
     */
    E dequeue() throws EmptyCapacityException;

    /**
     * 获取队列元素数量
     * @author Neo Lia Marx
     * @date 2021/5/13
     * @return int
     */
    int size();
}
