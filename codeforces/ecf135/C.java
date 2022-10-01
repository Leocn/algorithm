package com.example.demo.codeforces.ecf135;

import java.util.*;

public class C {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();
        while(t-->0){
            int n = scanner.nextInt();
            Map<Integer,Integer> mapA = new HashMap<>();
            Map<Integer,Integer> mapB = new HashMap<>();
            int[] arrA = new int[10];
            int[] arrB = new int[10];
            for (int i = 0; i < n; i++) {
                int s = scanner.nextInt();
                if(s<=9){
                    arrA[s]++;
                }else{
                    mapA.put(s, mapA.getOrDefault(s,0)+1);
                }

            }
            int ans = 0;
            for (int i = 0; i < n; i++) {
                int s = scanner.nextInt();
                if(s<=9){
                    if(arrA[s]>0){
                        arrA[s]--;
                    }else{
                        arrB[s]++;
                    }

                    continue;
                }
                int cnt = mapA.getOrDefault(s,0);
                if(cnt>0){
                    mapA.put(s,cnt-1 );
                }else{
                    mapB.put(s, mapB.getOrDefault(s,0)+1);
                }
            }
            for (int key : mapA.keySet()) {
                int len = (key+"").length();
                arrA[len]+=mapA.get(key);
                ans+= mapA.get(key);

            }
            for (int key : mapB.keySet()) {

                int s= (key+"").length();
                int res = arrB[s]+mapB.get(key);
                ans += mapB.get(key);
                arrA[s] -= res;
                arrB[s] = 0;

            }
            for (int i = 2; i <=9 ; i++) {
                ans+= Math.abs(arrA[i] - arrB[i]);
            }
            System.out.println(ans);

        }
    }
}
