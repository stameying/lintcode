package src.amazon_oa.oa2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by stameying on 2/27/16.
 */
public class cache_miss {


    public static int cache_miss(int[] array, int size){
        if (array == null || array.length == 0)	return 0;
        List<Integer> cache = new LinkedList<>();
        int hitMissCount = 0;
        for (int i = 0; i < array.length; i++){

            int curNum = array[i];
            System.out.println("curNum="+curNum+ " cahce="+cache);
            if (!cache.contains(curNum)){
                if (cache.size() == size){
                    // remove from head
                    cache.remove(0);
                }
                hitMissCount++;
            }else{
                System.out.println("hit");
                cache.remove(new Integer(curNum));
            }
            cache.add(curNum);
        }
        return hitMissCount;
    }


    public static class CacheMiss {
        public int Solution(int[] array, int size) {
            if (array == null)	return 0;
            List<Integer> cache = new LinkedList<Integer>();
            int count = 0;
            for (int i = 0; i < array.length; i++) {
                if (cache.contains(array[i])) {
                    cache.remove(new Integer(array[i]));
                }
                else {
                    count++;
                    if (size == cache.size())
                        cache.remove(0);
                }
                cache.add(array[i]);
            }
            return count;
        }
    }

    public static void main(String[] args) {
//        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(2);
//        list.remove(0);
//        System.out.println(list);

        int[] array = new int[]{1, 2, 3, 4, 5,4,1};
        CacheMiss solution1 = new CacheMiss();
        int rvalue = solution1.Solution( array, 4);
        System.out.println(rvalue);

        System.out.println(cache_miss(array, 4));
    }
}
