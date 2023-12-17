package com.example.demo.codeforces.cf833;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        PrintWriter out = new PrintWriter(System.out);
        while (t-- > 0) {
            int n = sc.nextInt();
            char[] a = sc.next().toCharArray();
            char[] b = sc.next().toCharArray();
            int d = 0;
            for(int i=0;i<n;i++){
                if(a[i]!=b[i]){
                    d++;
                }
            }
            if(d!=0 && d!=n){
                out.println("No");
                continue;
            }
            boolean flag = true;
            boolean f = true;
            out.println("Yes");
            List<String> ans = new ArrayList<>();
            int s = 1, end = n;
            while (s<n){
                while (s<=n && ((a[s-1]=='0' && flag)|| (a[s-1]=='1' && !flag))){
                    s++;
                }
                while (end >=1 && ((a[end-1]=='0' && flag)|| (a[end-1]=='1' && !flag))){
                    end--;
                }
                if(s>end){
                    break;
                }
                ans.add(s + " " + end);
                flag = !flag;
                if(s!=1){
                    f = !f;
                }
            }
            if((b[0]=='0' && f) || (b[0]=='1' && !f) ){

            }else{
                ans.add(1 + " " + n);
                ans.add(1 + " " + 1);
                ans.add(2 + " " + n);
            }
            out.println(ans.size());
            for(String str: ans){
                out.println(str);
            }

        }
        out.close();
    }
}
