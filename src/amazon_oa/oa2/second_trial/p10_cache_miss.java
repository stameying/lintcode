package src.amazon_oa.oa2.second_trial;
import java.util.LinkedList;
import java.util.List;
/**
 * Created by stameying on 2/27/16.
 */
public class p10_cache_miss {
    public static int cacheMiss(int[] array, int size){
        if (array == null || array.length == 0 || size <= 0) return 0;
        int missCount = 0;
        List<Integer> cache = new LinkedList<>();
        for (int i = 0; i < array.length; i++){
            int num = array[i];
            if (!cache.contains(num)){
                missCount++;
                if (cache.size() == size){
                    cache.remove(0);
                }
            }else{
                cache.remove(new Integer(num));

            }
            cache.add(num);
        }
        return missCount;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5,4,1};

        System.out.println(cacheMiss(array, 4));
    }
}
