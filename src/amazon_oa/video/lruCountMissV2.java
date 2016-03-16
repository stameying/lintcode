package src.amazon_oa.video;

import java.util.*;

/**
 * Created by stameying on 3/13/16.
 */
public class lruCountMissV2 {

    public static int LRUCasheMiss(int MAX_CACHE_SIZE, int[] array){
        if (array == null || array.length == 0 || MAX_CACHE_SIZE <= 0) return 0;
        LinkedHashMap cache = new LinkedHashMap(MAX_CACHE_SIZE, 0.75f, true){
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest){
                return size() > MAX_CACHE_SIZE;
            }
        };
        int cacheMiss = 0;
        for (int i = 0; i < array.length; i++){
            Integer curNum = array[i];
            if (cache.containsKey(curNum)){
                cache.remove(curNum);
                cache.put(curNum,array[i]);
            }else{
                cacheMiss++;
                cache.put(curNum,array[i]);
            }
            System.out.println(cache);
        }

        return cacheMiss;
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,4,1};
        System.out.println(LRUCasheMiss(4,array));
    }
}
