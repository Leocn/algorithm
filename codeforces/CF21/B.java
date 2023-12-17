package com.example.demo.codeforces.CF21;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
        double e = sc.nextInt(), d = sc.nextInt(), f = sc.nextInt();
        int ans = -1;
        if(b==0 || d==0){
            if(b!=0){
                if(e==0){
                    if(f!=0){
                        ans = 0;
                    }
                }else {
                    ans = 1;
                }
            }else if(d!=0){
                if(a==0){
                    if(c!=0){
                        ans = 0;
                    }
                }else{
                    ans =1;
                }
            }else{
                if(a==0 || e ==0){
                    if(a!=0){
                        if(f!=0){
                            ans =0;
                        }
                    }else if(e!=0){
                        if(c!=0){
                            ans=0;
                        }
                    }else {
                        if(c!=0 || f!=0){
                            ans = 0;
                        }
                    }
                }else{
                    if(c/a != f/e){
                        ans =0;
                    }
                }
            }
        }else {
            double x = -a/b, y = -c/b;
            double x1 = -e/d, y1 = -f/d;
            if(x==x1){
                if(y!=y1){
                    ans =0;
                }
            }else{
                ans = 1;
            }


        }
        System.out.println(ans);

    }
}