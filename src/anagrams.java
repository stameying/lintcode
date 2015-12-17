import java.util.*;

/**
 * Created by stameying on 12/16/15.
 */
public class anagrams {

    /**
     * @param strs: A list of strings
     * @return: A list of strings
     */
    public static List<String> anagrams(String[] strs) {
        // write your code here
        List<String> res = new ArrayList<String>();
        if (strs.length == 0) return res;
        if (strs.length == 1){
            res.add(strs[0]);
            return res;
        }
        HashMap<String,List<String>> map = new HashMap<String,List<String>>();
        for(String str: strs){
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String code = Arrays.toString(charArray);
            System.out.println("code="+code);
            if (map.containsKey(code)){ // we find an anagram
                System.out.println("find a solution");
                List<String> list = map.get(code);
                list.add(str);
            }else{
                List<String> list = new ArrayList<String>();
                list.add(str);
                map.put(code,list);
            }
        }

//        Iterator iter = map.values().iterator();
//        while (iter.hasNext()){
//            ArrayList<String> item = (ArrayList<String>)iter.next();
//            if (item.size() > 1){
//                for (int i = 0; i < item.size(); i++){
//                    res.add(item.get(i));
//                    System.out.println("word="+item.get(i));
//                }
//            }
//        }
        for (Map.Entry<String,List<String>> entry: map.entrySet()){
            ArrayList<String> list = (ArrayList<String>)entry.getValue();
            if (list.size() > 1){
                for (String str: list){
                    res.add(str);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] strs = {"","","hi","ih"};
        anagrams(strs);
    }


}
