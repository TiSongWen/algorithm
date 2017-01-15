/**
 * LeetCoder 459: Repeated Substring Pattern
 * Description:
 *     Give a non-empty string check if it be constructed by a substring of it
 *     and appending multiple copies of the substring together
 * Examples 1:
 *     Input : "abab"
 *     Output: true
 * Examples 2:
 *     Input : "abc"
 *     Output: false
 */
public class leet459 {


    public boolean repeatedSubstringPattern(String str) {
        if (str == null || str.length() < 1) {
            return false;
        }
        for (int i = 0; i < str.length() / 2; i++) {
            String s = str.substring(0, i+1);
            if (str.length() / s.length() * s.length() != str.length()) {
                continue;
            }
            int j = i + 1;
            for (; j + s.length() <= str.length(); j += s.length()) {
                String sub = str.substring(j, j + s.length());
                if (!s.equals(sub)) {
                    break;
                }
            }
            if (j >= str.length()) {
                return true;
            }
        }
        return false;
    }

    /**
     * KMP algorithm just only get next arrays
     */
    public static boolean repeatedSubstringPattern1(String str) {
        int len = str.length();
        int[] next = new int[len];
        for(int i=1;i<len;i++){
            char cur = str.charAt(i);
            int j = next[i-1];
            while(j!=0 && cur!=str.charAt(j)){
                j = next[j-1];
            }
            if(cur==str.charAt(j)){
                next[i] = j + 1;
            }
        }

        System.out.println(next[len-1]);
        return next[len-1]!=0 && len % (len - next[len-1]) == 0;
    }

    public static void main(String[] args) {
        System.out.println(repeatedSubstringPattern1("ababb"));
    }

    public void getNext(String pattern) {
        Integer[] next = new Integer[10];

        next[1] = 0;
        int i = 1, j = 0;

        if (j == 0 || next[i] == next[j]) {
            i++;
            j++;
            next[i] = j;
        }
        else if (next[i] != next[j]) {
            j = next[j];
        }
    }
}
