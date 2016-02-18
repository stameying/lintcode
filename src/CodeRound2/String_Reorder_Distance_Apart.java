package src.CodeRound2;

import java.util.*;

/**
 * Created by stameying on 2/18/16.
 */
public class String_Reorder_Distance_Apart {

    /**
     * Given a string of lowercase characters, reorder them such that the same characters are at least distance d from each other.

         Input: { a, b, b }, distance = 2
         Output: { b, a, b }
     *
     * */

    /**
     * Solution:
     * 1. 统计词频并插入max heap
     * 2. 将词频高的字母先重新放入合法的位置
     * */

    /**
     * 时间复杂度 O(n) + O(mLog(256))
     * 空间复杂度 O(m)
     * */

    public static void rerange(char[] str, int d){
        if (str == null || str.length <= 2) return; // no need for reordering
        /*
        * 统计词频
        * */
        HashMap<Character,Integer> countMap = new HashMap<>();
        for (int i = 0; i < str.length; i++){
            if (countMap.containsKey(str[i])){
                countMap.put(str[i],countMap.get(str[i])+1);
            }else countMap.put(str[i],1);
        }

        /*
        * 遍历表,将对应的插入最大堆
        * */
        PriorityQueue<charWithCount> max_heap = new PriorityQueue<>(new Comparator<charWithCount>(){
            @Override
            public int compare(charWithCount o1, charWithCount o2){
                return Integer.compare(o2.count,o1.count);
            }
        });
        for (Map.Entry<Character,Integer> entry: countMap.entrySet()){
            char key = entry.getKey();
            int val = entry.getValue();
            max_heap.offer(new charWithCount(key,val));
        }

        /*
        * 重新排列
        * */
        Arrays.fill(str,0,str.length,'\0'); //清空原数组

        for (int i = 0; i < str.length; i++){
            if (max_heap.isEmpty()) return;
            charWithCount topItem = max_heap.poll();
            // 找到第一个插入位置
            int p = i;
            while (p < str.length && str[p] != '\0') p++;
            for (int k = 0; k < topItem.count; k++){
                try{
                    str[p+d*k] = topItem.ch;
                }catch (ArrayIndexOutOfBoundsException e){
                    System.out.println("无法重排");
                }
            }
        }

        return;
    }

    public static void main(String[] args) {
        String str = "abbb";
        char[] arr = str.toCharArray();
        rerange(arr,2);
        System.out.println(Arrays.toString(arr));
    }


    private static class charWithCount{
        char ch;
        int count;

        public charWithCount(char ch) {
            this.ch = ch;
            this.count = 1;
        }

        public charWithCount(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }

}
