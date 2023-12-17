package com.example.demo.atcoder.abc262;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ABC262C {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n =scanner.nextInt();
        int[] s = new int[n+1];
        Map<Integer,Integer> map = new HashMap<>();
        long sum = 0;
        for (int i = 1; i <= n; i++) {
            s[i] = scanner.nextInt();
            if(s[i]==i){
                sum++;
            }
            map.put(i, s[i]);
        }
        long ans = 0;
        for (int i = 1; i <= n; i++) {
            if(map.containsKey(map.get(i)) &&map.get(i) !=i && map.get(map.get(i)) == i){
                ans++;
            }
        }
        ans /=2;
        long a = 1;
        if(sum>1){
            a = a*sum*(sum-1)/2;
        }
        if(sum>1){
            ans+=a;
        }
        System.out.println(ans);
    }
}
