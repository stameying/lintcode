package Google_Topic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by stameying on 2/7/16.
 */
public class p11_nonuniform_random {


    public static int nonuniformRandomNumberGenerator(List<Integer> values, List<Double> probability){
        List<Double> preSum = new ArrayList<>();
        preSum.add(0.0);
        for (Double prob: probability){
        	preSum.add(preSum.get(preSum.size()-1)+prob);
        }

        Random ran = new Random();
        double randomNum = ran.nextDouble();
        int pos = Collections.binarySearch(preSum,randomNum);
        if (pos < 0){
        	int intervalIdx = (Math.abs(pos)-1)-1;
        	return values.get(intervalIdx);
        }else{
        	return values.get(pos);
        }
    }

    public static void main(String[] args){
    	
    }
}
