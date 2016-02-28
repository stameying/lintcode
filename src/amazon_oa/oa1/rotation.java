package src.amazon_oa.oa1;

/**
 * Created by stameying on 2/25/16.
 */
public class rotation {

    public boolean isRotation(String s1,String s2) {
        return (s1.length() == s2.length()) && ((s1+s1).indexOf(s2) != -1);
    }


}
