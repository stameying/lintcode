package EPI.array;

import java.util.*;

/**
 * Created by stameying on 1/29/16.
 */
public class nonuniformRandomGenerator {

    public static int generator(List<Integer> values, List<Double> probabilities){
        List<Double> prefixSumOfProbabilities = new ArrayList<>();
        prefixSumOfProbabilities.add(0.0);
        //make it to interval as p0, p0+p1, p0+p1+p2 ..
        for (double p: probabilities){
            prefixSumOfProbabilities.add(prefixSumOfProbabilities.get(prefixSumOfProbabilities.size()-1)+p);
        }
        Random r = new Random();
        double uniform01 = r.nextDouble();
        // find the index of the interval
        int it = Collections.binarySearch(prefixSumOfProbabilities,uniform01);
        if (it < 0){
            int index = (Math.abs(it)-1)-1;
            return values.get(index);
        }else{
            return values.get(it);
        }
    }

    public static void main(String[] args) {
        List<Double> list = new ArrayList<>(Arrays.asList(0.0,0.2,0.3,0.5,0.8,1.0));
        System.out.println(Collections.binarySearch(list,0.18));
    }
}
