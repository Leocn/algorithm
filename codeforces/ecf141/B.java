package com.example.demo.codeforces.ecf141;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int t = sc.nextInt();
        PrintWriter out = new PrintWriter(System.out);
        while (t-->0){
            int n = sc.nextInt();
            List[] arr = new List[n];

            for (int i = 0; i < n; i++) {
                arr[i] = new ArrayList<Integer>();
            }
            int s = 1, e = n*n;
            int ss = s, ee = e;
            for(int i=0; i<n; i+=2){
                if(i==n-1){
                    for (int j=0; j<n/2; j++) {
                        arr[i].add(s);
                        arr[i].add(e);
                        s++;
                        e--;
                    }
                    arr[i].add(s);
                }else{
                    for(int j=0; j<n; j++){
                        arr[i].add(ss);
                        arr[i+1].add(ee);
                        if(j==n-1){
                            if(s<=n*n/2){
                                s++;
                            }else{
                                s--;
                            }
                            if(ss<=n*n/2){
                                ss++;
                            }else{
                                ss--;
                            }
                            if(ee<=n*n/2){
                                ee++;
                            }else{
                                ee--;
                            }
                            if(e<=n*n/2){
                                e++;
                            }else{
                                e--;
                            }
                            continue;


                        }
                        if(e==ee){
                            s++;
                            e--;
                            ee = s;

                            ss = e;
                        }else{
                            s++;
                            e--;
                            ee = e;

                            ss = s;
                        }

                    }
                }

                if(i%4!=0){
                    Collections.reverse(arr[i]);
                    if(i+1<n){
                        Collections.reverse(arr[i+1]);
                    }

                }

            }
            for (int i = 0; i < n; i++) {
                List<Integer> list = arr[i];
                StringBuilder sb = new StringBuilder();
                for(int a : list){
                    sb.append(a).append(" ");
                }
                out.println(sb);
            }

        }
        out.close();
    }
}
