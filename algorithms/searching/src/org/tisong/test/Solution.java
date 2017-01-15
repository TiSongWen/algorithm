package org.tisong.test;

import java.util.Stack;

public class Solution {
    private int step = 0;

    /**
     * 初步思路
     */
    public String decodeStringTiSong(String s) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length();) {
            sb.append(ds(s.substring(i)));
            i += step;
        }
        return sb.toString();
    }

    private String ds(String s) {
        step = 0;
        Character.isDigit('1');
        StringBuffer sb = new StringBuffer();
        StringBuffer result = new StringBuffer();
        if (s.charAt(0) <= '0' || s.charAt(0) >= '9') {
            for (int i = 0; i < s.length() && (s.charAt(i) < '0' || s.charAt(i) > '9'); i++) {
                sb.append(s.charAt(i));
                step++;
            }
            return sb.toString();
        }

        int num = getNum(s);
        int start ;
        for (start = step; start < s.length(); start++) {
            char c = s.charAt(start);
            if (c >= '0' && c <= '9'){
                sb.append(ds(s.substring(start)));
                start += step - 1;
                continue;
            } else if (c == ']') {
                break;
            } else if (c == '[') {
                continue;
            } else {
                sb.append(c);
            }
        }

        for (int i = 0; i < num; i++) {
            result.append(sb);
        }

        step = start < s.length() ? start + 1 : start;
        return result.toString();
    }

    private int getNum(String s) {
        StringBuffer num = new StringBuffer();
        for (int i = 0; i < s.length(); i++, step++) {
            char n = s.charAt(i);
            if (n == '[') { break; }
            num.append(n);
        }
        return Integer.valueOf(num.toString());
    }

    /**
     * 别人思路
     */
    public String decodeString(String s) {
        Stack<Integer> nums = new Stack<>();
        Stack<String>  strs = new Stack<>();
        StringBuffer   sb   = new StringBuffer();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int num = 0;
                while (Character.isDigit(s.charAt(i))) {
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }
                nums.push(num);
                i--;
            } else if (c == '[') {
                strs.push(sb.toString());
                sb = new StringBuffer();
            } else if (c == ']') {
                int n = nums.pop();
                StringBuffer mid = new StringBuffer(strs.pop());
                for (int j = 0; j < n; j++) {
                    mid.append(sb);
                }
                sb = mid;
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.decodeString("10[a]"));
    }
}