package EPI.String;

/**
 * Created by stameying on 1/30/16.
 */
public class snakeString {

    public static String snakeString(String s){
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i < s.length(); i+=4){
            builder.append(s.charAt(i));
        }
        for (int i = 0; i < s.length(); i+=2){
            builder.append(s.charAt(i));
        }
        for (int i = 3; i < s.length(); i+=4){
            builder.append(s.charAt(i));
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(snakeString("hello world!"));
    }
}
