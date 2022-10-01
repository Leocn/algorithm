package com.example.demo.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

/**
 * 211. 添加与搜索单词 - 数据结构设计
 * */
public class WordDictionary {
    private class Node {
        private boolean isWord;
        private TreeMap<Character, Node> next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            this.next = new TreeMap<Character, Node>();
        }
    }

    private Node root;

    public WordDictionary() {
        this.root = new Node(false);

    }

    public void addWord(String word) {
        Node cur = root;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                cur.next.put(c, new Node(false));
            }
            cur = cur.next.get(c);
        }
        cur.isWord = true;
    }

    public boolean search(String word) {
        Node cur = root;
        return search(cur,word);
    }

    public boolean search(Node cur, String word) {
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                if (cur.next.values().size() == 0) {
                    return false;
                }
                for (Node node : cur.next.values()) {
                    cur = node;
                    if(search(cur,word.substring(i+1))) return true;
                }
                return false;
            } else {
                if (cur.next.get(c) == null) {
                    return false;
                }
                cur = cur.next.get(c);
            }

        }
        return cur.isWord;
    }

    public static void main(String[] args) {
        WordDictionary w = new WordDictionary();
        w.addWord("at");w.addWord("and");w.addWord("an");w.addWord("add");
        System.out.println(w.search("a.d"));
        System.out.println(w);
        int[][] array = new int[][]{{1,2},{3,4}};
        Arrays.sort(array, Comparator.comparingInt(a -> a[0]));
    }
}
