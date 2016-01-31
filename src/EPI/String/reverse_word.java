package EPI.String;

/**
 * Created by stameying on 1/29/16.
 */
public class reverse_word {
    public static String reverse_word(String s){
        String[] strs = s.split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < strs.length; i++){
            builder.append(new StringBuilder(strs[i]).reverse().toString()).append(i==strs.length-1?"":" ");
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverse_word("hello there my name is xiaoran"));
    }
}
