package src.amazon_oa.video;


/**
 * 要注意要import
 * */
import java.util.LinkedList;
import java.util.List;

/**
 * Created by stameying on 3/12/16.
 */
public class lruCountMiss {

    public static int lruCountMiss(int max_cache_size, int[] pages){
        // INSERT YOUR CODE HERE
        if (pages == null || pages.length == 0 || max_cache_size <= 0) return 0;

        /**
         * 用Linkedlist的复杂度
         *
         * 对于每一个entry
         * worst time是 O(k)
         * 总体来说是 O(kn)
         *
         *
         * */
        List<Integer> cache = new LinkedList<>();
        int missCount = 0;
        for (int i = 0; i < pages.length; i++){
            int curNum = pages[i];
            if (!cache.contains(curNum)){
                missCount++;
                if (cache.size() >= max_cache_size){
                    /**
                     * 删掉第一个元素
                     *
                     * */
                    cache.remove(0);
                }
                cache.add(curNum);
            }else{
                cache.remove(new Integer(curNum));
                cache.add(curNum);
            }
        }

        return missCount;
    }


    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,4,1};
        System.out.println(lruCountMiss(4,array));
    }
}
