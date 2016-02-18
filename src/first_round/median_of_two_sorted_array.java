package src.first_round;

/**
 * Created by stameying on 2/16/16.
 */
public class median_of_two_sorted_array {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int k = ((nums1.length+nums2.length)>>1)+1;
        return (double) findKthElement(nums1,0,nums1.length-1,nums2,0,nums2.length,5);
    }

    public static int findKthElement(int[] nums1, int left1, int right1, int[] nums2, int left2, int right2, int k){
        System.out.println("left1="+left1+",right1="+right1+",left2="+left2+",right2="+right2+",k="+k);
        int len1 = right1-left1+1;
        int len2 = right2-left2+1;
        if (len1 > len2) return findKthElement(nums2,left2,right2,nums1,left1,right1,k);
        if (len1 == 0) return nums2[k-1];
        if (k == 1) return Math.min(nums1[left1],nums2[left2]);
        int partA = Math.min(k/2,len1);
        int partB = k-partA;
        int mid1 = nums1[left1+partA-1], mid2 = nums2[left2+partB-1];
        if (mid1 > mid2){
            return findKthElement(nums1,left1,right1,nums2,left2+partB,right2,k-partB);
        }else if (mid1 < mid2){
            return findKthElement(nums1,left1+partA,right1,nums2,left2,right2,k-partA);
        }else{
            return mid1;
        }
    }


    public static int findKthElement(int[] nums1, int[] nums2, int s1, int e1, int s2, int e2, int k){
        int len1 = e1-s1+1;
        int len2 = e2-s2+1;
        if (len1 > len2) return findKthElement(nums2,nums1,s2,e2,s1,e1,k); // assert first array is less
        if (len1 == 0) return nums2[k-1]; // no more numbers to be check in array1
        if (k == 1) return Math.min(nums1[s1],nums2[s2]);
        int part1 = Math.min(k/2,len1);
        int part2 = k-part1;
        int checkNum1 = nums1[s1+part1-1], checkNum2 = nums2[s2+part2-1];
        if (checkNum1 == checkNum2) return checkNum1;
        else if (checkNum1 < checkNum2){
            return findKthElement(nums1,nums2,s1+part1,e1,s2,e2,k-part1);
        }else{
            return findKthElement(nums1,nums2,s1,e1,s2+part2,e2,k-part2);
        }

    }

    public static void main(String[] args) {
        int[] arr1 = {1,4,8};
        int[] arr2 = {2,3,5,7};
//        System.out.println(findMedianSortedArrays(arr1,arr2));
//        System.out.println(findKth(arr1,0,arr1.length-1,arr2,0,arr2.length-1,7));
        System.out.println(findKthElement(arr1,arr2,0,arr1.length-1,0,arr2.length-1,4));
    }
}
