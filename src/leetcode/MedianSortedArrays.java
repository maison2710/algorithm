package leetcode;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 *
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 *
 * You may assume nums1 and nums2 cannot be both empty.
 *
 * Example 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * The median is 2.0
 * Example 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * The median is (2 + 3)/2 = 2.5
 */
public class MedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        int mid = (nums1.length + nums2.length)/2;
        int midValue1 = 0;
        int midValue2 = 0;

        while(i + j <= mid){
            midValue1 = midValue2;
            if(i == nums1.length){
                midValue2 = nums2[j];
                j++;
                continue;
            }
            if(j == nums2.length){
                midValue2 = nums1[i];
                i++;
                continue;
            }
            if(nums1[i] > nums2[j]){
                midValue2 = nums2[j];
                j++;
            } else {
                midValue2 = nums1[i];
                i++;
            }
        }

        if((nums1.length + nums2.length) % 2 == 1){
            return midValue2;
        } else {
            return (double) (midValue1+midValue2)/2;
        }
    }

    public static void main(String[] args) {
        MedianSortedArrays obj = new MedianSortedArrays();
        int[] nums1 = {1};
        int[] nums2 = {3};
        System.out.println(obj.findMedianSortedArrays(nums1, nums2));
    }
}
