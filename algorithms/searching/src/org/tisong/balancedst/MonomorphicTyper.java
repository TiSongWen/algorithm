package org.tisong.balancedst;

import java.util.*;

/**
 * Created by tisong on 11/4/16.
 */
public class MonomorphicTyper {

    private class Node {
        private String want;
        private String indeed;
        private List<String> para;
    }

    private Node root;
    private Map<String, List>  difi;

    public MonomorphicTyper() {
        this.root = null;
        this.difi = new HashMap<>();
    }

    public String infer(String expression, String[] definitions) {
        return "";

    }

    private Node buildExpreTree(String expression) {
        return null;
    }

    private void buildDifiMap(String[] definitions) {
        String key = null;
        String ret = null;
        String[] pare = null;
        String pares = null;
        for (String d : definitions) {
            int com = d.indexOf(":");
            int par = d.indexOf("(");
            ret = d.substring(com+1);
            if (par < -1) {
                // not have pare
                key = d.substring(0, com-1);
            } else {
                key = d.substring(0, par-1);
                pares = d.substring(par+1, com-1);
                StringTokenizer t = new StringTokenizer(pares.trim(), ",");
                pare=new String[t.countTokens()];
                int i=0;
                while(t.hasMoreTokens())try{
                    pare[i++]=t.nextToken();
                }catch(Exception e){}
            }
        }
        List val = new ArrayList();
        val.add(ret);
        val.add(pare);
        difi.put(key, val);
    }


}
