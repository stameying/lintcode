package snapchat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by stameying on 1/11/16.
 */
public class sendlist {
    HashMap<Character,Boolean> map;

    /**
     * Constructor
     * */
    public  sendlist(){
        map = new HashMap<Character,Boolean>();
    }

    /**
     * Toggle a character
     *
     * @param ch a character to be toggled
     * */
    public void toggle(Character ch){
        if (map.containsKey(ch)){
            map.put(ch,!map.get(ch));
        }else{
            map.put(ch,true);
        }
    }

    /***
     * Get the list of selected items
     */
    public ArrayList<Character> getSelectedList(){
        ArrayList<Character> list = new ArrayList<Character>();
        for (Map.Entry<Character,Boolean> entry: map.entrySet()){
            if (entry.getValue()){
                list.add(entry.getKey());
            }
        }
        return list;
    }

    public static void main(String[] args) {
        sendlist test = new sendlist();
        test.toggle('a');
        test.toggle('b');
        test.toggle('a');
        test.toggle('c');
        ArrayList<Character> list = test.getSelectedList();
        for (int i = 0; i < list.size(); i++){
            System.out.print(list.get(i));
            if (i != list.size()-1) System.out.print(",");
        }
    }
}
