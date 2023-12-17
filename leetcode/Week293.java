package com.example.demo.leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Week293 {

    public List<String> removeAnagrams(String[] words) {
        int n = words.length;
        boolean[] v = new boolean[n];
        for (int i = 1; i <n ; i++) {
            if(isF(words[i-1], words[i])){
                v[i] = true;
            }
        }
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if(!v[i]){
                list.add(words[i]);
            }
        }
        return list;
    }
    private boolean isF(String a, String b){
        if(a.length()!=b.length()){
            return false;
        }
        int[] cnt = new int[26];
        for (int i = 0; i <a.length() ; i++) {
            cnt[a.charAt(i)-'a']++;
        }
        for (int i = 0; i < a.length(); i++) {
            cnt[b.charAt(i)-'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if(cnt[i]!=0){
                return false;
            }
        }
        return true;
    }

    public int maxConsecutive(int bottom, int top, int[] special) {
        Arrays.sort(special);
        int ans = special[0]-bottom;
        for (int i = 1; i < special.length; i++) {
            ans = Math.max(ans, special[i] - special[i-1]-1);
        }
        ans = Math.max(top-special[special.length-1], ans);
        return ans;
    }

    public int largestCombination(int[] candidates) {
        int[] cnt = new int[32];
        for(int c: candidates){
            String str = Integer.toBinaryString(c);
            for(int i= str.length()-1; i>=0 ;i--){
                if(str.charAt(i) == '1'){
                    cnt[str.length()-1-i]++;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            ans = Math.max(cnt[i], ans);
        }
        return ans;
    }

    class CountIntervals {
        class Node {
            Node left, right;
            int val, add;
        }
        private int N = (int) 1e9;
        private Node root;
        public void update(Node node, int start, int end, int l, int r, int val) {
            if(node.val == end-start+1) return;
            if (l <= start && end <= r) {
                node.val = (end - start + 1) * val;
                //node.add = 0;
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
        public CountIntervals() {
            root = new Node();
        }

        public void add(int left, int right) {
            update(root, 1, N, left, right, 1);
        }

        public int count() {
            return query(root, 1, N, 1, N);
        }
    }

}
