package com.example.demo.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Week205 {
    public static void main(String[] args) {

    }

    /**
     * 并查集
     * @param n
     * @param edges
     * @return
     */
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        DJSet set1 = new DJSet(n);
        DJSet set2 = new DJSet(n);
        int ans = 0;
        for(int[] e:edges) {
            int t = e[0];
            int a = e[1] - 1;
            int b = e[2] - 1;
            if (t == 3) {
                int ra1 = set1.root(a);
                int rb1 = set1.root(b);
                if (ra1 == rb1) {
                    ans++;
                } else {
                    set1.unite(ra1, rb1);
                    set2.unite(ra1, rb1);
                }
            }
        }
        for(int[] e: edges){
            int t = e[0];
            int a = e[1] - 1;
            int b = e[2] - 1;
            if(t == 1){
                int ra1 = set1.root(a);
                int rb1 = set1.root(b);
                if (ra1 == rb1) {
                    ans++;
                } else {
                    set1.unite(ra1, rb1);
                }
            }else if(t ==2){
                int ra2 = set2.root(a);
                int rb2 = set2.root(b);
                if (ra2 == rb2) {
                    ans++;
                } else {
                    set2.unite(ra2, rb2);
                }
            }
        }
        Set<Integer> f1 = new HashSet<>();
        Set<Integer> f2 = new HashSet<>();
        for(int i=0; i<n; i++){
            f1.add(set1.root(i));
            f2.add(set2.root(i));
        }
        if(f1.size()!=1 || f2.size()!=1){
            return -1;
        }
        return ans;

    }
    public class DJSet {
        public int[] upper;

        public DJSet(int n) {
            upper = new int[n];
            Arrays.fill(upper, -1);
        }

        public int root(int x) {
            return upper[x] < 0 ? x : (upper[x] = root(upper[x]));
        }

        public boolean equiv(int x, int y) {
            return root(x) == root(y);
        }

        public boolean unite(int x, int y) {
            x = root(x);
            y = root(y);
            if (x != y) {
                if (upper[y] < upper[x]) {
                    int d = x;
                    x = y;
                    y = d;
                }
                upper[x] += upper[y];
                upper[y] = x;
            }
            return x == y;
        }

        public int count() {
            int ct = 0;
            for (int u : upper) if (u < 0) ct++;
            return ct;
        }

        public int[][] toBucket() {
            int n = upper.length;
            int[][] ret = new int[n][];
            int[] rp = new int[n];
            for (int i = 0; i < n; i++) if (upper[i] < 0) ret[i] = new int[-upper[i]];
            for (int i = 0; i < n; i++) {
                int r = root(i);
                ret[r][rp[r]++] = i;
            }
            return ret;
        }
    }

}
