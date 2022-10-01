package com.example.demo.codeforces.cf811;

import java.util.*;

public class D {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0) {
            String text = sc.next();
            int l = text.length();
            int n = sc.nextInt();
            String[] sa = new String[n];
            int tem = n;
            TreeMap<String, Integer> map = new TreeMap<>((a, b) -> b.length() - a.length());
            while (tem > 0) {
                map.put(sc.next(), n - tem + 1);
                tem--;
            }
            int ans = 0;
            List<List<Integer>> list = new ArrayList<>();
            boolean[] vis = new boolean[l];
            boolean flag = false;
            while (map.size() > 0) {
                Map.Entry<String, Integer> entry = map.pollFirstEntry();
                String first = entry.getKey();
                int v = entry.getValue();
                int loc = 0;

                while (loc < l) {
                    int d = 0;
                    if ((d = text.indexOf(first, loc)) >= 0) {
                        List<Integer> add = new ArrayList<>();
                        add.add(v);
                        add.add(d);
                        list.add(add);
                        ans++;
                        for (int i = d; i < d + first.length()-1; i++) {
                            vis[i] = true;
                        }
                        loc += first.length();
                        if (check(vis)) {
                            flag = true;
                            break;
                        }
                    } else {
                        loc = l;
                    }
                }
                if (flag) {
                    break;
                }
            }

            if (flag) {
                System.out.println(ans);
                for(List<Integer> li: list){
                    System.out.println(li.get(0)+ " " + li.get(1));
                }
            } else{
                System.out.println(-1);
            }

        }
    }

    private static boolean check(boolean[] vis){
        for (boolean vi : vis) {
            if (!vi) {
                return false;
            }
        }
        return true;
    }
}
