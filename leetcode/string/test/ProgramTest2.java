package test;

import java.io.*;
/**
 * Created by tisong on 12/11/16.
 */
public class ProgramTest2 {

    public static void test(File inputFile, File outputFile, File tempFile) throws Exception {
        BufferedReader in = new BufferedReader(new FileReader(inputFile));
        PrintWriter temp = new PrintWriter(new BufferedWriter(new FileWriter(tempFile)));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(outputFile)));
        //RandomAccessFile test = new RandomAccessFile(tempFile, "r");

        String s = null;
        int length = 500000;  // 每路长度
        int offset = 10000;
        int count = 0;
        int num = 0;
        String[][] ll = new String[length][2];
        long[] t = new long[10];

        t[num++] = 0;   // 起始位置与结束位置

        int size = 0;  // 分块文件大小

        char[] sb = new char[10];

        int sbSize = 0;  // 文件大小
        while ((s = in.readLine()) != null) {
            sbSize = 0;
            for (int i = 0; s.charAt(i) != ','; i++) {
                sb[sbSize++] = s.charAt(i);
            }
            ll[count][0] = new String(sb, 0, sbSize);
            ll[count++][1] = s;
            size += s.length() + 1;
            if (count == length) {
                count = 0;
                Quick3string.sort(ll);
                for (int i = 0; i < length; i++) {
                    temp.println(ll[i][1]);
                }
                temp.println("\0");

                t[num++] = size = size +  2;
//                temp.flush();
//                if (size != test.length()) {
//                    System.out.println("size != test");
//                }
            }
        }

        if (count != 0) {
            Quick3string.sort(ll);
            for (int i = 0; i < length; i++) {
                temp.println(ll[i][1]);
            }
            temp.println("\0");
            t[num++] = size +  4;
        }
        num--;

        // 资源回收
        ll = null;
        temp.close();


        RandomAccessFile[] rs = new RandomAccessFile[num];
        for (int i = 0; i < num; i++) {
            rs[i] = new RandomAccessFile(tempFile, "r");
            rs[i].seek(t[i]);
        }


//        int pqLen = (length - offset) / num;   // pqLen = 70000
//        MinPQ.pq = new N[length - offset + 1];
//        // 第一次多路填充并归并
//        for (int i = 0; i < pqLen; i++) {
//            for (int j = 0; j < num; j++) {
//                N n = new N(rs[j].readLine(), j);
//                MinPQ.insert(n);
//            }
//        }

        MinPQ.pq = new N[length / 2 + 1];
        MinPQ.pq[0] = new N();


        // System.out.println("num is: " + num);
        // 第一次多路填充并归并
//        for (int i = 0; i < length / (2 * num); i++) {
//            for (int j = 0; j < num; j++) {
//                N n = new N(rs[j].readLine(), j);
////                MinPQ.insert(n);
//                MinPQ.pq[++MinPQ.size] = n;
//            }
//        }
//
//        while (MinPQ.size != MinPQ.pq.length - 1) {
//            int dir = MinPQ.pq.length - MinPQ.size - 1;
//            for (int j = 0; j < dir; j++) {
//                MinPQ.pq[++MinPQ.size] = new N(rs[j].readLine(), j);
//            }
//        }
//        Quick3stringN.sort(MinPQ.pq);

        MinPQ.pq = new N[num + 1]; // 数字
        for (int i = 0; i < num; i++) {
            MinPQ.insert(new N(rs[i].readLine(), i));
        }



        boolean[] flags = new boolean[num];   // 标志位，标志该路是否读取完毕 true-完毕
       // int[] countNum = new int[num];        //
        for (int i = 0; i < num; i++) {
            flags[i] = false;
           // countNum[i] = 0;
        }

        int countFlag = 0;    // 当前已读取完毕的路数


        N min = null;
        N n = null;
        // 一共3500000数据, 每次可排70000，共循环50次
        while(true) {
            // 懒惰删除 - 1 ~ pqLen, 平移却无法保证其有序性，所以树的结构必须变动
            min = MinPQ.min();
            out.println(min.s);

            if (flags[min.j]) {
                MinPQ.deleteMin();
                continue;
            }

            if ((s = rs[min.j].readLine()).length() > 5) {
                n = new N(s, min.j);
                MinPQ.deleteMinRel(n);
                n = null;
            } else {
                // 一个循环 num (7)次的操作
                flags[min.j] = true;
                countFlag++;
                MinPQ.deleteMin();
                if (countFlag == num) break;
            }


//            for (int i = 1; i <= pqLen; i++) {
//                // 获取前pqLen小的数, 该操作会循环3500000万次
//                min = MinPQ.deleteMin();
//                out.println(min.s);
//                countNum[min.j]++;
//            }

//            int sum = 0;
//            for (int i = 0; i < num; i++) {
//                sum += countNum[i];
//            }
            //System.out.println("第" + ttt + "次消耗数: " + sum);

            // 各路重新读取
//            for (int i = 0; i < num ; i++) {
//                // 该外循环会执行 7 * 50 次
//                if (flags[i]) {
//                    // 该路已经读取完毕
//                    continue;
//                }
//                while(countNum[i] > 0) { // 检测该路的消耗数是否大于0
//                    // 该循环会执行 3000000万次
//                    if ( (s = rs[i].readLine()).length() > 5 ) { // 检测该路在读取过程中是否终止
//                        countNum[i]--;
//                        MinPQ.insert(new N(s, i));
//                    } else {
//                        // 遇到终止符
//                        flags[i] = true;
//                        countFlag++;
//                        countNum[i] = 0; // 消耗数已经没有意义, 清空
//                        //  检测所有源读取完毕
//                        if (countFlag == num)
//                            break end;
//                        break;
//                    }
//                }
//                countNum[i] = 0;
//            }
           // System.out.println("第" + ttt +"次填充后堆的数量" + MinPQ.size);

        }

//
//        while(MinPQ.size != 0) {
//            out.println(MinPQ.deleteMin().s);
//        }

        in.close();
        out.close();
        for (int i = 0; i < num; i++) {
            rs[i].close();
        }
    }
    private static class Quick3string {
        private static final int CUTOFF =  15;   // 插入排序的阈值

        private Quick3string() { }

        public static void sort(String[][] a) {
            sort(a, 0, a.length-1, 0);
        }

        private static int charAt(String s, int d) {
            if (d == s.length()) return -1;
            return s.charAt(d);
        }


        private static void sort(String[][] a, int lo, int hi, int d) {
            if (hi <= lo + CUTOFF) {
                insertion(a, lo, hi, d);
                return;
            }

            int lt = lo, gt = hi;
            int v = charAt(a[lo][0], d);
            int i = lo + 1;
            while (i <= gt) {
                int t = charAt(a[i][0], d);
                if      (t < v) exch(a, lt++, i++);
                else if (t > v) exch(a, i, gt--);
                else              i++;
            }

            // a[lo..lt-1] < v = a[lt..gt] < a[gt+1..hi].
            sort(a, lo, lt-1, d);
            if (v >= 0) sort(a, lt, gt, d+1);
            sort(a, gt+1, hi, d);
        }

        private static void insertion(String[][] a, int lo, int hi, int d) {
            for (int i = lo; i <= hi; i++)
                for (int j = i; j > lo && less(a[j][0], a[j-1][0], d); j--)
                    exch(a, j, j-1);
        }

        //交换
        private static void exch(String[][] a, int i, int j) {
            String[] temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }

        private static boolean less(String v, String w, int d) {
            for (int i = d; i < Math.min(v.length(), w.length()); i++) {
                if (v.charAt(i) < w.charAt(i)) return true;
                if (v.charAt(i) > w.charAt(i)) return false;
            }
            return v.length() < w.length();
        }

        // 判断数组是否有序
        private static boolean isSorted(N[] a) {
            for (int i = 1; i < a.length; i++)
                if (a[i].t.compareTo(a[i-1].t) < 0) return false;
            return true;
        }

    }

    private static class Quick3stringN {
        private static final int CUTOFF =  15;   // 插入排序的阈值

        private Quick3stringN() { }

        public static void sort(N[] a) {
            sort(a, 0, a.length-1, 0);
        }

        private static int charAt(String s, int d) {
            if (d == s.length()) return -1;
            return s.charAt(d);
        }


        private static void sort(N[] a, int lo, int hi, int d) {
            if (hi <= lo + CUTOFF) {
                insertion(a, lo, hi, d);
                return;
            }

            int lt = lo, gt = hi;
            int v = charAt(a[lo].t, d);
            int i = lo + 1;
            while (i <= gt) {
                int t = charAt(a[i].t, d);
                if      (t < v) exch(a, lt++, i++);
                else if (t > v) exch(a, i, gt--);
                else              i++;
            }

            // a[lo..lt-1] < v = a[lt..gt] < a[gt+1..hi].
            sort(a, lo, lt-1, d);
            if (v >= 0) sort(a, lt, gt, d+1);
            sort(a, gt+1, hi, d);
        }

        private static void insertion(N[] a, int lo, int hi, int d) {
            for (int i = lo; i <= hi; i++)
                for (int j = i; j > lo && less(a[j], a[j-1], d); j--)
                    exch(a, j, j-1);
        }

        //交换
        private static void exch(N[] a, int i, int j) {
            N temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }

        private static boolean less(N v, N w, int d) {
            for (int i = d; i < Math.min(v.t.length(), w.t.length()); i++) {
                if (v.t.charAt(i) < w.t.charAt(i)) return true;
                if (v.t.charAt(i) > w.t.charAt(i)) return false;
            }
            return v.t.length() < w.t.length();
        }

        // 判断数组是否有序
        private static boolean isSorted(N[] a) {
            for (int i = 1; i < a.length; i++)
                if (a[i].t.compareTo(a[i-1].t) < 0) return false;
            return true;
        }

    }
    private static class N {
        String s;
        String t;
        int    j; // 所属哪一路
        public N() {
            this.t = "";
        }

        public N (String s) {
            this.s = s;
            StringBuffer sb = new StringBuffer();
            for (int i = 0; s.charAt(i) != ','; i++) {
                sb.append(s.charAt(i));
            }
            t = sb.toString();
        }


        public N(String s, int j) {
            this(s);
            this.j = j;
        }
    }

    private static class N2 {
        String s;
        String t;

        public N2 (String s) {
            this.s = s;
            StringBuffer sb = new StringBuffer();
            for (int i = 0; s.charAt(i) != ','; i++) {
                sb.append(s.charAt(i));
            }
            t = sb.toString();
        }
    }

    // 堆排序：总是找出前M个最小值
    private static class MinPQ {
        private static N[] pq;
        private static int size = 0;

        public static void insert(N n) {
            pq[++size] = n;   // pq[0] not used
            swim(size);
        }

//        public static N deleteMax() {
//            N max = pq[1];
//            exch(1, size--);
//            pq[size+1] = null;
//            sink(1);
//            return max;
//        }

        public static N max() {
            return pq[1];
        }

        public static N min() {
            return pq[1];
        }


        // 延迟删除
        public static N deleteMinRel(N n) {
            N min = pq[1];
            pq[1] = n;
            sink(1);
            return min;
        }

        public static N deleteMin() {
            N min = pq[1];
            exch(1, size--);
            pq[size + 1] = null;
            sink(1);
            return min;
        }

        // 从下至上
        private static void swim(int k) {
            while (k > 1 && more(k/2, k)) {
                exch(k/2, k);
                k = k/2;
            }
        }

        // 从上至下
        private static void sink(int k) {
            while (k * 2 <= size) {
                int j = 2 * k;
                if (j < size && more(j, j+1)) j++;   // select the min between right position and left position
                if (!more(k, j)) break;              // 找到位置
                exch(k, j);
                k = j;
            }
        }

        private static boolean less(int i, int j) {
            return pq[i].t.compareTo(pq[j].t) < 0;
        }

        private static boolean more(int i, int j) {
            return pq[i].t.compareTo(pq[j].t) > 0;
        }

        private static void exch(int i, int j) {
            // 位置交换
            N temp = pq[i];
            pq[i] = pq[j];
            pq[j] = temp;
        }





    }

    public static void main(String[] args) throws Exception {
        long dir = 0L;
        dir = System.currentTimeMillis();
        ProgramTest2.test(new File("/home/tisong/CodeWorld/javatest/data/input.data"), new File("/home/tisong/CodeWorld/javatest/data/output.data"),
                new File("/home/tisong/CodeWorld/javatest/data/temp.data"));

//        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(new File("/home/tisong/CodeWorld/javatest/data/input1.data"))));
//        RandomAccessFile r = new RandomAccessFile(new File("/home/tisong/CodeWorld/javatest/data/input.data"), "r");
//        for (int i = 0; i < 350; i++) {
//            String s = null;
//            while ((s = r.readLine()) != null) {
//                out.println(s);
//            }
//            r.seek(0);
//        }
        System.out.println((System.currentTimeMillis() - dir));
    }
}
