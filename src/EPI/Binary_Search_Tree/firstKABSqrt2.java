package EPI.Binary_Search_Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by stameying on 2/1/16.
 */
public class firstKABSqrt2 {

    private static class ABSqrt2 implements Comparable<ABSqrt2>{
        public int a,b;
        public double val;

        public ABSqrt2(int a, int b) {
            this.a = a;
            this.b = b;
            val = a + b * Math.sqrt(2);
        }


        @Override
        public int compareTo(ABSqrt2 o) {return Double.compare(this.val,o.val);}
    }

    public static List<ABSqrt2> generateFirstKABSqrt2(int k){
        SortedSet<ABSqrt2> candidates = new TreeSet<>();
        candidates.add(new ABSqrt2(0,0));

        List<ABSqrt2> res = new ArrayList<>();
        while (res.size() < k){
            ABSqrt2 nextSmallest = candidates.first();
            res.add(nextSmallest);
            candidates.add(new ABSqrt2(nextSmallest.a+1,nextSmallest.b));
            candidates.add(new ABSqrt2(nextSmallest.a,nextSmallest.b+1));
        }
        return res;
    }
}
