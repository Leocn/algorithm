package com.example.demo.codeforces;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CF805C {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();
        while(t-->0){
            int length = scanner.nextInt();
            int queryTime = scanner.nextInt();
            Map<Integer, Integer> mapLeft = new HashMap<>();
            Map<Integer, Integer> mapRight = new HashMap<>();
            int[] stations = new int[length];
            int index =0;
            while(index<length){

                int d = scanner.nextInt();
                stations[index] = d;
                if(!mapLeft.containsKey(d)){
                    mapLeft.put(d, index);
                }
                mapRight.put(d, index);

                index++;

            }
            while (queryTime>0){
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                int left = mapLeft.getOrDefault(a,-1);
                int right = mapRight.getOrDefault(b,-1);
                queryTime--;
                if(left==-1 || right==-1){
                    System.out.println("NO");
                    continue;
                }
                if(left<right){
                    System.out.println("YES");
                }else{
                    System.out.println("NO");
                }

            }
        }
    }
}
