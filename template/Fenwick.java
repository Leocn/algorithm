package com.example.demo.template;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Fenwick {
    int[] tree;

    Fenwick(int n) {
        tree = new int[n + 1];
    }

    void add(int at, int d) {
        for (at++; at < tree.length; at += at & -at) {
            tree[at]+=d;
        }
    }

    int pre(int at) {
        int s = 0;
        for (at++; at > 0; at -= at & -at) {
            s += tree[at];
        }
        return s;
    }

    int pre(int l, int r) {
        if(l>=r){
            return 0;
        }
        return pre(r) - pre(l - 1);
    }


    /**
     * 离散 树状数组
     * */
    public class FenwickTree {
        private long[] tree;
        private int[] a;
        private Map<Integer, Integer> map = new HashMap<>();

        public FenwickTree(int[] nums) {
            discretize(nums);
            this.tree = new long[nums.length + 1];
        }

        private void discretize(int[] nums) {
            this.a = Arrays.copyOf(nums, nums.length);
            Arrays.sort(a);
            for (int i = 0; i < a.length; ++i) {
                map.put(a[i], i + 1);
            }
        }

        private int lowbit(int x) {
            return x & (-x);
        }

        public void update(int num, long val) {
            int x = map.get(num);
            while (x <= a.length) {
                tree[x] = Math.max(tree[x], val);
                x += lowbit(x);
            }
        }

        public long query(int num) {
            int x = map.get(num);
            long res = 0;
            while (x > 0) {
                res = Math.max(res, tree[x]);
                x -= lowbit(x);
            }
            return res;
        }
    }


    /**
     * 最大值
     * */
    public static class FenwickMax {
        int[] tree;
        int[] arr;
        int n;
        FenwickMax(int _n) {
            n = _n;
            tree = new int[n + 1];
            arr = new int[n+1];
            Arrays.fill(arr, Integer.MIN_VALUE/10);
            Arrays.fill(tree, Integer.MIN_VALUE/10);
        }
        private int lowbit(int x) {
            return x & (-x);
        }

        void updata(int x, int k) {
            int lx = x;
            arr[x] = k;
            while(x < n) {
                tree[x] = Math.max(tree[x], arr[lx]);
                x += lowbit(x);
            }
        }

        int query(int x, int y) {
            int ans = Integer.MIN_VALUE/10;
            while(y >= x){
                ans = Math.max(arr[y], ans);
                y --;
                for(; y - lowbit(y) >= x; y -= lowbit(y)) ans = Math.max(tree[y], ans);
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        FenwickMax fenwickMax = new FenwickMax(10);
        fenwickMax.updata(3,2);
        System.out.println(fenwickMax.query(1,3));
    }
}