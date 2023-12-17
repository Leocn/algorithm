package com.example.demo.nowcode.N61571;


import java.util.*;

public class E {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int k = sc.nextInt();
        Map<String ,Integer> cnt = new HashMap<>();
        Map<Integer,String> record = new HashMap<>();
        Map<String, int[]> loc = new HashMap<>();
        for (int i = 0; i < k; i++) {
            String str = sc.next();
            int a = sc.nextInt();
            int b = sc.nextInt();

            int w = a*1000+b;
            if(record.containsKey(w)){
                String tar = record.get(w);
                int res = str.compareTo(tar);
                if(res>0){
                    cnt.remove(tar);
                    loc.remove(tar);
                    record.put(w, str);
                    loc.put(str, new int[]{a,b});
                    cnt.merge(str, 1, Integer::sum);
                }
            }else {
                record.put(w, str);
                cnt.merge(str, 1, Integer::sum);
                loc.put(str, new int[]{a,b});
            }
        }
        Map<String ,int[]> dirs =  new HashMap<>();
        dirs.put("D",new int[]{0,1});
        dirs.put("A",new int[]{0,-1});
        dirs.put("W",new int[]{-1,0});
        dirs.put("S",new int[]{1,0});



        int q = sc.nextInt();
        while (q-->0){
            String name = sc.next();
            String s = sc.next();
            int[] p = dirs.get(s);
            if(!loc.containsKey(name)){
                System.out.println("unexisted empire.");
            }else {
                int[] lo = loc.get(name);
                int na = p[0] + lo[0];
                int nb = p[1] + lo[1];
                if(na<1 || na>n || nb<1 || nb>m){
                    System.out.println("out of bounds!");
                    continue;
                }


            }
        }






    }

}
