package com.example.demo.codeforces.CF1786;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.*;

public class D {
    public static void main(String[] args) {
        RealFastReader sc = new RealFastReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int t = sc.ni();
        while (t-->0){
            int n = sc.ni();
            String[] arr = new String[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.ns();
            }
            Map<String , List<Integer>> map = new HashMap<>();
            Map<String, Integer> map1 = new HashMap<>();
            map1.put("i-n",0);
            map1.put("n-i",0);
            map1.put("w-i",0);
            map1.put("i-w",0);
            map1.put("w-n",0);
            map1.put("n-w",0);

            for (int i = 0; i < n; i++) {
                int[] cnt = new int[26];
                cnt['i'-'a']++;
                cnt['w'-'a']++;
                cnt['n'-'a']++;
                char[] cs = arr[i].toCharArray();
                for (int j = 0; j < 3; j++) {
                    cnt[cs[j]-'a'] --;
                }
                Set<Character> set1 = new HashSet<>();
                Set<Character> set2 = new HashSet<>();

                for (int j = 0; j < 26; j++) {
                    if(cnt[j]==0){
                        continue;
                    }
                    if(cnt[j]>0){
                        set1.add((char)('a'+j));
                    }
                    if(cnt[j]<0){
                        set2.add((char)('a'+j));
                    }
                }
                for(char c:set2){
                    for (char c1: set1) {
                        map.putIfAbsent(c+"-"+c1 , new ArrayList<Integer>());
                        map.get(c+"-"+c1).add(i+1);

                    }
                }
            }
            List<String> list = new ArrayList<>();

            for(Map.Entry<String, List<Integer>> e: map.entrySet()){

                String c = e.getKey();
                List<Integer> val = e.getValue();
                String[] a = c.split("-");
                List<Integer> tar = map.getOrDefault(a[1]+"-"+a[0], new ArrayList<>());

                int loc1 = map1.get(c);
                int loc2 = map1.get(a[1]+"-"+a[0]);
                int cnt = 0;
                for (int i = 0; i+loc1 < val.size() && i+loc2<tar.size(); i++) {
                    list.add(val.get(i+loc1) +" " + a[0] +" "+ tar.get(i+loc2)+" " + a[1]);
                    cnt++;
                }
                map1.put(c,map1.get(c)+cnt);
                map1.put(a[1]+"-"+a[0],map1.get(a[1]+"-"+a[0])+cnt);

            }
            Map<String, List<Integer>> mapNNNNNNNNNN = new HashMap<>();
            for(Map.Entry<String, List<Integer>> e: map.entrySet()){
                String c = e.getKey();
                List<Integer> val = e.getValue();
                if(map1.get(c) == val.size()){
                    continue;
                }
                for(Map.Entry<String, List<Integer>> ee: map.entrySet()){
                    String cc = ee.getKey();
                    if(c.equals(cc)){
                        continue;
                    }
                    if(c.charAt(2) != cc.charAt(0)){
                        continue;
                    }
                    List<Integer> valVal = ee.getValue();
                    if(valVal.size()==map1.get(cc)){
                        continue;
                    }
                    int loc1 = map1.get(c);
                    int loc2 = map1.get(cc);
                    int cnt = 0;
                    for (int i = 0; i+loc1 < val.size() && i+loc2<valVal.size(); i++) {

                        list.add(""+val.get(i+loc1) +" "+c.charAt(0)+" " + valVal.get(i+loc2) +" "+ cc.charAt(0));
                        mapNNNNNNNNNN.putIfAbsent(c.charAt(0) +"-" + cc.charAt(2), new ArrayList<>());
                        mapNNNNNNNNNN.get(c.charAt(0) +"-" + cc.charAt(2)).add(valVal.get(i+loc2));

                        cnt++;
                    }
                    map1.put(c,map1.get(c)+cnt);
                    map1.put(cc,map1.get(cc)+cnt);
                }

            }
            Map<String, Integer> map2 = new HashMap<>();
            map2.put("i-n",0);
            map2.put("n-i",0);
            map2.put("w-i",0);
            map2.put("i-w",0);
            map2.put("w-n",0);
            map2.put("n-w",0);
            for(Map.Entry<String, List<Integer>> e: map.entrySet()){

                String c = e.getKey();
                List<Integer> val = e.getValue();
                String[] a = c.split("-");
                List<Integer> tar = mapNNNNNNNNNN.getOrDefault(a[1]+"-"+a[0], new ArrayList<>());

                int loc1 = map1.get(c);
                int loc2 = map2.get(a[1]+"-"+a[0]);
                int cnt = 0;
                for (int i = 0; i+loc1 < val.size() && i+loc2<tar.size(); i++) {
                    list.add(val.get(i+loc1) +" " + a[0] +" "+ tar.get(i+loc2)+" " + a[1]);
                    cnt++;
                }
                map1.put(c,map1.get(c)+cnt);
                map2.put(a[1]+"-"+a[0],map1.get(a[1]+"-"+a[0])+cnt);

            }
            out.println(list.size());
            for(String l:list){
                out.println(l);
            }


        }
        out.close();
    }

    public static class RealFastReader {
        InputStream is;

        public RealFastReader(final InputStream is) {
            this.is = is;
        }

        private byte[] inbuf = new byte[8192];
        public int lenbuf = 0, ptrbuf = 0;

        public int readByte() {
            if (lenbuf == -1) {
                throw new InputMismatchException();
            }
            if (ptrbuf >= lenbuf) {
                ptrbuf = 0;
                try {
                    lenbuf = is.read(inbuf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (lenbuf <= 0) {
                    return -1;
                }
            }
            return inbuf[ptrbuf++];
        }

        private boolean isSpaceChar(int c) {
            return !(c >= 33 && c <= 126);
        }

        private int skip() {
            int b;
            while ((b = readByte()) != -1 && isSpaceChar(b))
                ;
            return b;
        }

        public double nd() {
            return Double.parseDouble(ns());
        }

        public char nc() {
            return (char) skip();
        }

        public String ns() {
            int b = skip();
            StringBuilder sb = new StringBuilder();
            while (!(isSpaceChar(b))) { // when nextLine, (isSpaceChar(b) && b != ' ')
                sb.appendCodePoint(b);
                b = readByte();
            }
            return sb.toString();
        }

        public char[] ns(int n) {
            char[] buf = new char[n];
            int b = skip(), p = 0;
            while (p < n && !(isSpaceChar(b))) {
                buf[p++] = (char) b;
                b = readByte();
            }
            return n == p ? buf : Arrays.copyOf(buf, p);
        }

        public int[] na(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = ni();
            }
            return a;
        }

        public long[] nal(int n) {
            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = nl();
            }
            return a;
        }

        public char[][] nm(int n, int m) {
            char[][] map = new char[n][];
            for (int i = 0; i < n; i++) {
                map[i] = ns(m);
            }
            return map;
        }

        public int[][] nmi(int n, int m) {
            int[][] map = new int[n][];
            for (int i = 0; i < n; i++) {
                map[i] = na(m);
            }
            return map;
        }

        public int ni() {
            int num = 0;
            int b;
            boolean minus = false;
            while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
                ;
            if (b == '-') {
                minus = true;
                b = readByte();
            }

            while (true) {
                if (b >= '0' && b <= '9') {
                    num = num * 10 + (b - '0');
                } else {
                    return minus ? -num : num;
                }
                b = readByte();
            }
        }

        public long nl() {
            long num = 0;
            int b;
            boolean minus = false;
            while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
                ;
            if (b == '-') {
                minus = true;
                b = readByte();
            }

            while (true) {
                if (b >= '0' && b <= '9') {
                    num = num * 10 + (b - '0');
                } else {
                    return minus ? -num : num;
                }
                b = readByte();
            }
        }
    }
}
