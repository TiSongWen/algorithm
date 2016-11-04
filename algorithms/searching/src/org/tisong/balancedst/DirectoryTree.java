package org.tisong.balancedst;

/*/*///*/*/ Powered by radedit!            /*/*/*/*/*/ ;
/*/*//*/*/  import org.tisong.stdlib.StdIn;

import java . util .           /*/*/*/*/*/ ;
/*/*//*/*/  import java . lang . reflect . /*/*/*/*/*/ ;
public class DirectoryTree {
    boolean ddd = false ;
    String[] s2sa(String s) {
        StringTokenizer t=new StringTokenizer(s.trim(), "/");
        String[]r=new String[t.countTokens()];
        int i=0;
        while(t.hasMoreTokens())try{
            r[i++]=t.nextToken();
        }catch(Exception e){};
        return r;
    }

    public String[] display(String[] files) {
        int i, j, k ;
        String[] res = new String[200] ;
        Arrays.sort(files) ;
        int at = 0 ;
        res[0] = "ROOT" ;
        String[] prev = new String[0] ;
        int out = 1 ;
        for (i=0; i<files.length; i++) {
            String s = files[i] ;
            String[] f = s2sa(s) ;
            for (j=0; j<prev.length && j < f.length && prev[j].equals(f[j]); j++) {
            }
            for (k=out-1; k>0; k--) {
                if (res[k].charAt(2*j) == ' ') {
                    res[k] = res[k].substring(0, 2*j) + "|" +
                            res[k].substring(2*j+1) ;
                } else {
                    break ;
                }
            }
            for (k=j; k<f.length; k++) {
                String r = "" ;
                for (int kk=0; kk<k; kk++) {
                    r += "  " ;
                }
                r += "+-" ;
                r += f[k] ;
                res[out++] = r ;
            }
            prev = f ;
        }
        String[] rr = new String[out] ;
        for (i=0; i<out; i++) {
            rr[i] = res[i] ;
        }
        return rr ;
    }

    static void pp(Object o) { System.out.println(o) ; }


    public static void main(String[] args) {
        List<String> files = new LinkedList<>();

        DirectoryTree d = new DirectoryTree();

        String s = "/a/a/c";
        files.add(s);
        files.add("/a/a/d");
        files.add("/a/b");
        files.add("/a/d");
        files.add("/b");
        String[] file = (String[]) (files.toArray(new String[files.size()]));

        String[] r = d.display(file);

        for (int i = 0; i < r.length; i++) {
            System.out.println(r[i]);
        }

    }
}