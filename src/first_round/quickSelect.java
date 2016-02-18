package src.first_round;

/**
 * Created by stameying on 12/23/15.
 */
public class quickSelect {

    public int partition(int[] nums, int left, int right, int pivotIndex){
        int pivot = nums[pivotIndex];
        swap(nums,right,pivotIndex);
        int storeIndex = left;
        for (int i = left; i < right; i++){
            if (nums[i] < pivot){
                swap(nums,storeIndex,i);
                storeIndex++;
            }
        }
        swap(nums,right,storeIndex);
        return storeIndex;
    }

    public void swap(int[] nums, int left, int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public int quickSelect(int[] nums, int left, int right, int n){
        if (left == right) return nums[left]; // list only contains one element
        int pivotIndex = (int) (left + Math.floor(Math.random()*(right-left+1)));
        pivotIndex = partition(nums,left,right,pivotIndex);
        if (n == pivotIndex) return nums[pivotIndex];
        else if (n < pivotIndex) return quickSelect(nums,left,pivotIndex-1,n);
        else return quickSelect(nums,pivotIndex+1,right,n);
    }

    public static void main(String[] args) {
        int[] nums = {9,3,2,4,8};
        int largest = 4;
        int smallest = nums.length + 1 - largest-1;
        quickSelect test = new quickSelect();
        System.out.println(smallest + "th smallest number is " + test.quickSelect(nums,0,nums.length-1,smallest));
    }
}
