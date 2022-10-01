package com.example.demo.leetcode;

import java.util.*;

public class Month11 {
    public static void main(String[] args) {
        System.out.println(superpalindromesInRange("1999","2999999999"));
    }


    int[] parent=null;
    int[] size=null;

    public int find(int p){
        if(parent[p]==p) return p;
        parent[p]=find(parent[p]); //路径压缩
        return parent[p];
    }

    /**
     * 684. 冗余连接
     * */

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n+1];
        size = new int[n+1];
        int[] res = new int[2];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            size[i] =1;
        }


        for (int[] edge: edges) {
            int a = findRoot(edge[0]);
            int b = findRoot(edge[1]);
            if( a == b){
                res = edge;
            }else {
                unionEdge(a, b);
            }
        }
        return res;
    }
    private int findRoot(int n){
        int root = parent[n];
        if(root == n){
            return root;
        }else {
            return findRoot(root);
        }
    }

    private void unionEdge(int a, int b){
        if(size[a] == size[b]){
            parent[a] = b;
            size[a] ++;
        }else if(size[a]> size[b]){
            parent[b] = a;
        }else if(size[a]< size[b]){
            parent[a] = b;
        }

    }

    /**
     * 685. 冗余连接 II
     * TODO
     * */
    int[] unionDirected ;
    int[] lengthDirected;
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        int[] inSum = new int[n+1];

        for (int[] edge: edges) {

        }


        unionDirected = new int[n+1];
        lengthDirected = new int[n+1];
        int[] res = new int[2];
        for (int i = 1; i <= n; i++) {
            unionDirected[i] = i;
            lengthDirected[i] =1;
        }


        for (int[] edge: edges) {
            int b = findRootDirected(edge[1]);
            System.out.println(b);
            if( edge[0] == b){
                res = edge;
            }else {
                unionDirected[edge[1]] =  edge[0];
                lengthDirected[edge[0]] ++;
            }
        }
        return res;
    }

    private int findRootDirected(int n){
        int root = unionDirected[n];
        if(root == n){
            return root;
        }else {
            return findRootDirected(root);
        }
    }



    /**
     * 695. 岛屿的最大面积
     * */
    int max=0;
    public void merge(int a,int b){
        int fa=find(a);
        int fb=find(b);
        if(fa==fb) return;
        if(size[fa]>size[fb]){
            parent[fb]=fa;
            size[fa]+=size[fb];
            max=Math.max(max,size[fa]); //统计最大值
        }else{
            parent[fa]=fb;
            size[fb]+=size[fa];
            max=Math.max(max,size[fb]);
        }
    }



    public int maxAreaOfIsland(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        //init
        parent=new int[m*n];
        size=new int[m*n];
        for (int i=0;i<m*n;i++){
            parent[i]=i;
            size[i]=1;
        }
        //1 1 1 1
        //1 1 1 1
        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                if(grid[i][j]==1){
                    //特判一下 hahaha~ 感觉如果不是lc有wacase我还挺难发现这个
                    max=Math.max(max,1);
                    //和前面,上面的合并
                    if(i>0 && grid[i-1][j]==1) merge(i*n+j,(i-1)*n+j);
                    if(j>0 && grid[i][j-1]==1) merge(i*n+j,i*n+j-1);
                }
            }
        }
        return max;
    }

    /**
     * 547. 省份数量
     * */


    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        parent=new int[n];
        size = new int[n];
        int sum = n;
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(isConnected[i][j] == 1){
                    int rootA = find(i);
                    int rootB = find(j);

                    if(rootA == rootB) continue;
                    unionEdge(rootA,rootB);
                    sum --;
                }
            }
        }
        return sum;

    }

    /**
     * 200. 岛屿数量
     * 并查集
     * */
    int sum = 0;
    public void mergeIslands(int a,int b){
        if(a==b) return;
        if(size[a]>size[b]){
            parent[b]=a;
            size[a]+=size[b];
            //统计最大值
        }else{
            parent[a]=b;
            size[b]+=size[a];

        }
    }

    public int numIslands(char[][] grid) {

        int m=grid.length;
        int n=grid[0].length;
        //init
        parent=new int[m*n];
        size=new int[m*n];
        for (int i=0;i<m*n;i++){
            parent[i]=i;
            size[i]=1;
        }
        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                if(grid[i][j]=='1'){
                    System.out.println(i +"--"+j);

                    sum++;
                    int fa=find(i*n+j);

                    int fb= Integer.MAX_VALUE;
                    int fc = Integer.MAX_VALUE;

                    //和前面,上面的合并
                    if(i>0 && grid[i-1][j]=='1'){
                        fb = find((i-1)*n+j);
                        sum--;
                        mergeIslands(fa,fb);
                        fa=fb;
                    }

                    if(j>0 && grid[i][j-1]=='1') {
                        fc = find(i*n+j-1);
                        if(fb!=fc){
                            sum--;
                            mergeIslands(fa,fc);

                        }

                    }
                    System.out.println(sum);
                }
            }
        }
        return sum;
    }

    /**
     * 391. 完美矩形
     * */
    public boolean isRectangleCover(int[][] rectangles) {
        //总面积
        int sum = 0;
//        int left = Integer.MAX_VALUE;
//        int right = Integer.MIN_VALUE;
//        int top = Integer.MIN_VALUE;
//        int bottom = Integer.MAX_VALUE;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < rectangles.length; i++) {
            //计算总小矩形的面积
            sum += (rectangles[i][3] - rectangles[i][1]) * (rectangles[i][2] - rectangles[i][0]);
            //分别记录小矩形的坐标
            String lt = rectangles[i][0] + " " + rectangles[i][3];
            String lb = rectangles[i][0] + " " + rectangles[i][1];
            String rt = rectangles[i][2] + " " + rectangles[i][3];
            String rb = rectangles[i][2] + " " + rectangles[i][1];
            //如果有就移除 没有就加入
            if (!set.contains(lt)) set.add(lt);
            else set.remove(lt);
            if (!set.contains(lb)) set.add(lb);
            else set.remove(lb);
            if (!set.contains(rt)) set.add(rt);
            else set.remove(rt);
            if (!set.contains(rb)) set.add(rb);
            else set.remove(rb);
        }
        if(set.size() != 4){
            return false;
        }
        Set<Integer> l = new HashSet<>();
        Set<Integer> h = new HashSet<>();

        for(String str : set) {
            String[] s = str.split(" ");
            l.add(Integer.parseInt(s[0]));
            h.add(Integer.parseInt(s[1]));
        }
        if(l.size()!=2 || h.size()!=2){
            return false;
        }
        int length = 0;
        int width = 0;
        for(Integer a : l) {
            length = a-length;
        }
        for(Integer a : h) {
            width = a-width;
        }

        return Math.abs(length * width) == sum;
    }

    /**
     * 318. 最大单词长度乘积
     * */
    public int maxProduct(String[] words) {
        int n = words.length;
        int[] l = new int[n];
        int[] array = new int[n ];
        for (int i=0; i<n; i++) {
            int ig = 0;
            char[] c = words[i].toCharArray();
            for (char value : c) {
                ig |= 1 << (value - 'a');

            }
            l[i] = c.length;
            array[i] = ig;

        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = n-1; j >=i ; j++) {
                if((array[i] & array[j]) == 0){
                    res = Math.max(res, l[i]*l[j]);
                }
            }
        }
        return res;
    }

    /**
     * 54. 螺旋矩阵
     * */
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int r=m-1, d= n-1, l =0,t =0;


        List<Integer> res = new ArrayList<>();
        while (l<=r && t<=d){
            for (int i = l; i <= r ; i++) {
                res.add(matrix[t][i]);
            }
            t++;
            for (int i = t; i <= d ; i++) {
                res.add(matrix[i][r]);
            }
            r--;

            for (int i = r; i >= l ; i--) {
                res.add(matrix[d][i]);
            }
            d--;

            for (int i = d; i >= t ; i--) {
                res.add(matrix[i][l]);
            }
            l++;

        }
        return res;


    }

    /**
     * 59. 螺旋矩阵 II
     * */
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int count = 0;
        int r=n-1, d= n-1, l =0,t =0;


        while (l<=r && t<=d){
            for (int i = l; i <= r ; i++) {
                res[t][i] = count;
                count++;
            }
            t++;
            for (int i = t; i <= d ; i++) {
                res[i][r] = count;
                count++;
            }
            r--;

            for (int i = r; i >= l ; i--) {
                res[d][i] = count;
                count++;
            }
            d--;

            for (int i = d; i >= t ; i--) {
                res[i][l] = count;
                count++;
            }
            l++;

        }
        return res;
    }

    /**
     * 563. 二叉树的坡度
     * */
    int sumTilt =0;
    public int findTilt(TreeNode root) {
        sumTilt+= getTreeValue(root);
        return sumTilt;

    }
    private int getTreeValue(TreeNode root){
        if(root==null) return 0;
        int l = 0;
        int r = 0;
        if(root.left!=null){
            l = getTreeValue(root.left)+root.left.val;
        }
        if(root.right!=null){
            r = getTreeValue(root.right)+root.right.val;
        }
        sumTilt+= Math.abs(l-r);
        return  l+r+root.val;
    }

    /**
     * 397. 整数替换
     * */
    public int integerReplacement(int n) {
        int res = 0;
        if(n==1) return 0;
        if((n&1)==0){
            res = 1+ integerReplacement(n>>1);
        }else {
            if(n== Integer.MAX_VALUE){ res = 2 + integerReplacement(n/2); }else{
                res = 1 + Math.min(integerReplacement(n-1), integerReplacement(n+1));
            }
        }
        return res;
    }

    /**
     * 43. 字符串相乘
     * */
    public String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();

        int[] res = new int[m+n];

        for (int i = m-1; i >=0 ; i--) {
            for (int j = n-1; j >=0 ; j--) {
                res[m+n-2-i-j] += (num1.charAt(i)-'0')* (num2.charAt(j)-'0');
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            int t = res[i];
            res[i] = 0;
            int count = 0;
            while (t>=10){
                res[i+count] += t%10;
                count++;
                t = t/10;
            }
            res[i+count] += t;
        }
        for (int i = res.length-1; i >=0; i--) {
            int count = 0;
            if(res[i]>0) {
                count++;
            }
            if(count>0){
               sb.append(res[i]);
            }

        }
        return sb.length()==0 ?"0":sb.toString();
    }
    /**
     * 61. 旋转链表
     * */
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null) return null;
        ListNode cur = head;
        int length= 1;
        while (cur.next!=null){
            length++;
            cur = cur.next;
        }
        
        int move = k%length;
        if(move==0) return head;
        ListNode l = head;
        int count =1;
        ListNode returnHead = null;
        while (l.next!=null){
            l = l.next;
            count++;
            if(count == move){
                returnHead = l.next;
                l.next = null;
                cur.next = head;
                break;
            }
        }
        return returnHead;
    }

    /**
     * 24. 两两交换链表中的节点
     * */
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode cur = head;
        ListNode res = head.next;
        ListNode back = new ListNode();
        while (cur!=null && cur.next!=null){
            ListNode t = cur.next.next;
            ListNode next = cur.next;
            next.next = cur;
            cur.next =null;
            back.next = next;
            back = cur;
            cur = t;

        }
        return res;
    }

    /**
     * 1019. 链表中的下一个更大节点
     * */
    public int[] nextLargerNodes(ListNode head) {
        if(head==null ) return new int[0];
        int len = 1;
        ListNode cur = head.next;
        while (cur!=null){
            cur = cur.next;
            len++ ;
        }
        int[] res = new int[len];

        len = 1;
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> positions = new Stack<>();
        stack.push(head.val);
        positions.push(len-1);
        int before = head.val;
        head = head.next;
        while (head!=null){
            if(head.val>before){
                while (!stack.isEmpty()){
                    if(head.val > stack.peek()){
                        res[positions.pop()] = head.val;
                        stack.pop();
                    }else {
                        break;
                    }

                }
            }
            before = head.val;
            stack.push(head.val);
            len++;
            positions.push(len-1);
            head = head.next;
        }
        return  res;
    }

    /**
     * 86. 分隔链表
     * */
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null) return head;
        ListNode sm = new ListNode();
        ListNode bg = new ListNode();
        ListNode cu1 = sm;
        ListNode cu2 = bg;
        while (head!=null){
           ListNode t =  head.next;
            if(head.val>=x){
                cu2.next = head;
                cu2 = cu2.next;
                cu2.next = null;
            }else {
                cu1.next = head;
                cu1 = cu1.next;
            }
            head = t;
        }
        cu1.next = bg.next;
        return sm.next;
    }

    /**
     * 1669. 合并两个链表
     * */
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode cur = list1;
        ListNode tail = null;
        ListNode first = null;
        while (cur!=null){
            if(cur.val ==a){
                tail.next = null;
            }else if(cur.val ==b){
                first = cur.next;
                break;
            }else {
                tail = cur;
            }

            cur = cur.next;
        }
        tail.next = list2;
        while (tail!=null){
            tail = tail.next;
        }
        tail.next = first;
        return list1;

    }

    /**
     * 1721. 交换链表中的节点
     * */
    public ListNode swapNodes(ListNode head, int k) {
        int count = 1;
        ListNode quick = head;
        ListNode slow = head;
        ListNode oneK = null;
        while (quick!=null){

            if(count == k){
                oneK = quick;
            }
            if(count>k){
                slow = slow.next;
            }
            quick = quick.next;
        }

        int tem = slow.val;
        slow.val = oneK.val;
        oneK.val = tem;
        return head;
    }

//    /**
//     * 148. 排序链表
//     * */
//    public ListNode sortList(ListNode head) {
//        if(head )
//        ListNode quick = head;
//        ListNode slow = head;
//        while (quick!=null){
//
//        }
//    }

    /**
     * 面试题 04.03. 特定深度节点链表
     * */
    public ListNode[] listOfDepth(TreeNode tree) {
        if(tree==null) return new ListNode[0];
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(tree);
        List<ListNode> res = new ArrayList<>();

        while (!queue.isEmpty()){
            ListNode r = null;
            ListNode cur = null;
            int s= queue.size();
            for (int i = 0; i < s; i++) {
                TreeNode t = queue.poll();
                if(t.left!=null){
                    queue.add(t.left);
                }
                if(t.right!=null){
                    queue.add(t.right);
                }
                if(r==null){
                    r = new ListNode(t.val);
                    cur =r;
                }else {
                    cur.next = new ListNode(t.val);
                    cur = cur.next;
                }
            }

            res.add(r);

        }
        return  res.toArray(new ListNode[0]) ;
    }


    /**
     * 1367. 二叉树中的列表
     * */
    public boolean isSubPath(ListNode head, TreeNode root) {
        if (root == null)
            return false;
        return isSubPathFromRoot(head, root)
                || isSubPath(head, root.left)
                || isSubPath(head, root.right);
    }
    //从根节点开始向下找
    private boolean isSubPathFromRoot(ListNode head, TreeNode root) {
        if (head == null)
            return true;
        if (root == null)
            return false;
        if (root.val == head.val)
            return isSubPathFromRoot(head.next, root.left) || isSubPathFromRoot(head.next, root.right);
        return false;
    }

    /**
     * 384. 打乱数组
     * */
    private class Solution {
        int[] nums;
        Random r = new Random();
        public Solution(int[] nums) {
            this.nums = nums;
        }

        public int[] reset() {
            return this.nums;
        }

        public int[] shuffle() {

            int l = nums.length;
            int[] res = Arrays.copyOf(nums,l);
            for (int i = l; i > 1; i--) {
                int replace= r.nextInt(i);
                int tem = res[i-1];
                res[i-1] = res[replace];
                res[replace] = tem;
            }
            return res;
        }
    }

    /**
     * 859. 亲密字符串
     * */
    public boolean buddyStrings(String s, String goal) {
        if(s.length()!=goal.length()) return false;
        Set<Character> set = new HashSet<>();
        if(s.equals(goal)){
            for (int i = 0; i < s.length(); i++) {
                if(!set.add(s.charAt(i))){
                    return true;
                }
            }
            return false;
        }else {
            Set<Character> set2 = new HashSet<>();
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                if(s.charAt(i) != goal.charAt(i)){
                    count ++;
                    set.add(s.charAt(i));
                    set2.add(goal.charAt(i));
                    if(count>2) return false;
                }

            }
            if(count!=2) return false;
            for (char c: set) {
                if(!set2.contains(c)){
                    return false;
                }
            }
            return true;

        }
    }

    /**
     * 423. 从英文中重建数字
     * */
    public String originalDigits(String s) {
        int[] res = new int[10];
        for (char c: s.toCharArray()) {
            if(c=='z'){
                res[0]++;
            }else if(c=='u'){
                res[4]++;
            }else if(c=='x'){
                res[6]++;
            }else if(c=='w'){
                res[2]++;
            }else if(c=='o'){
                res[1]++;
            }else if(c=='f'){
                res[5]++;
            }else if(c=='v'){
                res[7]++;
            }else if(c=='n'){
                res[9]++;
            }else if(c=='r'){
                res[3]++;
            }else if(c=='h'){
                res[8]++;
            }

        }
        res[1] = res[1] - res[0]- res[2]-res[4];
        res[5] =res[5]- res[4];
        res[7] =res[7] -res[5];
        res[9] = (res[9] - res[7] - res[1])/2;
        res[3] = res[3] - res[4] - res[0];
        res[8] =res[8]- res[3];

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            while (res[i]>0){
                sb.append(i);
                res[i]--;
            }
        }
        return new String(sb);
    }

    /**
     * 906. 超级回文数
     * */
    static List<Long> list = new ArrayList<>();
    static {
        superpalindromesInRange();
    }
    public static void superpalindromesInRange() {
        for (int i = 1; i < 10; i++) {
            if (kMirror(Long.toString(i*i))) {
                list.add((long) i*i);
            }
        }
        for (int i = 0;i<5; i++) {
            for (int j = (int) Math.pow(10, i); j < (int) Math.pow(10, i + 1); j++) {
                long lo = Long.parseLong("" + j + new StringBuilder("" + j).reverse()) ;
                if (kMirror(Long.toString( lo * lo  ) )) {
                    list.add(lo * lo);
                }
            }
            for (int j = (int) Math.pow(10, i); j < (int) Math.pow(10, i + 1); j++) {
                for (int l = 0; l < 10; l++) {
                    long lo = Long.parseLong("" + j + l + new StringBuilder("" + j).reverse()) ;
                    if (kMirror(Long.toString( lo * lo))) {
                        list.add(lo * lo);
                    }
                }
            }
        }

    }
    public static boolean kMirror(String s) {
        if(s.length()==0) return false;
        int left = 0;
        int right = s.length()-1;
        while(left<right ){
            char le = s.charAt(left);
            char ri = s.charAt(right);
            if( le!=ri){
                return false;
            }
            left++;
            right--;

        }
        return true;
    }

    public static int superpalindromesInRange(String left, String right) {
        int res =0;
        for (int i = 0; i < list.size() ; i++) {
            if( Long.parseLong(left)<=list.get(i) && Long.parseLong(right)>=list.get(i) ){
                res++;
            }
        }
        return res;
    }

    public int eatenApples(int[] apples, int[] days) {
        int res =0;
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)->a[0]-b[0]);
        for(int i = 0; i<apples.length; i++){
            if(apples[i]>0){
                queue.add(new int[]{i+ days[i], apples[i]});
            }
            while (!queue.isEmpty()){
                int[] e = queue.poll();
                if(e[0]<i){continue;}
                if(e[1]-1>0){
                    e[0]  = e[0] - 1;
                    queue.add(e);
                }
                res++;

                break;
            }
        }
        return res;
    }

}
