/**
 * Created by tisong on 11/18/16.
 */
public class leet28 {

    public int strStr(String haystack, String needle) {
        return -1;
    }

    private int[] getNext(String needle) {
        int[] next = new int[needle.length() + 1];
        next[0] = -1;
        next[1] = 0;
        int i = 1;
        int j = 0;
        for (; i < needle.length(); ) {
            if (j == -1 || needle.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
                next[i] = j;
            } else {
                j = next[j];
            }

        }

        return null;
    }
}