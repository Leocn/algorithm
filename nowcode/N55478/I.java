package com.example.demo.nowcode.N55478;

import java.util.*;

public class I {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0){
            char[] str = sc.next().toCharArray();
            int n = str.length;
            boolean flag = true;
            Deque<Integer> dq = new ArrayDeque<>();
            int cnt =0;
            int left = -1, s = 0;
            int[] cn = new int[n+1];
            for (int i = 0; i < n; i++) {
                if(str[i]=='('){
                    dq.add(cnt++);
                }else {
                    if(dq.size()==0){
                        flag = false;
                        break;
                    }
                    int p = dq.poll();
                    cnt--;
                    cn[p]++;
                    cn[p+1] = 0;
                    if(cn[p]>2){
                        flag = false;
                        break;
                    }


                }
                if(i!=n-1 && dq.size()==0){
                    flag = false;
                    break;
                }
            }
            if(dq.size()!=0){
                flag = false;
            }
            if(flag){
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }

        }
    }
}
