package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 * <p>
 * You may assume that the intervals were initially sorted according to their start times.
 * <p>
 * Example 1:
 * <p>
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 * Example 2:
 * <p>
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]]
 * Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 * NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
 */
public class InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (newInterval.length == 0) {
            return intervals;
        }
        if (intervals.length == 0) {
            return new int[][]{newInterval};
        }

        List<int[]> newIntervals = new ArrayList<>();
        int currentLeft = intervals[0][0];
        int currentRight = intervals[0][1];
        boolean flag = false;
        for (int i = 0; i < intervals.length; i++) {
            System.out.println(currentRight);
            if(!flag && newInterval[0] <= intervals[i][1]){
                currentLeft = Math.min(intervals[i][0], newInterval[0]);
                currentRight = Math.max(intervals[i][1], newInterval[1]);
                flag = true;
                continue;
            }

            if (i == 0 || intervals[i][0] > currentRight) {
                newIntervals.add(new int[]{currentLeft, currentRight});

                currentLeft = intervals[i][0];
                currentRight = intervals[i][1];
            } else {
                currentRight = Math.max(currentRight, intervals[i][1]);
            }
        }

        newIntervals.add(new int[]{currentLeft, currentRight});
        if(!flag){
            newIntervals.add(newInterval);
        }

        int[][] result = new int[newIntervals.size()][2];

        for (int i = 0; i < newIntervals.size(); i++) {
            result[i] = newIntervals.get(i);
        }

        return result;

    }

    public static void main(String[] args) {
        InsertInterval obj = new InsertInterval();
        int[] newInterval = {2,7};
        int[][] intervals = {{1,5}};

        obj.insert(intervals, newInterval);
    }
}
