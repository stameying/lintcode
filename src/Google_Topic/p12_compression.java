package Google_Topic;

/**
 * Created by stameying on 2/7/16.
 */
public class p12_compression {


    /**
     * aaabbbbcc-> aaa4xbcc
     * */

    public static String compressStr(String str){
        if (str == null || str.length() <= 3) return str;
        StringBuilder builder = new StringBuilder();
        int pre = -1;
        for (int i = 0; i < str.length(); i++){
            if (Character.isDigit(str.charAt(i))){
                // We encounter a number, 
                // need to append a '/' as seperator
                addPrevious(compressString(str.substring(pre,i)),builder);
                int lookAhead = i+1;
                while (lookAhead < str.length() && Character.isDigit(str.charAt(lookAhead))) lookAhead++;
                builder.append(Integer.parseInt(str.substring(i,lookAhead))).append('/');
                pre = lookAhead;
                i = lookAhead-1;
            }else{
                // We encounter a character:
                // if it is same to the previous one, continue sacn
                // otherwise we need to compress the previous part
                if (pre == -1 || str.charAt(pre) == str.charAt(i)){
                    if (pre == -1) pre = i;
                    continue;
                }else{
                    int preLen = i-pre;
                    addPrevious(compressString(str.substring(pre,i)),builder);
                    pre = i;
                }
            }
        }
//        System.out.println("pre="+pre);
        addPrevious(compressString(str.substring(pre,str.length())),builder);
        return builder.toString();
    }

    public static void addPrevious(String str, StringBuilder builder){
        builder.append(str);
    }

    public static String compressString(String str){
        if (str.length() <= 3) return str;
        else return String.valueOf(str.length())+"x"+str.charAt(0);
    }

    public static void main(String[] args) {
        System.out.println(compressStr("aac3bbbb"));
    }


}
