package org.tisong.undir;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 符号表
 */
public class SymbolGraph {

    /**
     * 索引 字符 - 数字
     */
    private Map<String, Integer> st;

    /**
     * 反向索引 顶点(数字) - 字符
     */
    private String[] keys;

    /**
     * 图
     */
    private Graph G;

    /**
     * 读取文件流stream 并构造符号图
     * @param stream 文件
     * @param sp 文件分隔符
     * @throws IOException
     */
    public SymbolGraph(String stream, String sp) throws IOException {
        st = new HashMap<>();

        BufferedReader read = new BufferedReader(new FileReader(stream));

        String s = null;
        while ((s = read.readLine()) != null) {
            String[] a = s.split(sp);
            for (int i = 0; i < a.length; i++) {
                if (!st.containsKey(a[i])) {
                    st.put(a[i], st.size());
                }
            }
        }

        keys = new String[st.size()];
        for (String name : st.keySet()) {
            keys[st.get(name)] = name;
        }

        read.close();

        read = new BufferedReader(new FileReader(stream));
        G = new Graph(st.size());
        while((s = read.readLine()) != null) {
            String[] a = s.split(sp);
            int v = st.get(a[0]);
            for (int i = 1; i < a.length; i++) {
                G.addEdge(v, st.get(a[i]));
            }
        }

        read.close();
    }

    /**
     * 反向索引: 顶点v对应的字符串
     */
    public String name(int v) {
        return keys[v];
    }

    public int index(String name) {
        return st.get(name);
    }


    public boolean contains(String name) {
        return st.containsKey(name);
    }


    public Graph G() {
        return G;
    }
}
