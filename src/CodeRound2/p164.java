package src.CodeRound2;

/**
 * Created by stameying on 2/24/16.
 */
public class p164 {

    private static class bucket{
        int low,high;

        public bucket() {
            low = Integer.MAX_VALUE;
            high = -1;
        }

        public bucket(int low, int high) {
            this.low = low;
            this.high = high;
        }
    }
    public static int maxGap(int[] nums){

        if (nums == null || nums.length < 2) return 0;
        int maxVal = 0, minVal = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] > maxVal) maxVal = nums[i];
            if (nums[i] < minVal) minVal = nums[i];
        }

        int N = nums.length;
        int bucketLen = (maxVal-minVal)/(N-1);
        int numOfBucket = (maxVal-minVal)/bucketLen+1;
        bucket[] buckets = new bucket[numOfBucket];
        for (int i = 0; i < buckets.length; i++){
            buckets[i] = new bucket();
        }

        for (int i = 0; i < N; i++){
            int k = nums[i];
            int bucketIdx = (k-minVal)/bucketLen;
            bucket b = buckets[bucketIdx];
            b.high = Math.max(b.high,k);
            b.low = Math.min(b.low,k);
        }

        int maxDiff = 0;
        int prev = -1;
        for (int i = 0; i < buckets.length; i++){
            if (buckets[i].high != -1){
                if (prev == -1){
                    prev = buckets[i].low;
                }else{
                    maxDiff = Math.max(maxDiff,buckets[i].high-prev);
                    prev = buckets[i].low;
                }
            }
        }

        return maxDiff;
    }


    public static void main(String[] args) {
        int[] nums = {5,9,8,3,15};
        System.out.println(maxGap(nums));
    }
}
