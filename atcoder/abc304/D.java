package com.example.demo.atcoder.abc304;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class D {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt();
        int h = sc.nextInt();
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
        }

        int c = sc.nextInt();
        TreeMap<Integer, Integer> map1 = new TreeMap<>();
        map1.put(0,0);
        for (int i = 0; i < c; i++) {
            map1.put(sc.nextInt() ,i+1);
        }
        int d = sc.nextInt();
        TreeMap<Integer, Integer> mm2 = new TreeMap<>();
        mm2.put(0,0);
        for (int i = 0; i < d; i++) {
            mm2.put(sc.nextInt() ,i+1);
        }
        int ans = 0 , min = Integer.MAX_VALUE;
        Map<String, Integer> res = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int y = map1.get(map1.floorKey(a[i]));
            int x = mm2.get(mm2.floorKey(b[i]));
            res.put(x + " " + y,res.getOrDefault(x + " " + y, 0)+1);
        }
        for(Map.Entry<String, Integer> m : res.entrySet()){
            ans = Math.max(ans, m.getValue());
            min = Math.min(min, m.getValue());
        }
        min = res.size() ==  (long)(c+1)*(d+1)?min: 0;
        System.out.println(min + " " + ans);

    }
}
