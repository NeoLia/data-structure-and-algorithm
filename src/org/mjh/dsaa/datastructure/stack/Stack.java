package org.mjh.dsaa.datastructure.stack;

import org.mjh.dsaa.datastructure.EmptyCapacityException;

/**
 * 栈
 * @author: Neo Lia Marx
 * @date: 2021/05/13
 */
public interface Stack<E> {
    /**
     * 入栈
     * @author Neo Lia Marx
     * @date 2021/5/13
     * @param value A element.
     */
    void push(E value);

    /**
     * 出栈
     * @author Neo Lia Marx
     * @date 2021/5/13
     * @return E A element
     */
    E poll() throws EmptyCapacityException;

    /**
     * 获取栈元素数量
     * @author Neo Lia Marx
     * @date 2021/5/13
     * @return int
     */
    int size();
}
