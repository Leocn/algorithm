package com.example.demo.template;

/**
 * Z函数
 */
public class Z {
    public static void main(String[] args) {

    }

    public int[] zFunctionTrivial(String word){
        char[] s = word.toCharArray();
        int n = word.length();
        int[] z = new int[n];
        for (int i = 1, l = 0, r = 0; i < n; ++i) {
            if (i <= r && z[i - l] < r - i + 1) {
                z[i] = z[i - l];
            } else {
                z[i] = Math.max(0, r - i + 1);
                while (i + z[i] < n && s[z[i]] == s[i + z[i]]) ++z[i];
            }
            if (i + z[i] - 1 > r) {l = i; r = i + z[i] - 1;}
        }
        return z;
    }
}
