package Google_Topic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stameying on 2/8/16.
 */
public class p50_good_numbers {

    public static List<Integer> goodNumbers(int n){
        List<Integer> res = new ArrayList<>();
        List<Integer> cubes = new ArrayList<>();
        for (int i = 1; Math.pow(i,3) < n; i++) cubes.add((int)Math.pow(i,3)); // generates all cubes smaller than n
        System.out.println(cubes);
        for (int candidateNum = 1; candidateNum <= n; candidateNum++){ // iterate from 1 to n to valid if it is a good number
        	int cnt = 0, left = 0, right = cubes.size()-1; 
        	while (left < right && cnt < 2){ // binary search 
        		if (cubes.get(left)+cubes.get(right) == candidateNum){
        			cnt++;
        			left++;
        			right--;
        		}else if (cubes.get(left)+cubes.get(right) < candidateNum) left++;
        		else right--;
        	}
        	if (cnt >= 2) res.add(candidateNum); // insert candidate number into result list if there are two pairs of cubes
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(goodNumbers(2000));
    }
    
}
