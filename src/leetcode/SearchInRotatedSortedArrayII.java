package leetcode;

/**
 * 81. Search in Rotated Sorted Array II
 * Medium
 * <p>
 * 1157
 * <p>
 * 454
 * <p>
 * Add to List
 * <p>
 * Share
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).
 * <p>
 * You are given a target value to search. If found in the array return true, otherwise return false.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [2,5,6,0,0,1,2], target = 0
 * Output: true
 * Example 2:
 * <p>
 * Input: nums = [2,5,6,0,0,1,2], target = 3
 * Output: false
 */
public class SearchInRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        if (nums.length == 0) {
            return false;
        }
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            System.out.println("left = " + left + " | right = " + right);
            int leftValue = nums[left];
            if (leftValue == target) {
                return true;
            }

            int rightValue = nums[right];
            if (rightValue == target) {
                return true;
            }
            int mid = left + (right - left) / 2;
            int midValue = nums[mid];
            if (nums[mid] == target) {
                return true;
            }

            if (leftValue < midValue || midValue == rightValue) {
                if (leftValue < target && target < midValue) {
                    right = mid - 1;
                    continue;
                } else {
                    left = mid + 1;
                    continue;
                }
            } else if (midValue < rightValue || leftValue == midValue) {
                if (midValue < target && target < rightValue) {
                    left = mid + 1;
                    continue;
                } else {
                    right = mid - 1;
                    continue;
                }
            } else {
                return false;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArrayII obj = new SearchInRotatedSortedArrayII();
        int[] nums = {1, 1, 3, 1};
        System.out.println(obj.search(nums, 3));
    }
}
