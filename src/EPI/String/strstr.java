package EPI.String;

/**
 * Created by stameying on 1/30/16.
 */
public class strstr {
    private static int kBase = 26, kMod= 997;
    /**
     * t being the search string, the long one
     * s being the pattern, the short one
     * */
    public static int rabinKarp(String t, String s){
        if (s.length() > t.length()) return -1;
        int tHash = 0, sHash = 0;
        int powerS = 1;
        for (int i = 0; i < s.length(); i++){
            powerS = i>0?powerS*kBase%kMod:1;
            tHash = (tHash*kBase + t.charAt(i)) % kMod;
            sHash = (sHash*kBase + s.charAt(i)) % kMod;
        }
        System.out.println("thash = " + tHash);
        System.out.println("shash = " + sHash);
        for (int i = s.length(); i < t.length(); i++){
            if (tHash == sHash && t.substring(i-s.length(),i).equals(s)) return i-s.length();
            tHash -= (t.charAt(i-s.length())*powerS) %kMod;
            if (tHash < 0) tHash += kMod;
            tHash = (tHash*kBase+t.charAt(i))%kMod;
            System.out.println("thash = " + tHash);
        }
        if (tHash == sHash && t.substring(t.length()-s.length()).equals(s)) return t.length()-s.length();
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(rabinKarp("GACGCCA","CGC"));
    }
}
