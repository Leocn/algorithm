package com.example.demo.atcoder.abc308;

import java.util.*;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char[][] cs = new char[n][m];
        for (int i = 0; i < n; i++) {
            cs[i] = sc.next().toCharArray();
        }
        Map<Character, Integer> map = new HashMap<>();
        map.put('s',0);
        map.put('n',1);
        map.put('u',2);
        map.put('k',3);
        map.put('e',4);
        if(!map.containsKey(cs[0][0])){
            System.out.println("No");
            return;
        }
        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[]{0,0,map.get(cs[0][0])});
        cs[0][0] = 'z';
        int[][] dirs = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        while (dq.size()>0){
            int[] p = dq.poll();
            for(int[] d: dirs){
                int a = d[0] + p[0];
                int b = d[1] + p[1];
                if(a<0 || a>=n ||b <0 || b>=m || !map.containsKey(cs[a][b])){
                    continue;
                }
                int next = map.get(cs[a][b]);
                if((p[2] + 1)%5!=next){
                    continue;
                }
                cs[a][b] = 'z';
                if(a== n-1 && b== m-1){
                    System.out.println("Yes");
                    return;
                }
                dq.add(new int[]{a,b,next});
            }
        }
        System.out.println("No");

    }
}
