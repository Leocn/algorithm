package com.example.demo.leetcode;

import com.example.demo.atcoder.abc269.A;

import java.util.*;

public class Week311 {
    public static void main(String[] args) {
    }

    public int smallestEvenMultiple(int n) {
        if(n%2==0){
            return n;
        }else{
            return 2*n;
        }
    }

    public int longestContinuousSubstring(String s) {
        int len = 1;

        char[] cs = s.toCharArray();
        char c = cs[0];
        int ans = 0;
        for (int i = 1; i <cs.length ; i++) {
            if(cs[i]-c ==1){
                len++;

            }else{
                len=1;
            }
            ans = Math.max(len, ans);
            c = cs[i];
        }
        return  ans;
    }


    public TreeNode reverseOddLevels(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();

        deque.add(root);

        while (deque.size()!=0 ){
            Deque<TreeNode> in = new ArrayDeque<>();
            Stack<TreeNode> stack = new Stack<>();
            Deque<TreeNode> dd = new ArrayDeque<>();
            int s = deque.size();
                while (s-->0){
                    TreeNode p = deque.poll();
                    in.add(p);
                    if(p.left!=null){
                        stack.add(p.left);
                        if(p.left.left!=null){
                            dd.add(p.left.left);
                            dd.add(p.left.right);
                        }
                    }
                    if(p.right!=null){
                        stack.add(p.right);
                        if(p.right.left!=null){
                            dd.add(p.right.left);
                            dd.add(p.right.right);
                        }
                    }

                }
                while (in.size()!=0){
                    TreeNode p = in.poll();
                    if(stack.size()>0){
                        p.left = stack.pop();
                        p.right = stack.pop();
                        if(dd.size()!=0){
                            p.left.left = dd.poll();
                            deque.add(p.left.left);
                            p.left.right = dd.poll();
                            deque.add(p.left.right);
                            p.right.left = dd.poll();
                            deque.add(p.right.left);
                            p.right.right = dd.poll();
                            deque.add(p.right.right);
                        }
                    }

                }


        }
        return root;

    }
    class Trie {
        private final Map<Character,Trie> son = new HashMap<>();
        private int cnt = 0;

        public void insert(String str) {
            char[] s  = str.toCharArray();
            Trie p = this;
            for (char c : s) {
                if (p.son.get(c) == null) p.son.put(c, new Trie());

                p = p.son.get(c);
                p.cnt++;
            }

        }

        public int query(String str) {
            char[] s = str.toCharArray();
            Trie p = this;
            int sum = 0;
            for (char c : s) {
                if (p.son.get(c) == null) return 0;
                p = p.son.get(c);
                sum+= p.cnt;
            }
            return sum;
        }
    }


    public  int[] sumPrefixScores(String[] words) {
        Trie trie = new Trie();
        for (String word: words) {
            trie.insert(word);
        }
        int[] ans = new int[words.length];

        return ans;
    }
}
