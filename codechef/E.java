package com.example.demo.codechef;


import java.util.Scanner;

public class E {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();
        while(t-->0){
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }
            //Arrays.sort(arr);
            int gcd = arr[0];
            if(gcd!=1){
                for (int i = 0; i < n; i++) {
                    gcd = gcd(gcd, arr[i]);
                    if(gcd==1){
                        break;
                    }
                }
            }
            int ans =0;
            for(int i=0; i<n;i++){
                if(arr[i]==gcd){
                    ans++;
                }else{
                    if(i<n-1){
                        int tem = gcd(arr[i],arr[i+1]);
                        while(i<n-2&& tem!=gcd){
                            i++;
                            tem = gcd(tem,arr[i+1]);

                        }
                        if(tem==gcd){
                            ans ++;
                            i++;
                        }
                    }


                }
            }
            System.out.println(ans>=k?"YES":"NO");
        }

    }
    public static int gcd(int x, int y){
        if(y==0){
            return x;
        }
        return gcd(y,x%y);
    }
}
