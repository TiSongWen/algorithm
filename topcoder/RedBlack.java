/**
 * TopCoder- RedBlack SRM 155 Round 1
 */
public class RedBlack {
    private static final boolean RED   = true;
    private static final boolean BLACK = false;

    private Node root;
    private int  type;

    private int  sum;

    private enum type {
    	LL 
    }
    private class Node {
        int  key;
        Node left;
        Node right;
        boolean color;

        public Node(int key, boolean color) {
            this.key   = key;
            this.color = color;
            this.left  = null;
            this.right = null;
        }
    }

    public RedBlack() {
        this.root = null;
        this.type = -1;
        this.sum  = 0;
    }

    public int numTwists(int[] keys) {
        for (int i: keys)
            put(i);
        return sum;
    }

    public void put(int key) {
        root = put(root, key);
        root.color = BLACK;
    }

    private Node put(Node node, int key) {
        if (node == null) {
            return new Node(key, RED);
        }

        if (key < node.key) {
            node.left = put(node.left, key);
        } else if (key > node.key) {
            node.right = put(node.right, key);
        } else {

        }

        type = -1;
        if (isRed(node.left) && isRed(node.left.left)) {
            type = 1;
        } else if (isRed(node.left) && isRed(node.left.right)) {
            type = 2;
        } else if (isRed(node.right) && isRed(node.right.left)) {
            type = 3;
        } else if (isRed(node.right) && isRed(node.right.right)) {
            type = 4;
        }

        if (type > 0) {
            node = twists(node);
            sum++;
        }

        return node;
    }

    private Node twists(Node node) {
        switch(type) {
            case 1: node = rotateRight(node);
                break;
            case 2: node.left = rotateLeft(node.left);
                node = rotateRight(node);
                break;
            case 3: node.right = rotateRight(node.right);
                node = rotateLeft(node);
                break;
            case 4: node = rotateLeft(node);
                break;
        }
        node.color = RED;
        node.left.color = BLACK;
        node.right.color = BLACK;
        return node;
    }

    private Node rotateLeft(Node node) {
        Node fir = node;
        Node sec = node.right;
        fir.right = sec.left;
        sec.left = fir;
        sec.color = BLACK;
        fir.color = RED;
        return sec;
    }

    private Node rotateRight(Node node) {
        Node fir = node;
        Node sec = node.left;
        fir.left = sec.right;
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
