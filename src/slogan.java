import java.util.HashMap;

/**
 * Created by stameying on 1/12/16.
 */
public class slogan {

    public String slogan(String str){
        if (str.length() == 0) return str;
        else if (str.length() == 0) return "1"+str;
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        for (int i = 0; i < str.length(); i++){
            char ch = Character.toLowerCase(str.charAt(i));
            if (map.containsKey(ch)){
                map.put(ch,map.get(ch)+1);
            }else{
                map.put(ch,1);
            }
        }
        char character = 'a';
        StringBuilder builder = new StringBuilder();
        for (character = 'a'; character <= 'z'; character++){
            if (map.containsKey(character)){
                builder.append(map.get(character));
                builder.append(character);
            }
        }
        return builder.toString();
    }

    public String slogan2(String str){
        if (str.length() == 0) return str;
        else if (str.length() == 1) return "1"+str;
        int count = 1;
        char see = str.charAt(0);
        int pos = 1;
        StringBuilder builder = new StringBuilder();
        while (pos < str.length()){
            char ch = str.charAt(pos);
            if (ch == see){
                count++;
            }else{
                builder.append(count);
                builder.append(see);
                see = ch;
                count = 1;
            }
            pos++;
        }
        builder.append(count);
        builder.append(see);
        return builder.toString();
    }

    public static void main(String[] args) {
        slogan test = new slogan();
        System.out.println(test.slogan("abcca"));
        System.out.println(test.slogan2("abcca"));
    }
}
