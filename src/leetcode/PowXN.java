package leetcode;

/**
 * Implement pow(x, n), which calculates x raised to the power n (xn).
 * <p>
 * Example 1:
 * <p>
 * Input: 2.00000, 10
 * Output: 1024.00000
 * Example 2:
 * <p>
 * Input: 2.10000, 3
 * Output: 9.26100
 * Example 3:
 * <p>
 * Input: 2.00000, -2
 * Output: 0.25000
 * Explanation: 2-2 = 1/22 = 1/4 = 0.25
 */
public class PowXN {
    public double myPow(double x, int n) {
        if (x == 1) {
            return 1;
        }
        if(n == Integer.MAX_VALUE || n == Integer.MIN_VALUE){
            return 0;
        }
        double pow = 1;

        for (int i = 1; i <= Math.abs(n); i++) {
            pow *= x;
            if (pow == 0) {
                return 0;
            }
            if (n < 0 && (double) 1 / pow == 0) {
                return 0;
            }
        }
        System.out.println(pow);
        return n > 0 ? pow : 1 / pow;
    }

    public static void main(String[] args) {
        PowXN obj = new PowXN();
        System.out.println(obj.myPow(2.00000, -2147483648));
    }
}
