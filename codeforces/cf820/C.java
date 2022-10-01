package com.example.demo.codeforces.cf820;

import java.io.PrintWriter;
import java.util.*;

public class C {
    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            char[] cs = s.toCharArray();
            int n = cs.length;
            List[] arr = new List[26];
            for (int i = 0; i < 26; i++) {
                arr[i] = new ArrayList<Integer>();
            }
            for(int i = 0; i< cs.length; i++){
                int loc =cs[i]-'a';
                arr[loc].add(i);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("1").append(" ");
            int from = cs[0]-'a';
            int to  = cs[n-1]-'a';
            int vS = from;
            int step = 1;
            int sum = 0;
            if(to>= from){
                for(int i =from;i<=to ;i++){
                    List<Integer> list = arr[i];
                    sum += i-vS;
                    vS = i;
                    for(int ii: list){
                        if(ii!=0 && ii!=n-1){
                            step++;
                            sb.append(ii+1).append(" ");
                        }
                    }
                }
                step++;
                sum+= to-vS;
            }else{
                for(int i =from;i>=to ;i--){
                    sum += vS-i;
                    vS = i;
                    List<Integer> list = arr[i];
                    for(int ii: list){
                        if(ii!=0&& ii!=n-1){
                            step++;
                            sb.append(ii+1).append(" ");
                        }
                    }
                }
                step++;
                sum+= vS-to;
            }


            sb.append(n);
            out.println(sum +" " +step);
            out.println(sb);

        }
        out.close();
    }
}
