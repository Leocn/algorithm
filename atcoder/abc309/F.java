//package com.example.demo.atcoder.abc309;
//
//import java.util.*;
//
//class FenwickTree<T> {
//    private int _n;
//    private List<T> data;
//
//    public FenwickTree() {
//        _n = 0;
//    }
//
//    public FenwickTree(int n) {
//        _n = n;
//        data = new ArrayList<>(Collections.nCopies(n, null));
//    }
//
//    public void add(int p, T x) {
//        assert (0 <= p && p < _n);
//        p++;
//        while (p <= _n) {
//            data.set(p - 1, addValues(data.get(p - 1), x));
//            p += p & -p;
//        }
//    }
//
//    public T sum(int l, int r) {
//        assert (0 <= l && l <= r && r <= _n);
//        return subtractValues(sum(r), sum(l));
//    }
//
//    public T sum(int r) {
//        T s = null;
//        while (r > 0) {
//            s = addValues(s, data.get(r - 1));
//            r -= r & -r;
//        }
//        return s;
//    }
//
//    private T addValues(T a, T b) {
//        // Implement your own addition logic here
//        return null;
//    }
//
//    private T subtractValues(T a, T b) {
//        // Implement your own subtraction logic here
//        return null;
//    }
//}
//
//class ReduceRangeHelper<T> {
//    private List<T> values;
//
//    public ReduceRangeHelper() {
//        values = new ArrayList<>();
//    }
//
//    public void prepare() {
//        Collections.sort(values);
//        values = new ArrayList<>(new HashSet<>(values));
//    }
//
//    public int getIndex(T v) {
//        return Collections.binarySearch(values, v);
//    }
//
//    public void push(T i) {
//        values.add(i);
//    }
//
//    public int size() {
//        return values.size();
//    }
//}
//
//class Value {
//    int v;
//
//    public Value(int _v) {
//        v = _v;
//    }
//
//    public Value add(Value other) {
//        v = Math.max(v, other.v);
//        return this;
//    }
//
//    public Value plus(Value other) {
//        return new Value(v).add(other);
//    }
//}
//
//class Solution {
//    public void work() {
//        Scanner scanner = new Scanner(System.in);
//        int N = scanner.nextInt();
//        int[] h = new int[N];
//        int[] w = new int[N];
//        int[] d = new int[N];
//        ReduceRangeHelper<Integer> rrh = new ReduceRangeHelper<>();
//        for (int i = 0; i < N; i++) {
//            int[] t = new int[3];
//            for (int j = 0; j < 3; j++) {
//                t[j] = scanner.nextInt();
//            }
//            Arrays.sort(t);
//            h[i] = t[0];
//            w[i] = t[1];
//            d[i] = t[2];
//            rrh.push(w[i]);
//        }
//        rrh.prepare();
//        List<Integer> id = new ArrayList<>();
//        for (int i = 0; i < N; i++) {
//            id.add(i);
//        }
//        id.sort((a, b) -> {
//            if (h[a] == h[b]) {
//                return w[a] - w[b];
//            }
//            return h[b] - h[a];
//        });
//        FenwickTree<Value> fw = new FenwickTree<>(rrh.size());
//        for (int i : id) {
//            int ww = rrh.size() - 1 - rrh.getIndex(w[i]);
//            Value maxd = fw.sum(ww);
//            if (maxd.v > d[i]) {
//                System.out.println("Yes");
//                return;
//            }
//            fw.add(ww, new Value(d[i]));
//        }
//        System.out.println("No");
//    }
//}
//
//public class F {
//    public static void main(String[] args) {
//        Solution s = new Solution();
//        s.work();
//    }
//}
