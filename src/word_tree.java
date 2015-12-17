import java.util.HashMap;

/**
 * Created by stameying on 12/16/15.
 */
public class word_tree {
    boolean isLeaf;
    char chracter;
    HashMap<Character,word_tree> next;

    public word_tree(char chracter) {
        this.chracter = chracter;
        next = new HashMap<Character,word_tree>();
    }

    public void setLeaf(){
        this.isLeaf = true;
    }
}
