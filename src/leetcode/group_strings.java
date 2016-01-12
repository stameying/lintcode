package leetcode;

import java.util.*;

/**
 * Created by stameying on 1/11/16.
 */
public class group_strings {
    /**
     * @param strings a list of strings to be grouped
     * */
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList<List<String>>();
        if (strings.length == 0) return res;
        Arrays.sort(strings);
        HashMap<String,List<String>> map = new HashMap<String,List<String>>();
        for (String str: strings){
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < str.length(); j++){
                builder.append(((str.charAt(j)-str.charAt(0))+26)%26);
                builder.append(" ");
            }
            String code = builder.toString();
            if (map.containsKey(code)){
                map.get(code).add(str);
            }else{
                List<String> list = new ArrayList<String>();
                list.add(str);
                map.put(code,list);
            }
        }

        for (Map.Entry<String,List<String>> entry: map.entrySet()){
            res.add(entry.getValue());
        }
        return res;
    }

}

