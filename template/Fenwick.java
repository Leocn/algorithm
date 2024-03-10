package com.example.demo.template;

class Fenwick {
    int[] tree;

    Fenwick(int n) {
        tree = new int[n + 1];
    }

    void add(int at) {
        for (at++; at < tree.length; at += at & -at) {
            tree[at]++;
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
        return pre(r) - pre(l - 1);
    }

}