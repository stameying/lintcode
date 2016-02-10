package Google_Topic;

import java.util.*;

/**
 * Created by stameying on 2/9/16.
 */
public class p62_hashTableWithRandom<K,V>{

    Map<K,V> KeyValueMap;
    Map<K,Integer> KeyIndexMap;
    List<K> keyArr;
    Random ran;

    /**
     * A hashtable that with
     * O(1) insert
     * O(1) delete
     * O(1) lookup
     * O(1) get a random value from map
     * */
    public p62_hashTableWithRandom(){
        KeyValueMap = new HashMap<>();
        KeyIndexMap = new HashMap<>();
        keyArr = new ArrayList<>();
        ran = new Random();
    }


    public V get(K key){
        if (KeyValueMap.containsKey(key)) return KeyValueMap.get(key);
        else return null;
    }


    public V put(K key, V val){
        if (KeyValueMap.containsKey(key)){
            return KeyValueMap.put(key,val);
        }else{
            KeyValueMap.put(key,val);
            keyArr.add(key);
            KeyIndexMap.put(key,keyArr.size()-1);
            return null;
        }
    }

    public V remove(K key){
        if (KeyValueMap.containsKey(key)){
            Integer idx = KeyIndexMap.get(key);
            KeyIndexMap.remove(key);
            Collections.swap(keyArr, idx, keyArr.size()-1);
            keyArr.remove(keyArr.size()-1);
            return KeyValueMap.remove(key);
        }else{
            return null;
        }
    }

    public V getRandom(){
        int idx = ran.nextInt(keyArr.size());
        K key = keyArr.get(idx);
        return KeyValueMap.get(key);
    }


    public static void main(String[] args) {
        p62_hashTableWithRandom<Integer,Integer> randomMap = new p62_hashTableWithRandom<>();
        randomMap.put(2,3);
        randomMap.put(2,4);
        randomMap.put(3,2);
        randomMap.put(1,5);
        randomMap.put(2,7);
        System.out.println(randomMap.getRandom());
    }

}
