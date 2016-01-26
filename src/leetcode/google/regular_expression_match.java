package leetcode.google;

/**
 * Created by stameying on 1/25/16.
 */
public class regular_expression_match {

    public static boolean isMatch(String s, String p) {
        if (s.length() == 0 && p.length() == 0) return true;
        if (p.length() == 0) return false;
        boolean[][] res = new boolean[s.length() + 1][p.length() + 1];
        res[0][0] = true;
        for (int j = 0; j < p.length(); j++) {
            System.out.println("current j = " + j + " ; charAt j = " + p.charAt(j));
            if (p.charAt(j) == '*') {
                if (j > 0 && res[0][j - 1]) res[0][j + 1] = true;
                if (j == 0) continue;
                if (p.charAt(j - 1) != '.') {
                    for (int i = 0; i < s.length(); i++) {
                        if (res[i + 1][j] == true) {
                            // abc <==> abc* => abc
                            res[i + 1][j + 1] = true;
                        } else if (j > 0 && res[i + 1][j - 1]) {
                            // ab <==> abc* => ab
                            res[i + 1][j + 1] = true;
                        } else if (i > 0 && j > 0 && res[i][j + 1] && s.charAt(i) == s.charAt(i - 1) && s.charAt(i - 1) == p.charAt(j - 1)) {
                            // abcc <==> abc* => abcc
                            res[i + 1][j + 1] = true;
                        }
                    }
                } else {
                    int i = 0;
                    displayMatrix(res);
                    System.out.println("before i = " + i + ", j = " + j);
                    while (j > 0 && i < s.length() && !res[i + 1][j - 1] && !res[i + 1][j]) i++;
                    System.out.println("i = " + i + ", j = " + j);
                    for (; i < s.length(); i++) {
                        System.out.println(" res[" + (i+1) + "][" + (j+1) + "] = true");
                        res[i + 1][j + 1] = true;
                    }
                    displayMatrix(res);
                }
            } else {
                // p.charAt(j) != '*'
                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
                        res[i + 1][j + 1] = res[i][j];
                    }
                }
            }
        }
        displayMatrix(res);
        return res[s.length()][p.length()];
    }

    public static void displayMatrix(boolean[][] res){
        for (int i = 0; i < res.length; i++){
            if (i == 0) for (int j = 0; j < res[0].length; j++) System.out.print((j==0?"  ":"")+j + " " + (j==res[0].length-1?"\n":""));
            for (int j = 0; j < res[0].length; j++){
                System.out.print((j==0?i+" ":"")+(res[i][j]? "T":"F")+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        String s = "ab";
        String p = ".*";
        isMatch(s,p);
    }
}
