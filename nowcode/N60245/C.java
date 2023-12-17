package com.example.demo.nowcode.N60245;


import java.util.*;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] cs = sc.next().toCharArray();
        int n = cs.length;
        int cntA = 0, cntB = 0;
        Deque<Integer> dqA = new ArrayDeque<>();
        Deque<Integer> dqB = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if(cs[i]=='0'){
                cntA ++;
                dqA.add(i);
            }else {
                cntB++;
                dqB.add(i);
            }
        }
        long ans = 0;
        if(cntA>cntB){
            for (int i = 0; i < n; i+=2) {
                ans += Math.abs(dqA.poll()-i);

            }
        }else if(cntB> cntA){
            for (int i = 0; i < n; i+=2) {
                ans += Math.abs(dqB.poll()-i);

            }
        }else {
            long resA = 0;
            for (int i = 0; i < n; i+=2) {
                resA += Math.abs(dqA.poll()-i);

            }
            long resB = 0;
            for (int i = 0; i < n; i+=2) {
                resB += Math.abs(dqB.poll()-i);

            }
            ans = Math.min(resA, resB);
        }
        System.out.println(ans);

    }
}
