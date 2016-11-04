package org.tisong.balancedst;

import com.sun.org.apache.regexp.internal.RE;

import java.util.TreeMap;

/**
 * Created by tisong on 11/2/16.
 */
public class RedBlackBST<Key extends Comparable<Key>, Value> {
    private final boolean RED  = true;
    private final boolean BLUE = false;

    private class Node {
        private Key key;
        private Value val;
        private Node left;
        private Node right;
        private boolean color;
        private int  N;

        public Node(Key key, Value val, Node left, Node right, boolean color) {
            this.key = key;
            this.val = val;
            this.left = left;
            this.right = right;
            this.color = color;
            this.N = 1;
        }
    }

    private Node root;

    public RedBlackBST() {
        this.root = null;
    }


    public void put(Key key, Value val) {
        root = put(root, key, val);
        root.color = BLUE;
    }

    private Node put(Node node, Key key, Value val) {

        if (node == null) {
            return new Node(key, val, null, null, RED);
        }

        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node = put(node.left, key, val);
        } else if (cmp > 0) {
            node = put(node.right, key, val);
        } else {
            node.val = val;
        }

        if (isRed(node.right) && !isRed(node.left)) {
            node = rotateLeft(node);
        }
        if (isRed(node.left) && isRed(node.left.left)) {
            node = rotateRight(node);
        }
        if (isRed(node.left) && isRed(node.right)) {
            flipColors(node);
        }

        node.N = size(node.right) + size(node.left) + 1;

        return node;
    }

    public void delete(Key key, Value val) {

    }

    private Node delete(Node node, Key key, Value val) {
        return null;
    }

    public void deleteMin() {
        if (root == null) return;
        root = deleteMin(root);
        root.color = BLUE;
    }

//    private Node deleteMin(Node node) {
//        if (node == null) {
//            return null;
//        }
//
//        if (!isTwoNode(node.left)) {
//            node = deleteMin(node.left);
//        }
//        else if (isTwoNode(node.right)) {
//            node.left.color = RED;
//            node.right.color = RED;
//            node = deleteMin(node.left.left);
//        }else if (isThrNode(node.right)){
//            Node x = node.right.left;
//            Node y = x.left;
//            Node y2 = x.right;
//            node.right.left = y2;
//            Node left = node.left;
//            y.left = left;
//
//            x.right = node.right;
//            x.left = node.left;
//            node = x;
//            node = deleteMin(node.left.left);
//        }
//
//        if (isThrNode(node)) {
//            node.left.color = node.right.color = BLUE;
//            node.color = RED;
//        }
//
//        return node;
//    }

    private Node deleteMin(Node node) {
        if (node.left == null) {
            return null;
        }

        if (!isRed(node.left) && isRed(node.right)) {
            node = moveRedLeft(node);
        }
        node.left = deleteMin(node.left);

        return balance(node);
    }

    private Node moveRedLeft(Node node) {
        colorsFlip(node);
        if (isRed(node.right.left)) {
            node.right = rotateRight(node.right);
            node = rotateLeft(node);
        }
        return node;
    }

    private void colorsFlip(Node node) {
        if (node == null) return ;
        node.color = !node.color;
        node.right.color = !node.right.color;
        node.left.color = !node.left.color;
    }

    private Node balance(Node node) {
        if (node == null) return null;

        if (isRed(node.left) && isRed(node.left.left)) {
            node = rotateRight(node);
        }
        if (isRed(node.right) && !isRed(node.left)) {
            node = rotateLeft(node);
        }
        if (isRed(node.left) && isRed(node.right)) {
            flipColors(node);
        }
        node.N = size(node.right) + size(node.left) + 1;
        return node;
    }

    public void deleteMax() {
        if (root == null) return;

        root = deleteMax(root);
    }

    private Node deleteMax(Node node) {
        if (node.right == null) {
            return null;
        }

        if (!isRed(node.right) && !isRed(node.right.left)) {
            node = moveRedRight(node);
        }
        node.right = deleteMax(node.right);

        return balance(node);
    }

    private Node moveRedRight(Node node) {
        colorsFlip(node);
        if (isRed(node.left.left)) {
            node.left = rotateRight(node.left);
            node = rotateRight(node);
        }
        return node;
    }

    private boolean isTwoNode(Node node) {

        return (node.left == null || node.left.color == BLUE)
                && (node.right == null || node.right.color == BLUE);
    }

    private boolean isThrNode(Node node) {
        return (node.left != null && node.left.color == RED)
                || (node.right != null && node.right.color == RED);
    }

    private Node rotateLeft(Node node) {
        Node  right = node .right;
        node .right = right.left;
        right.left  = node;
        right.color = node.color;
        node .color = RED;
        node .N     = size(node.left) + size(node.right) + 1;
        return right;
    }

    private Node rotateRight(Node node) {
        Node  left = node.left;
        node.left = left.right;
        left.right = node;
        left.color = node.color;
        node.color = RED;
        left.N = size(node.left) + size(node.right) + 1;
        return left;
    }

    private void flipColors(Node node) {
        node.right.color = BLUE;
        node.left.color  = BLUE;
        if (node != root) node.color = RED;
    }

    private int size(Node node) {
        return -1;
    }

    private boolean isRed(Node node) {
        return node != null && node.color;
    }
}
