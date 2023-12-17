package com.example.demo.atcoder.abc303;

import java.util.*;

public class C {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(), h = sc.nextInt(), k = sc.nextInt();
        char[] cs = sc.next().toCharArray();
        Map<Character,int[]> map = new HashMap<>();
        map.put('R', new int[]{1,0});
        map.put('L', new int[]{-1,0});
        map.put('U', new int[]{0,1});
        map.put('D', new int[]{0,-1});
        Set<String> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            String str = sc.nextInt() + "_" + sc.nextInt();
            set.add(str);
        }
        int x = 0, y = 0;

        for (int i = 0; i < n; i++) {
            int[] p = map.get(cs[i]);
            x = x+p[0];
            y = y+p[1];
            h--;
            if(h<0){
                System.out.println("No");
                return;
            }
            if(set.contains(x+"_"+y) && h<k){
                set.remove(x+"_"+y);
                h = k;
            }


        }
        System.out.println("Yes");

    }
}
