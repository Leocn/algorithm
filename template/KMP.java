package com.example.demo.template;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * KMP 算法
 */
public class KMP {
    public static int[] getNext(String p) {
        int[] next = new int[p.length()];
        int j = 0;
        for (int i = 1; i < p.length(); i++) {
            while (j > 0 && p.charAt(i) != p.charAt(j)) {
                j = next[j - 1];
            }
            if (p.charAt(i) == p.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }

    public static List<Integer> KMP(String s, String p) {
        int[] next = getNext(p);
        List<Integer> res = new ArrayList<>();
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            while (j > 0 && s.charAt(i) != p.charAt(j)) {
                j = next[j - 1];
            }
            if (s.charAt(i) == p.charAt(j)) {
                j++;
            }
            if (j == p.length()) {
                res.add(i - p.length() + 1);
                j = next[j - 1];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "ABABDABACDABABCABAB";
        String p = "ABABCABAB";
        System.out.println(KMP(s, p));  // 输出：[10]
    }
}