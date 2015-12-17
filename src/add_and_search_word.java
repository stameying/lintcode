import java.util.Map;

/**
 * Created by stameying on 12/16/15.
 */
public class add_and_search_word {
    word_tree root;
    public add_and_search_word() {
        root = new word_tree(' ');
    }

    /**
    * first clue: word tree
    * */

    // Adds a word into the data structure.
    public void addWord(String word) {
        // Write your code here
        word_tree cur = root;
        int index = 0;
        while (index < word.length()){
            char ch = word.charAt(index);
            if (cur.next.containsKey(ch)){
                word_tree next = cur.next.get(ch);
                cur = next;
            }else{
                word_tree temp = new word_tree(ch);
                cur.next.put(ch,temp);
                cur = temp;
            }
            index++;
        }
        cur.isLeaf = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        // Write your code here
        return search_root(word,root);
    }

    public boolean search_root(String word, word_tree head){
        word_tree cur = head;
        for (int i = 0; i < word.length(); i++){
            if (word.charAt(i) == '.' ){
                word = word.substring(i+1);
                for (Map.Entry<Character,word_tree> entry: cur.next.entrySet()){
                    cur = entry.getValue();
                    if (search_root(word, cur)) return true;
                }
                return false;
            }else{
                if (!cur.next.containsKey(word.charAt(i))) return false;
                else{
                    cur = cur.next.get(word.charAt(i));
                }
            }
        }
        if (cur.isLeaf) return true;
        else return false;
    }

    public static void main(String[] args) {
        add_and_search_word test = new add_and_search_word();
        test.addWord("helloxiaoran");
        System.out.println(test.search("hello"));
        System.out.println(test.search("helloxiaoran"));
        System.out.println(test.search("hello....ran"));
    }

}
