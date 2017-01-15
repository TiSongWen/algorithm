package test;




import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by tisong on 12/10/16.
 */
public class TrieST<Value> {

    private static int R = 256;
    private Node root;

    private static class Node {
        private Object val;
        private Node[] next = new Node[R];
    }

    public Value get(String key) {
        Node x = get(root, key, 0);
        if (x == null) return null;
        return (Value) x.val;
    }


    private Node get(Node x, String key, int d) {
        if (x == null)  return null;
        if (d == key.length())  return x;
        char c = key.charAt(d);
        return get(x.next[c], key, d+1);
    }

    public void put(String key, Value val) {
        root = put(root, key, val, 0);
    }

    private Node put(Node x, String key, Value val, int d) {
        if (x == null)  x = new Node();
        if (d == key.length())  { x.val = val; return x; }
        char c = key.charAt(d);
        x.next[c] = put(x.next[c], key, val, d+1);
        return x;
    }

    public Iterable<Object> keys() {
        return keysWithPrefix("");
    }

    public Iterable<Object> keysWithPrefix(String pre) {
        Queue<Object> q = new LinkedList<>();
        collect(get(root, pre, 0), pre, q);
        return q;
    }

    private void collect(Node x, String pre, Queue<Object> q) {
        if (x == null)  return ;
        if (x.val != null) q.add(x.val);
        for (char c = 0; c < R; c++) {
            collect(x.next[c], pre + c, q);
        }
    }

    //    public static void main(String[] args) throws Exception {
//        long dir = 0L;
//        System.out.println(dir = System.currentTimeMillis());
//        ProgramTest.test(new File("/home/tisong/CodeWorld/javatest/data/input.data"), new File("/home/tisong/CodeWorld/javatest/data/output.data"), null);
//
//
//        System.out.println((System.currentTimeMillis() - dir));
//    }
}
