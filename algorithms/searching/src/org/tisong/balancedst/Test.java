package org.tisong.balancedst;

/**
 * Created by tisong on 11/4/16.
 */
import java.util.*;
public class Test {
    Map<String,String> map;
    boolean mapped = false;

    public String infer(String expression, String[] definitions) {
        if (!mapped) {
            map = new TreeMap<String,String>();
            for (String s: definitions) {
                String[] ss = s.split(":");
                map.put(ss[0],ss[1]);
            }
            mapped = true;
        }
        String r = map.get(expression);
        if (r != null) return r;
        int i = expression.indexOf("(")+1;
        if (i == 0) return "";
        String functionName = expression.substring(0, i);
        String args = expression.substring(i, expression.length()-1);
        int parenLevel = 0;
        String curSubArg = "";
        for (int c=0; c<args.length(); c++) {
            if (args.charAt(c)==',' && parenLevel == 0) {
                functionName += infer(curSubArg, definitions) + ",";
                curSubArg = "";
            }
            else {
                if (args.charAt(c)=='(') parenLevel++;
                if (args.charAt(c)==')') parenLevel--;
                curSubArg += args.charAt(c);
            }
        }
        functionName += infer(curSubArg, definitions) + ")";
        r = map.get(functionName);
        if (r != null) return r;
        else return "";
    }

}