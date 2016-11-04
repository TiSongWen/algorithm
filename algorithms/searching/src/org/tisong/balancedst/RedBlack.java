package org.tisong.balancedst;

public class RedBlack {
    private static final boolean RED   = true;
    private static final boolean BLACK = false;

    private Node root;
    private int  sum;
    private Type type;

    private class Node {
        private int  key;
        private Node left;
        private Node right;
        private boolean color;
        public Node(int key, boolean color) {
            this.key   = key;
            this.color = color;
            this.left  = null;
            this.right = null;
        }
    }
    /**
     * Five cases for twists method
     */
    private enum Type {
        N, LL, LR, RL, RR
    }

    public RedBlack() {
        this.root = null;
        this.type = Type.N;
        this.sum  = 0;
    }

    public int numTwists(int[] keys) {
        if (keys == null) return 0;
        for (int i: keys) put(i);
        return sum;
    }

    public void put(int key) {
        root = put(root, key);
        root.color = BLACK;
    }

    private Node put(Node node, int key) {
        if (node == null) return new Node(key, RED);

        if (key < node.key) {
            node.left  = put(node.left,  key);
        } else if (key > node.key) {
            node.right = put(node.right, key);
        }

        type = Type.N;
        if (isRed(node.left) && isRed(node.left.left)) {
            type = Type.LL;
        } else if (isRed(node.left) && isRed(node.left.right)) {
            type = Type.LR;
        } else if (isRed(node.right) && isRed(node.right.left)) {
            type = Type.RL;
        } else if (isRed(node.right) && isRed(node.right.right)) {
            type = Type.RR;
        }

        if (type != Type.N) {
            node = twists(node);
            sum++;
        }
        return node;
    }

    private Node twists(Node node) {
        switch(type) {
            case LL: node = rotateRight(node);
                     break;
            case LR: node.left = rotateLeft(node.left);
                     node = rotateRight(node);
                     break;
            case RL: node.right = rotateRight(node.right);
                     node = rotateLeft(node);
                     break;
            case RR: node = rotateLeft(node);
                     break;
        }
        node.color       = RED;
        node.left.color  = BLACK;
        node.right.color = BLACK;
        return node;
    }

    private Node rotateLeft(Node node) {
        Node fir  = node;
        Node sec  = node.right;
        fir.right = sec.left;
        sec.left  = fir;
        sec.color = BLACK;
        fir.color = RED;
        return sec;
    }

    private Node rotateRight(Node node) {
        Node fir  = node;
        Node sec  = node.left;
        fir.left  = sec.right;
        sec.right = fir;
        sec.color = BLACK;
        fir.color = RED;
        return sec;
    }

    private boolean isRed(Node node) {
        return node != null && node.color == RED;
    }

    public static void main(String[] args) {
        int a[] = {6,8,10,12,4,2,18,14,16,19,7,15,9,17,13,5,11,3,1};

        int n = new RedBlack().numTwists(a);

        System.out.print(n);
    }
}
