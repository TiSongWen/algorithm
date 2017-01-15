package test;

import java.io.*;
        import java.util.*;

/**
 * 最后版本
 */
public class ProgramTest {

    public static void test(File inputFile, File outputFile, File tempFile) throws Exception {
        BufferedReader in = new BufferedReader(new FileReader(inputFile));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(outputFile)));

        String s = null;
        List<List> ll = new ArrayList(128);

        for (char i = 0; i <= 128; i++) {
            ll.add(new ArrayList<N>(20000));
        }

        while ((s = in.readLine()) != null) {
            ll.get(s.charAt(0)).add(new N(s));
        }

        for (char i = 0; i <= 128; i++) {
            List list = ll.get(i);
            if (list.size() == 0) continue;
            N[] o = new N[list.size()];
            o = (N[])list.toArray(o);
            Quick3string.sort(o);
            for (int j = 0; j < o.length; j++) {
                out.println(o[j].s);
            }
        }

        in.close();
        out.close();
    }

    private static class Quick3string {
        private static final int CUTOFF =  15;   // 插入排序的阈值

        private Quick3string() { }

        public static void sort(N[] a) {
            sort(a, 0, a.length-1, 1);
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
        public N (String s) {
            this.s = s;
            StringBuffer sb = new StringBuffer();
            for (int i = 0; s.charAt(i) != ','; i++) {
                sb.append(s.charAt(i));
            }
            t = sb.toString();
        }
    }
}
