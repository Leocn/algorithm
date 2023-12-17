package com.example.demo.atcoder.abc290;

import java.util.*;

public class E {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList[] arr = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            arr[i] = new ArrayList<Integer>();
        }
        for (int i = 1; i <= n; i++) {
            arr[sc.nextInt()].add(i);
        }
        long ans = 0;
        for (int i = 1; i <=n ; i++) {
            ans += (long) (n + 1 - i) *(i/2);
        }
        for (int i = 1; i <= n; i++) {
            List<Integer> list = arr[i];
            if(list.size()==0) continue;
            int l = 0, r = list.size()-1;
            while (l<r){
                long disL = list.get(l), disR = n+1-list.get(r);
                if(disL<disR){
                    ans -= (r-l)*disL;
                    l++;
                }else {
                    ans -= (r-l)*(disR);
                    r--;
                }
            }
        }
        System.out.println(ans);



    }
}
