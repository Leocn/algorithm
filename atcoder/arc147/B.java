package com.example.demo.atcoder.arc147;

import java.util.*;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n+1];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i < n+1; i++) {
            arr[i] = sc.nextInt();
            map.put(arr[i], i);
        }
        List<String> ans = new ArrayList<>();
//        for (int i = n; i >0 ; i--) {
//            if(i%2 == map.get(i)%2){
//                if(i!= map.get(i)){
//                    for (int j = map.get(i); j < i; j+=2) {
//                        int tem = arr[j+2];
//                        arr[j] = tem;
//                        arr[j+2] = i;
//                        map.put(tem, j);
//                        map.put(i, j+2);
//                        ans.add("B "+j);
//                    }
//                }
//
//            }else{
//                int loc = map.get(i);
//                int sum =1;
//                while (loc<i){
//                    // swap 1
//                    if(sum > 0 && arr[loc+1]%2 != map.get(arr[loc+1])%2){
//                        int target = loc+1;
//                        int tem  = arr[target];
//                        arr[target] = i;
//                        arr[loc] = tem;
//                        map.put(tem, loc);
//                        map.put(i, target);
//                        ans.add("A "+loc);
//                        sum--;
//                        loc++;
//
//                    }else{
//                        int target = loc+2;
//                        int tem = arr[target];
//                        arr[loc] = tem;
//                        arr[target] = i;
//
//                        map.put(tem, loc);
//                        map.put(i, target);
//                        ans.add("B "+loc);
//                        loc+=2;
//                    }
//
//                }
//            }
//
//
//        }
        for (int i = n; i >0 ; i--) {
            if(arr[i]%2== i%2){
                continue;
            }
            for (int j = n-1; j >0 ; j--) {
                if(arr[j]%2!=j%2){

                }
            }
        }
        StringBuilder sb = new StringBuilder();
        System.out.println(ans.size());
        for (String an : ans) {
            sb.append(an).append("\n");
        }
        System.out.println(sb);
    }
}
