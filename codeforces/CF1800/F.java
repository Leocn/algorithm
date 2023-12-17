package com.example.demo.codeforces.CF1800;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class F {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

            int n = sc.nextInt();
            Map<Integer, Map<Integer, Integer>> map  = new HashMap<>();
            int ans =0;
            for (int i = 0; i < n; i++) {
                char[] cs = sc.next().toCharArray();
                int[] cnt = new int[26];
                for (char c:cs){
                    cnt[c-'a'] ++;
                }
                int a = 0, b = 0,c=0,d=0;
                for (int j = 0; j < 26; j++) {
                    if(cnt[j] > 0){
                        a |= (1<<j);
                        if((a&1)==1){
                            b |=(1<<j);
                        }else {
                            d|=(1<<j);
                        }
                    }else {
                        c |=(1<<j);
                        d|=(1<<j);
                    }

                }
                out.println(a + " " + b + " " + c + " " + d  );
                if(map.containsKey(c)){
                    Map<Integer, Integer> m = map.get(c);
                    ans += m.getOrDefault(d,0);
                }
                Map<Integer, Integer> m = map.getOrDefault(a, new HashMap<>());
                int cn = m.getOrDefault(b, 0);
                m.put(b, cn+1);


            }

            out.println(ans);
        out.close();
    }
}
