package snapchat;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by stameying on 1/11/16.
 */
public class compress_word {

    HashMap<String,trienode> map;
    public compress_word(){
        map = new HashMap<String,trienode>();
    }

    public void compress(String[] strs){
        for (String str: strs){
            insertIntoMap(str);
        }
//        for (Map.Entry<String,trienode> entry: map.entrySet()){
//            System.out.println("key="+entry.getKey() + " value="+entry.getValue().count);
//            if (entry.getKey().equals("i8t")){
//                trienode cur = entry.getValue();
//                System.out.println(cur.next.get('i').count);
//                cur = cur.next.get('i');
//                System.out.println(cur.next.get('n').count);
//                cur = cur.next.get('n');
//                System.out.println(cur.next.get('t').count);
//                cur = cur.next.get('t');
//                System.out.println(cur.next.get('e').count);
//                cur = cur.next.get('e');
//            }
//        }
        for (String str: strs){
            String compressedWord = compressWord(str);
            System.out.println(str+"->"+compressedWord);
        }
    }

    public void insertIntoMap(String word){
        // if a word has length 3 or less, no need for compression
        if (word.length() <= 3) return;
        String maxCompressWord = maxCompressWord(word);
        if (!map.containsKey(maxCompressWord)){
            trienode root = new trienode();
            map.put(maxCompressWord,root);
            trienode cur = root;
            for (int i = 0; i < word.length(); i++){
                trienode temp = new trienode();
                temp.ch = word.charAt(i);
                cur.next.put(word.charAt(i),temp);
                cur = temp;
            }
        }else{
            trienode cur = map.get(maxCompressWord);
            cur.count++;
            for (int i = 0; i < word.length(); i++){
                if (cur.next.containsKey(word.charAt(i))){
                    trienode nextNode = cur.next.get(word.charAt(i));
                    nextNode.count++;
                    cur = nextNode;
                }else{
                    trienode temp = new trienode();
                    temp.ch = word.charAt(i);
                    cur.next.put(word.charAt(i),temp);
                    cur = temp;
                }
            }
        }
    }

    public String maxCompressWord(String str){
        StringBuilder builder = new StringBuilder();
        builder.append(str.charAt(0));
        builder.append(str.length());
        builder.append(str.charAt(str.length()-1));
        return builder.toString();
    }

    public String compressWord(String str){
        // if a word has length 3 or less, no need for compression
        if (str.length() <= 3) return str;

        String maxCompressWord = maxCompressWord(str);
        if (map.get(maxCompressWord).count == 1) return maxCompressWord;
        else{
            int prefixLen = 0;
            trienode cur = map.get(maxCompressWord);
            while (cur.count != 1){
                cur = cur.next.get(str.charAt(prefixLen++));
            }
            StringBuilder builder = new StringBuilder();
            builder.append(str.substring(0,prefixLen));
            builder.append(str.length());
            builder.append(str.charAt(str.length()-1));
            String compressedWord = builder.toString();
            if (compressedWord.length() < str.length()) return compressedWord;
            else return str;
        }
    }

    public static void main(String[] args) {
        compress_word compressor = new compress_word();
        String[] words = {"like", "god" ,"internal" , "me" ,"internet" , "interval" , "intension", "face" ,"intrusion", "intranet" };
        compressor.compress(words);
    }
}

class trienode{
    char ch;
    int count;
    HashMap<Character,trienode> next;
    public trienode(){
        this.next = new HashMap<Character,trienode>();
        this.count = 1;
    }
}
