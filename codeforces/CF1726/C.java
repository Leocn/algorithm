package com.example.demo.codeforces.CF1726;

import java.io.PrintWriter;
import java.util.*;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            String str = sc.next();
            List<Integer>[] arr = new List[2*n];
            for (int i = 0; i < 2*n; i++) {
                arr[i] = new ArrayList<Integer>();
            }
            arr[0].add(2*n-1);
            arr[2*n-1].add(0);
            char[] cs = str.toCharArray();
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < 2*n; i++) {

                if(cs[i]=='('){
                    stack.push(i);
                }else{
                    int p = stack.pop();
                    if( p>0 &&(stack.size()==0|| stack.peek()-p<-1  )){
                        arr[p].add(p-1);
                        arr[p-1].add(p);
                    }
                    arr[p].add(i);
                    arr[i].add(p);

                }

            }
            int ans = 0;
            Deque<Integer> deque = new ArrayDeque<>();
            boolean[] vis = new boolean[2*n];
            for (int i = 0; i < 2*n; i++) {
                if(vis[i]){continue;}
                deque.add(i);
                ans++;
                while (deque.size()>0){
                    int p = deque.poll();
                    vis[p] = true;
                    for(int s: arr[p]){
                        if(vis[s]){
                            continue;
                        }
                        deque.add(s);
                    }
                }

            }
            out.println(ans);
        }
        out.close();
    }
}
