package leetcode;

/**
 * 33. Search in Rotated Sorted Array
 * Medium
 * <p>
 * 4641
 * <p>
 * 439
 * <p>
 * Add to List
 * <p>
 * Share
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * <p>
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * <p>
 * You may assume no duplicate exists in the array.
 * <p>
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * Example 2:
 * <p>
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 */
public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        if(nums.length == 0){
            return -1;
        }
        if(nums.length == 1 && nums[0] == target){
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            System.out.println("left = " + left + " | right = " + right);
            int leftValue = nums[left];
            if (leftValue == target) {
                return left;
            }

            int rightValue = nums[right];
            if (rightValue == target) {
                return right;
            }
            int mid = left + (right - left) / 2;
            int midValue = nums[mid];
            if (nums[mid] == target) {
                return mid;
            }

            if(leftValue < midValue){
                if(leftValue < target && target < midValue){
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if(midValue < rightValue){
                if(midValue < target && target < rightValue){
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                return -1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray obj = new SearchInRotatedSortedArray();
        int[] nums = {266,267,268,269,271,278,282,292,293,298,6,9,15,19,21,26,33,35,37,38,39,46,49,54,65,71,74,77,79,82,83,88,92,93,94,97,104,108,114,115,117,122,123,127,128,129,134,137,141,142,144,147,150,154,160,163,166,169,172,173,177,180,183,184,188,198,203,208,210,214,218,220,223,224,233,236,241,243,253,256,257,262,263};
        System.out.println(obj.search(nums, 208));
    }
}
