package leetcode;

/**
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 * <p>
 * Note: You may not slant the container and n is at least 2.
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
 * <p>
 * <p>
 * <p>
 * Example:
 * <p>
 * Input: [1,8,6,2,5,4,8,3,7]
 * Output: 49
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int result = 0;
        int a = 0;
        int b = height.length - 1;

        while (a < b){
            if(height[a] < height[b]){
                result = Math.max(result, height[a] * (b - a));
                a++;
            } else {
                result = Math.max(result, height[b] * (b - a));
                b--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        ContainerWithMostWater obj = new ContainerWithMostWater();
        int[] array = {1,8,6,2,5,4,8,3,7};
        System.out.println(obj.maxArea(array));
    }
}
