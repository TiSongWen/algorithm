package org.tisong.test;

/**
 * Created by tisong on 11/7/16.
 */
public class leet337 {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {this.val = val;}
    }

    public int rob(TreeNode root) {
        if (root == null) return 0;

        return max (rob(root.right, true) + rob(root.left, true) + root.val,
                rob(root.right, false) + rob(root.left, false));
    }

    private int rob(TreeNode node, boolean flag) {
        if (node == null) { return 0; }

        if (flag) {
            return rob(node.left, false) + rob(node.right, false);
        } else {
            return max(rob(node.left, true) + rob(node.right, true) + node.val,
                    rob(node.left, false) + rob(node.right, false));
        }
    }

    private int max(int a, int b) {
        return a > b ? a : b;
    }
}
