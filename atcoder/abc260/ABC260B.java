package com.example.demo.atcoder.abc260;

import java.util.*;

public class ABC260B {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n =scanner.nextInt();
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int z = scanner.nextInt();
        int total = x+y+z;
        int[] math = new int[n];
        int[] english = new int[n];

        for(int i=0; i<n; i++){
            math[i] = scanner.nextInt();
        }
        for(int i=0; i<n; i++){
            english[i] = scanner.nextInt();
        }



        PriorityQueue<int[]> queue1 = new PriorityQueue<>((o1, o2) -> {
            int res = o2[0]- o1[0];
            if(res!=0){
                return res;
            }
            return o1[1]- o2[1];
        });
        PriorityQueue<int[]> queue2 = new PriorityQueue<>((o1, o2) -> {
            int res = o2[0]- o1[0];
            if(res!=0){
                return res;
            }
            return o1[1]- o2[1];
        });

        PriorityQueue<int[]> queue3 = new PriorityQueue<>((o1, o2) -> {
            int res = o2[0]- o1[0];
            if(res!=0){
                return res;
            }
            return o1[1]- o2[1];
        });

        for(int i=0; i<n; i++){
            queue1.add(new int[]{math[i], i});
            queue2.add(new int[]{english[i], i});
            queue3.add(new int[]{english[i] + math[i], i});
        }
        int[] ans = new int[total];
        int count =0;
        Set<Integer> set = new HashSet<>();
        while(x>0){
            int tem = queue1.poll()[1];
            ans[count++] = tem;
            x--;
            set.add(tem);
        }

        while (y>0){
            int tem = queue2.poll()[1];
            if(set.contains(tem)){
                continue;
            }
            ans[count++] = tem;
            y--;
            set.add(tem);
        }

        while (z>0){
            int tem = queue3.poll()[1];
            if(set.contains(tem)){
                continue;
            }
            ans[count++] = tem;
            z--;
            set.add(tem);
        }
        Arrays.sort(ans);
        for(int i=0; i<total; i++){
            System.out.println(ans[i]+1);
        }

    }

}
