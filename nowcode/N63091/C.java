package com.example.demo.nowcode.N63091;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            int a=sc.nextInt();
            int b=sc.nextInt();
            int l=sc.nextInt();
            int r=sc.nextInt();

            int d=b-a;
            if(d==0){
                System.out.println("0 0");
            }
            else if(d<l){
                System.out.println("-1");
            }
            else if(l==r){
                if(d%l!=0){
                    System.out.println("-1");
                }
                else{
                    d/=l;
                    System.out.println(d+" "+d);
                }
            }
            else{
                //先算最小次数，尽量选大数
                int min=d/r;
                if(d%r>=l){
                    min++;
                }
                else if(d%r>0&&d%r<l){
                    long dd=(long)min*(r-l);
                    if(dd<l-d%r){
                        System.out.println("-1");
                        continue;
                    }
                    min++;
                }
                int max=d/l;
                if(d%l!=0){
                    long dd=(long)max*(r-l);
                    if(dd<d%l){
                        System.out.println("-1");
                        continue;
                    }
                }
                System.out.println(min+" "+max);
                //sc.println(d/r+" "+(d/l));
            }
        }
    }
}
