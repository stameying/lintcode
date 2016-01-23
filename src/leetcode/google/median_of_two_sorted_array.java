package leetcode.google;

/**
 * Created by stameying on 1/22/16.
 */
public class median_of_two_sorted_array {

    public double findMedian(int[] nums1, int[] nums2){
        int totalLen = (nums1.length + nums2.length);
        if (totalLen%2 == 0){
            return (findKthElement(nums1,nums2,0,nums1.length-1,0,nums2.length-1,totalLen/2)+findKthElement(nums1,nums2,0,nums1.length-1,0,nums2.length-1,totalLen/2+1))/2.0;
        }else{
            return findKthElement(nums1,nums2,0,nums1.length-1,0,nums2.length-1,totalLen/2+1);
        }
    }

    public double findKthElement(int[] nums1, int[] nums2, int left1, int right1, int left2, int right2, int k){
        int len1 = right1-left1+1;
        int len2 = right2-left2+1;
        // make sure first array is shorter than second one
        if (len1 > len2){
            return findKthElement(nums2,nums1,left2,right2,left1,right1,k);
        }
        if (len1 == 0) return nums2[k-1];
        if (k == 1) return Math.min(nums1[left1],nums2[left2]);
        int part1 = Math.min(k/2,len1);
        int part2 = k-part1;
        if (nums1[left1+part1-1] == nums2[left2+part2-1]) return nums1[left1+part1-1];
        else if (nums1[left1+part1-1] < nums2[left2+part2-1]){
            return findKthElement(nums1,nums2,left1+part1,right1,left2,right2,k-part1);
        }else{
            return findKthElement(nums1,nums2,left1,right1,left2+part2,right2,k-part2);
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3};
        int[] nums2 = {4,5,6,7,8};
        median_of_two_sorted_array test = new median_of_two_sorted_array();
        System.out.println(test.findMedian(nums1,nums2));
    }
}
