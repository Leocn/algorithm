package com.example.demo.nowcode.N76133;

//Java快读快写模板，不定时更新优化内容
//@可爱抱抱呀
import java.util.*;
import java.io.*;
import java.math.*;
import java.text.*;
public class G{
    static int mod=(int)1e9+7;
    static long fac[]=new long[1000000];
    //static long fac[]=new long[1000000];
    public static void main(String args[]) throws IOException{
        Read sc=new Read();

        fac[0]=1;
        for(int i=1;i<1000000;i++){
            fac[i]=fac[i-1]*i%mod;
        }
        int n=sc.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        int count[]=new int[4];
        for(int aa:a){
            count[aa]++;
        }
        long ans=1;
        for(int i=1;i<=3;i++){
            ans*=ff(i,count[i]);
            ans%=mod;
        }
        ans--;
        ans+=mod;
        ans%=mod;
        sc.println(ans);
        //sc.print(0);
        sc.bw.flush();
        sc.bw.close();
    }
    static long ff(long a,int k){
        //System.out.println(a+" "+k);
        long pp[]=new long[k+5];
        //pp[0]=1;
        for(int i=0;i<=k;i++){
            pp[i]=i+1;
        }

        long ans=0;
        if(a==1){
            Arrays.fill(pp,1);
        }
        for(int i=0;i<=k;i++){
            ans+=pp[i]*fac[k]%mod*pow(fac[k-i],mod-2)%mod*pow(fac[i],mod-2)%mod;
            ans%=mod;
        }
        //System.out.println(ans);
        return ans%mod;
    }
    static long pow(long a,int b){
        long ans=1;
        while(b!=0){
            if(b%2==1){
                ans=ans*a%mod;
            }
            a=a*a%mod;
            b>>=1;
        }
        return ans;
    }
}
//取模的数字，别少写(int)1e9+7，inf别写错类型(long)8e18
//初始化数据的时候，最小值不要傻乎乎的默认为0，因为可能有负数
//记住看数字范围，需要开long吗，需要用BigInteger吗，需要手动处理字符串吗，复杂度数量级控制在1e7或者以下了吗
//开数组的数据范围最高不能超过1e7，数据范围再大就要用哈希表离散化了
//基本数据类型不能自定义sort排序，二维数组就可以了，顺序排序的时候是小减大，注意返回值应该是int
//BFS的时候记得在循环里要往队列里push，拓扑排序要确认无环
class Read{
    BufferedReader bf;
    StringTokenizer st;
    BufferedWriter bw;
    public Read(){
        bf=new BufferedReader(new InputStreamReader(System.in));
        st=new StringTokenizer("");
        bw=new BufferedWriter(new OutputStreamWriter(System.out));
        //什么时候才能持续稳定ak力扣、AcWing呢？
        //什么时候才能ak cf的div2，（div1）呢？才能打div2不计rating呢？
        //什么时候才能ak  abc  arc 不计rating呢？
        //什么时候才能ak 牛客练习赛不计rating呢?
        //什么时候才能ak 洛谷的div2呢？才能打div2不计rating呢？
    }
    public String nextLine() throws IOException{
        return bf.readLine();
    }
    public String next() throws IOException{
        while(!st.hasMoreTokens()){
            st=new StringTokenizer(bf.readLine());
        }
        return st.nextToken();
    }
    public char nextChar() throws IOException{
        //确定下一个token只有一个字符的时候再用
        return next().charAt(0);
    }
    public int nextInt() throws IOException{
        return Integer.parseInt(next());
    }
    public long nextLong() throws IOException{
        return Long.parseLong(next());
    }
    public double nextDouble() throws IOException{
        return Double.parseDouble(next());
    }
    public float nextFloat() throws IOException{
        return Float.parseFloat(next());
    }
    public byte nextByte() throws IOException{
        return Byte.parseByte(next());
    }
    public short nextShort() throws IOException{
        return Short.parseShort(next());
    }
    public BigInteger nextBigInteger() throws IOException{
        return new BigInteger(next());
    }
    public void println(int a) throws IOException{
        bw.write(String.valueOf(a));
        bw.newLine();
        return;
    }
    public void print(int a) throws IOException{
        bw.write(String.valueOf(a));
        return;
    }
    public void println(String a) throws IOException{
        bw.write(a);
        bw.newLine();
        return;
    }
    public void print(String a) throws IOException{
        bw.write(a);
        return;
    }
    public void println(long a) throws IOException{
        bw.write(String.valueOf(a));
        bw.newLine();
        return;
    }
    public void print(long a) throws IOException{
        bw.write(String.valueOf(a));
        return;
    }
    public void println(double a) throws IOException{
        bw.write(String.valueOf(a));
        bw.newLine();
        return;
    }
    public void print(double a) throws IOException{
        bw.write(String.valueOf(a));
        return;
    }
    public void print(BigInteger a) throws IOException{
        bw.write(a.toString());
        return;
    }
    public void print(char a) throws IOException{
        bw.write(String.valueOf(a));
        return;
    }
    public void println(char a) throws IOException{
        bw.write(String.valueOf(a));
        bw.newLine();
        return;
    }
    public void println() throws IOException{
        bw.newLine();
        return;
    }
    public boolean hasNext() throws IOException{
        //本地普通IDE难以使用这个方法调试，需要按照数据组flush，刷新语句:
        //sc.bw.flush()
        //调试完可删去
        return bf.ready();
    }
}
//Trie插入新节点后，下降的命令放在if外面