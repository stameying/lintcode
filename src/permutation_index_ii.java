import java.util.*;

/**
 * Created by stameying on 1/2/16.
 */
public class permutation_index_ii {

    long fac(int numerator) {

        long now = 1;
        for (int i = 1; i <= numerator; i++) {
            now *= (long) i;
        }
        return now;
    }

    long generateNum(HashMap<Integer, Integer> hash) {
        long denominator = 1;
        int sum = 0;
        for (int val : hash.values()) {
            System.out.println("hash value=" + val);
            if(val == 0 )
                continue;
            denominator *= fac(val);
            sum += val;
        }
        if(sum==0) {
            return sum;
        }
        System.out.println("sum="+sum+",denominator="+denominator);
        return fac(sum) / denominator;
    }

    public long permutationIndexII_2(int[] A) {
        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();

        for (int i = 0; i < A.length; i++) {
            if (hash.containsKey(A[i]))
                hash.put(A[i], hash.get(A[i]) + 1);
            else {
                hash.put(A[i], 1);
            }
        }
        long ans = 0;
        for (int i = 0; i < A.length; i++) {
            HashMap<Integer, Integer> flag = new HashMap<Integer, Integer>();

            for (int j = i + 1; j < A.length; j++) {
                if (A[j] < A[i] && !flag.containsKey(A[j])) {
                    flag.put(A[j], 1);

                    hash.put(A[j], hash.get(A[j])-1);
                    long temp = generateNum(hash);
                    System.out.println(temp);
                    ans += generateNum(hash);
                    hash.put(A[j], hash.get(A[j])+1);

                }

            }
            hash.put(A[i], hash.get(A[i])-1);
        }

        return ans+1;

    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums.length == 0) return res;
        res.add(new ArrayList<Integer>());
        for (int i = 0; i < nums.length; i++){
            Set<List<Integer>> cur = new HashSet<List<Integer>>();
            for (List<Integer> last: res){
                for (int j = 0; j < last.size()+1; j++){
                    last.add(j,nums[i]);
                    List<Integer> temp = new ArrayList<Integer>(last);
                    cur.add(temp);
                    last.remove(j);
                }
            }
            res = new ArrayList<List<Integer>>();
            for (List<Integer> next: cur){
                res.add(next);
            }
        }

        for (int i = 0; i < res.size(); i++){
            for (int j = 0; j < res.get(i).size(); j++){
                System.out.print(res.get(i).get(j));
                if (j != res.get(i).size()-1) System.out.print(",");
            }
            System.out.println();
        }
        return res;
    }


    /**
     * @param A an integer array
     * @return a long integer
     */
    public long permutationIndexII(int[] A) {
        // Write your code here
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (int i = 0; i < A.length; i++){
            if (map.containsKey(A[i])){
                map.put(A[i],map.get(A[i])+1);
            }else{
                map.put(A[i],1);
            }
        }
        long res = 1;
        for (int j = 0; j < A.length; j++){
            HashMap<Integer,Integer> flag = new HashMap<Integer,Integer>();
            int curNum = A[j];
            int count = 0;
            for (int k = j+1; k < A.length; k++){
                if (A[k] < curNum){
                    count++;
                }
                if (flag.containsKey(A[k])){
                    flag.put(A[k],flag.get(A[k])+1);
                }else{
                    flag.put(A[k],1);
                }
            }
            long factor = getFactor(A.length-j);
            long dupFactor = dupFactor(curNum, flag);
            res += (count * factor)/dupFactor;

            System.out.println("count = " + count);
            System.out.println("factor = " + factor);
            System.out.println("dupFactor = " + dupFactor);
        }
        return res;
    }

    public long dupFactor(int cur, HashMap<Integer,Integer> flag){
        long res = 1;
        for (Map.Entry<Integer,Integer> entry: flag.entrySet()){
            System.out.println("key="+entry.getKey() + ", value="+entry.getValue());
            if (entry.getKey() <= cur){
                res *= getFactor(entry.getValue()+1);
            }
        }
        return res;
    }
    public long getFactor(int num){
        if (num == 0) return 0;
        long res = 1;
        for (int i = num-1; i >= 1; i--){
            res *= i;
        }
        return res;
    }

    public static void main(String[] args) {
        permutation_index_ii test = new permutation_index_ii();
        int[] arr = {1,4,2,2};

        System.out.println(test.permutationIndexII(arr));
        test.permuteUnique(arr);
    }
}
