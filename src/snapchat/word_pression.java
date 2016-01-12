package snapchat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by stameying on 1/11/16.
 */
public class word_pression {
//    TrieNode inorderRoot, reverseRoot;
//    public word_pression(){
//        inorderRoot = new TrieNode();
//        reverseRoot = new TrieNode();
//    }
//
//    public List<String> abbreviation(String[] arr){
//        for (String str: arr){
//            insertToInorderTrie(str);
//            insertToRevserTire(str);
//        }
//        List<String> res = new ArrayList<>();
//        for (String str: arr){
//            String word = compressWord(str);
//            System.out.println(str + "->" + word);
//            res.add(word);
//        }
//
//        return res;
//    }
//
//    public void insertToInorderTrie(String str){
//        TrieNode cur = inorderRoot;
//        for (int i = 0; i < str.length(); i++){
//            char ch = str.charAt(i);
//            if (cur.next.containsKey(ch)){
//                cur.next.get(ch).count++;
//                cur = cur.next.get(ch);
//            }else{
//                TrieNode temp = new TrieNode();
//                temp.ch = ch;
//                temp.count = 1;
//                cur.next.put(ch,temp);
//                cur = temp;
//            }
//        }
//    }
//
//    public void insertToRevserTire(String str){
//        TrieNode cur = reverseRoot;
//        for (int i = str.length()-1; i>= 0; i--){
//            char ch = str.charAt(i);
//            if (cur.next.containsKey(ch)){
//                cur.next.get(ch).count++;
//                cur = cur.next.get(ch);
//            }else{
//                TrieNode temp = new TrieNode();
//                temp.ch =ch;
//                temp.count = 1;
//                cur.next.put(ch,temp);
//                cur = temp;
//            }
//        }
//    }
//
//    public String compressWord(String str){
//        int right = str.length()-1;
//        TrieNode cur = reverseRoot;
//        char ch = str.charAt(right);
//        while (cur != null){
////            System.out.println("right="+right+ "cur ch="+ch);
//            if (cur.next == null){
//                // reach head of the string, no way to compress
//                return str;
//            }else{
//                if (cur.next.get(ch).count == 1){
//                    // next character is unique, find longest suffix
//                    break;
//                }else{
//                    cur = cur.next.get(ch);
//                    ch = str.charAt(--right);
//                }
//            }
//        }
//        System.out.println("right="+right);
//
//        int left = 0;
//        cur = inorderRoot;
//        ch = str.charAt(left);
//        while (cur != null){
//            if (cur.next == null){
//                // reach end of the string, no way to compress
//                return str;
//            }else{
//                if (cur.next.get(ch).count == 1){
//                    break;
//                }else{
//                    cur = cur.next.get(ch);
//                    ch = str.charAt(++left);
//                }
//            }
//        }
//        System.out.println("left="+left);
//
//        if (left == 0 || right == str.length()-1){
//            // compress whole word
//            if (str.length() <= 3) return str;
//            else{
//                StringBuilder builder = new StringBuilder();
//                builder.append(str.charAt(0));
//                builder.append(str.length());
//                builder.append(str.charAt(str.length()-1));
//                return builder.toString();
//            }
//        }
//
//        StringBuilder builder = new StringBuilder();
//        builder.append(str.substring(0,left+1));
//        builder.append(str.length());
//        builder.append(str.substring(right+1,str.length()));
//        String resWord = builder.toString();
//        if (resWord.length() >= str.length()) return str;
//        else return resWord;
//
//    }





    public static void main(String[] args) {
        word_pression test = new word_pression();
        String[] words = {"like", "god" ,"internal" , "me" ,"internet" , "interval" , "intension", "face" ,"intrusion" };
//        test.abbreviation(words);
    }
}

class TrieNode{
    Character ch;
    int count;
    HashMap<Character,TrieNode> next;
    public TrieNode(){
        this.next = new HashMap<Character,TrieNode>();
        this.count = 0;
    }
}
