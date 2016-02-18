package src.first_round;

import java.util.ArrayList;

/**
 * Created by stameying on 12/29/15.
 */
public class minimum_adjust_cost {
    /**
     * @param A: An integer array.
     * @param target: An integer.
     */
    public int MinAdjustmentCost(ArrayList<Integer> A, int target) {
        // write your code here
        if (A.size() == 0) return 0;
        return dfs(A, new ArrayList<Integer>(A), target, 0);
    }

    public int dfs(ArrayList<Integer> A, ArrayList<Integer> cur, int target, int pos){
        if (pos >= A.size()) return 0;
        int dif = 0, min = 10000;
        for (int i = 0; i <= 100; i++){
            if (pos != 0 && Math.abs(i-cur.get(pos-1)) >target) continue;
            cur.set(pos,i);
            dif = Math.abs(i-A.get(pos));
            dif += dfs(A,cur,target,pos+1);
            min = Math.min(min,dif);
            cur.set(pos,A.get(pos));
        }
        return min;
    }

    public int MinAdjustmentCost2(ArrayList<Integer> A, int target) {
        // write your code here
        if (A.size() == 0) return 0;
        int[][] D = new int[A.size()][101];
        int size= A.size();
        for (int i = 0; i < size; i++){
            for (int j = 1; j <= 100; j++){
                D[i][j] = Integer.MAX_VALUE;
                if (i == 0){
                    D[i][j] = Math.abs(j-A.get(i));
                }else{
                    for (int k = 1; k <= 100; k++){
                        if (Math.abs(j-k) > target) continue;
                        int dif = Math.abs(j-A.get(i)) + D[i-1][k];
                        D[i][j] = Math.min(D[i][j],dif);
                    }
                }
            }
        }
        for (int i = 0; i < A.size(); i++){
            for (int j = 0; j <= 100; j++){
                System.out.print(D[i][j]);
                if (j != 100){
                    System.out.print(",");
                }
            }
            System.out.println();
        }
        int ret = Integer.MAX_VALUE;
        for (int i = 1; i <= 100; i++){
            ret = Math.min(ret,D[size-1][i]);
        }
        return ret;
    }


    public static void main(String[] args) {
        minimum_adjust_cost test = new minimum_adjust_cost();
        int[] arr = {1,4,2,3};
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(4);
        list.add(2);
        list.add(3);
        System.out.println(test.MinAdjustmentCost2(list,1));
    }
}
