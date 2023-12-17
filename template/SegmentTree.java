package com.example.demo.template;

/**
 *  线段树，动态开点
 *
 * */
public class SegmentTree {


    /**
     线段树模板,区间新加
     */
    class Node {
        Node left, right;
        int val, add;
    }
    private int N = (int) 1e9;
    private Node root = new Node();
    public void update(Node node, int start, int end, int l, int r, int val) {
        if (l <= start && end <= r) {
            node.val += (end - start + 1) * val;
            node.add += val;
            return ;
        }
        int mid = (start + end) >> 1;
        pushDown(node, mid - start + 1, end - mid);
        if (l <= mid) update(node.left, start, mid, l, r, val);
        if (r > mid) update(node.right, mid + 1, end, l, r, val);
        pushUp(node);
    }
    public int query(Node node, int start, int end, int l, int r) {
        if (l <= start && end <= r) return node.val;
        int mid = (start + end) >> 1, ans = 0;
        pushDown(node, mid - start + 1, end - mid);
        if (l <= mid) ans += query(node.left, start, mid, l, r);
        if (r > mid) ans += query(node.right, mid + 1, end, l, r);
        return ans;
    }
    private void pushUp(Node node) {
        node.val = node.left.val + node.right.val;
    }
    private void pushDown(Node node, int leftNum, int rightNum) {
        if (node.left == null) node.left = new Node();
        if (node.right == null) node.right = new Node();
        if (node.add == 0) return ;
        node.left.val += node.add * leftNum;
        node.right.val += node.add * rightNum;
        // 对区间进行「加减」的更新操作，下推懒惰标记时需要累加起来，不能直接覆盖
        node.left.add += node.add;
        node.right.add += node.add;
        node.add = 0;
    }

    /**
     * 单点修改值 与新加不同
     * */

    /**
    // *************** 下面是模版 ***************
    class Node {
        // 左右孩子节点
        Node left, right;
        // 当前节点值，以及懒惰标记的值
        int val, add;
    }
    private int N = (int) 1e9;
    private Node root = new Node();
    public void update(Node node, int start, int end, int l, int r, int val) {
        if (l <= start && end <= r) {
            node.val += val;
            node.add += val;
            return ;
        }
        int mid = (start + end) >> 1;
        pushDown(node, mid - start + 1, end - mid);
        if (l <= mid) update(node.left, start, mid, l, r, val);
        if (r > mid) update(node.right, mid + 1, end, l, r, val);
        pushUp(node);
    }
    public int query(Node node, int start, int end, int l, int r) {
        if (l <= start && end <= r) return node.val;
        int mid = (start + end) >> 1, ans = 0;
        pushDown(node, mid - start + 1, end - mid);
        if (l <= mid) ans = query(node.left, start, mid, l, r);
        if (r > mid) ans += query(node.right, mid + 1, end, l, r);
        return ans;
    }
    private void pushUp(Node node) {
        node.val = node.left.val + node.right.val;
    }
    private void pushDown(Node node, int leftNum, int rightNum) {
        if (node.left == null) node.left = new Node();
        if (node.right == null) node.right = new Node();
        if (node.add == 0) return ;
        node.left.val += node.add * leftNum;
        node.right.val += node.add * rightNum;
        // 对区间进行「加减」的更新操作，下推懒惰标记时需要累加起来，不能直接覆盖
        node.left.add += node.add;
        node.right.add += node.add;
        node.add = 0;
    }
    ***/


    /**
     * 维护最大值
     * */
    /**
     *     // *************** 下面是模版 ***************
     *     class Node {
     *         // 左右孩子节点
     *         Node left, right;
     *         // 当前节点值，以及懒惰标记的值
     *         int val, add;
     *     }
     *     private int N = (int) 1e9;
     *     private Node root = new Node();
     *     public void update(Node node, int start, int end, int l, int r, int val) {
     *         if (l <= start && end <= r) {
     *             node.val = val;
     *             node.add = val;
     *             return ;
     *         }
     *         pushDown(node);
     *         int mid = (start + end) >> 1;
     *         if (l <= mid) update(node.left, start, mid, l, r, val);
     *         if (r > mid) update(node.right, mid + 1, end, l, r, val);
     *         pushUp(node);
     *     }
     *     public int query(Node node, int start, int end, int l, int r) {
     *         if (l <= start && end <= r) return node.val;
     *         pushDown(node);
     *         int mid = (start + end) >> 1, ans = 0;
     *         if (l <= mid) ans = query(node.left, start, mid, l, r);
     *         if (r > mid) ans = Math.max(ans, query(node.right, mid + 1, end, l, r));
     *         return ans;
     *     }
     *     private void pushUp(Node node) {
     *         // 每个节点存的是当前区间的最大值
     *         node.val = Math.max(node.left.val, node.right.val);
     *     }
     *     private void pushDown(Node node) {
     *         if (node.left == null) node.left = new Node();
     *         if (node.right == null) node.right = new Node();
     *         if (node.add == 0) return ;
     *         node.left.val = node.add;
     *         node.right.val = node.add;
     *         node.left.add = node.add;
     *         node.right.add = node.add;
     *         node.add = 0;
     *     }
     */

}
