package Google_Topic;

/**
 * Created by stameying on 2/10/16.
 */
public class p80_array_same {

    /**
     * 在array里找到一个点 两边的和相同
     * */

    public static int sameSum(int[] nums){
        int left = 0;
        int right = 0;
        for (int i = 1; i < nums.length; i++) right+= nums[i];
        if (left == right) return 0;
        for (int i = 1; i < nums.length; i++){
            right-=nums[i];
            left+=nums[i-1];
            if (left == right) return i;
        }
        return nums.length;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,4,-2,1,2,4,-1};
        System.out.println(sameSum(arr));
    }
}
