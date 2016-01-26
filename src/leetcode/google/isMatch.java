package leetcode.google;

/**
 * Created by stameying on 1/24/16.
 */
public class isMatch {

    public boolean isMatch(String s, String p) {
        int sp = 0, pp = 0, star = -1, mark = -1;
        while (sp < s.length()){
            if (pp < p.length() && (p.charAt(pp) == '?' || p.charAt(pp) == s.charAt(sp))){
                sp++;
                pp++;
            }else if (pp < p.length() && p.charAt(pp) == '*'){
                star = pp;
                pp++;
                mark = sp;
            }else if (star != -1){
                sp = mark++;
                pp = star+1;
            }else{
                return false;
            }
        }
        while (pp < p.length() && p.charAt(pp++) != '*') return false;
        return true;
    }

//    public boolean isMatch(String s, String p, int pos1, int pos2){
//        System.out.println("pos1="+pos1+";pos2="+pos2);
//        if (pos1 == s.length() && pos2 == p.length()) return true;
//        if (pos1 < s.length() && pos2 == p.length()) return false;
//        if (pos1 == s.length()){
//            if (p.charAt(pos2) == '*' && pos2 == p.length()-1) return true;
//            else return false;
//        }
//        char ch1 = s.charAt(pos1), ch2 = p.charAt(pos2);
//        if (ch2 == '*'){
//            int k = 1;
//            while (pos1+k < s.length()){
//                if (isMatch(s,p,pos1+k,pos2+1)){
//                    return true;
//                } else k++;
//            }
//            return false;
//        }else if (ch2 == '?'){
//            return isMatch(s,p,pos1+1,pos2+1);
//        }else{
//            if (ch1 == ch2) return isMatch(s,p,pos1+1,pos2+1);
//            else return false;
//        }
//    }

    public static void main(String[] args) {
        isMatch test = new isMatch();
        String str1 = "b";
        String str2 = "?*?";
        System.out.println(str1.length());
//        System.out.println(test.isMatch(str1,str2));
    }
}
