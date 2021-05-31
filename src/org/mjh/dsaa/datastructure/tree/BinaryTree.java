package org.mjh.dsaa.datastructure.tree;

import org.mjh.dsaa.datastructure.EmptyCapacityException;

/**
 * @author: Neo Lia Marx
 * @date: 2021/05/13
 */
public abstract class BinaryTree<E> {
    private static class Node<E> {
        private E data;
        private Node<E> left;
        private Node<E> right;

        public Node(E data, Node<E> left, Node<E> right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
    private Node<E> root;
    private int size;

    public BinaryTree() {
        root = null;
        size = 0;
    }

    /**
     * 加入一个树结点
     * @author Neo Lia Marx
     * @date 2021/5/13
     * @param value A tree node data.
     */
    public abstract void add(E value);

    /**
     * 移除一个树结点
     * @author Neo Lia Marx
     * @date 2021/5/13
     * @return E
     */
    public abstract E remove() throws EmptyCapacityException;

    /**
     * 构建一棵二叉树
     * @author Neo Lia Marx
     * @date 2021/5/13
     * @param elements A list of tree node data.
     */
    public abstract void build(E[] elements);
}
