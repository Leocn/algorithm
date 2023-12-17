package com.example.demo.atcoder.abc294;

import java.util.*;

public class E {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long l = sc.nextLong();
        long n1 = sc.nextLong(), n2 = sc.nextLong();
        Map<Long, List<long[]>> map = new HashMap<>();
        Map<Long, Integer> map2 = new HashMap<>();
        long st = 1;
        while (n1-->0){
            long a = sc.nextLong(), b = sc.nextLong();
            List<long[]> list = map.getOrDefault(a, new ArrayList<long[]>());
            list.add(new long[]{st, st+b-1});
            map.put(a, list);
            st += b;
        }
        long ans = 0;
        st = 1;
        while (n2-->0){
            long a = sc.nextLong(), b = sc.nextLong();
            long left = st, right = st+b-1;
            if(map.containsKey(a)){
                int loc = map2.getOrDefault(a, 0);
                int save = loc;
                List<long[]> list = map.get(a);
                for (int i = loc; i < list.size(); i++) {
                    long[] s = list.get(i);
                    save = i;
                    if(s[1]<left){
                        continue;
                    }
                    if(s[0]>right){
                        break;
                    }
                    ans += Math.min(right, s[1]) - Math.max(left, s[0]) +1;
                    if(s[1]>=right){
                        break;
                    }
                }
                map2.put(a,save);
            }
            st += b;
        }
        System.out.println(ans);

    }
}
