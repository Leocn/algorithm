package com.example.demo.nowcode.N55478;

import java.util.Scanner;
import java.util.TreeMap;

public class D {
    private static Node root;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0){
            String str = sc.next();
            String arr = sc.next();

            root = new Node(false);
            int n = arr.length();
            insert(str);
            int ans = 0;
            for (int i = 0; i < n; i++) {
                Node cur = root;
                char c = arr.charAt(i);
                boolean flag = false;
                while (i<n&&cur.next.containsKey(c)){
                    cur = cur.next.get(c);
                    i++;
                    if(i==n){
                        break;
                    }
                    flag =true;
                    c = arr.charAt(i);
                }
                if(flag){
                    i--;
                }
                ans ++;
            }
            System.out.println(ans);
        }
    }

    private static class Node{
        private boolean isWord;
        private TreeMap<Character, Node> next;

        public Node(boolean isWord){
            this.isWord = isWord;
            this.next = new TreeMap<Character, Node>();
        }
    }




    public static void insert(String word) {
        Node cur = root;

        for (int i = 0; i < word.length() ; i++) {
            char c = word.charAt(i);
            if(cur.next.get(c) == null){
                cur.next.put(c,new Node(false));
            }
            cur = cur.next.get(c);
        }
        cur.isWord =true;
    }

    public static boolean search(String word) {
        Node cur = root;
        for (int i = 0; i < word.length() ; i++) {
            char c = word.charAt(i);
            if(cur.next.get(c) == null){
                return false;
            }
            cur = cur.next.get(c);
        }
        return cur.isWord;

    }

    public static boolean startsWith(String prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length() ; i++) {
            char c = prefix.charAt(i);
            if(cur.next.get(c) == null){
                return false;
            }
            cur = cur.next.get(c);
        }
        return true;
    }
}
