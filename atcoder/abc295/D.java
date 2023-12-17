package com.example.demo.atcoder.abc295;

import java.util.*;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int n = str.length();
        char[] cs = str.toCharArray();
        Map<String,Integer > map = new HashMap<>();
        map.put("0000000000",1);
        int[] cnt = new int[10];
        long ans = 0;
        for (int i = 0; i < n; i++) {
            cnt[cs[i]-'0'] = (cnt[cs[i]-'0'] +1)%2;
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 10; j++) {
                sb.append(cnt[j]);
            }
            String s = new String(sb);
            if(map.containsKey(s)){
                    ans += map.get(s);
            }
            map.put(s, map.getOrDefault(s,0)+1);

        }
        System.out.println(ans);
    }

}
