package com.example.demo.template;

/**
 * 区间最大最小值线段树
 */
public class MinMaxSegmentTree {

    private static class TreeNode {
        int start, end, min, max;
        TreeNode left, right;

        TreeNode(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    private MinMaxSegmentTree.TreeNode buildTree(int[] nums, int start, int end) {
        if (start > end) return null;
        TreeNode cur = new TreeNode(start, end);
        if (start == end) {
            cur.min = nums[start];
            cur.max = nums[start];
        } else {
            int mid = start + (end - start) / 2;
            cur.left = buildTree(nums, start, mid);
            cur.right = buildTree(nums, mid + 1, end);
            cur.min = Math.min(cur.left.min, cur.right.min);
            cur.max = Math.max(cur.left.max, cur.right.max);
        }
        return cur;
    }

    private void updateTree(TreeNode node, int i, int val) {
        if (node.start == node.end) {
            node.min = val;
            node.max = val;
        } else {
            int mid = node.start + (node.end - node.start) / 2;
            if (i <= mid) updateTree(node.left, i, val);
            else updateTree(node.right, i, val);
            node.min = Math.min(node.left.min, node.right.min);
            node.max = Math.max(node.left.max, node.right.max);
        }
    }

    private int queryTree(TreeNode node, int i, int j, boolean min) {
        if (node.start == i && node.end == j) return min ? node.min : node.max;
        else {
            int mid = node.start + (node.end - node.start) / 2;
            if (j <= mid) {
                return queryTree(node.left, i, j, min);
            } else if (i >= (mid + 1)) {
                return queryTree(node.right, i, j, min);
            } else {
                int left = queryTree(node.left, i, mid, min), right = queryTree(node.right, mid + 1, j, min);
                return min ? Math.min(left, right) : Math.max(left, right);
            }
        }
    }

    TreeNode root;

    MinMaxSegmentTree(int[] nums) {
        root = buildTree(nums, 0, nums.length - 1);
    }

    public void update(int i, int val) {
        updateTree(root, i, val);
    }

    public int queryMin(int i, int j) {
        return queryTree(root, i, j, true);
    }

    public int queryMax(int i, int j) {
        return queryTree(root, i, j, false);
    }
}