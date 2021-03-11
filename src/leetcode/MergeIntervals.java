package leetcode;

import java.util.*;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 * <p>
 * Example 1:
 * <p>
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * Example 2:
 * <p>
 * Input: [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 */
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 0){
            return intervals;
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] lefts = new int[intervals.length];

        for (int i = 0; i < intervals.length; i++) {
            if(map.containsKey(intervals[i][0])){
                if(intervals[i][1] > map.get(intervals[i][0])){
                    map.put(intervals[i][0], intervals[i][1]);
                }
            } else {
                map.put(intervals[i][0], intervals[i][1]);
            }

            lefts[i] = intervals[i][0];
        }

        Arrays.sort(lefts);

        List<List<Integer>> newIntervals = new ArrayList<List<Integer>>();
        int currentLeft = lefts[0];
        int currentRight = map.get(lefts[0]);
        for (int i = 1; i < lefts.length; i++) {
            if (lefts[i] > currentRight) {
                List<Integer> newArrival = new ArrayList<>();
                newArrival.add(currentLeft);
                newArrival.add(currentRight);
                newIntervals.add(newArrival);

                currentLeft = lefts[i];
                currentRight = map.get(lefts[i]);
            } else {
                currentRight = Math.max(currentRight, map.get(lefts[i]));
            }
        }

        List<Integer> newArrival = new ArrayList<>();
        newArrival.add(currentLeft);
        newArrival.add(currentRight);
        newIntervals.add(newArrival);

        int[][] result = new int[newIntervals.size()][2];

        for(int i = 0; i < newIntervals.size(); i++){
            result[i][0] = newIntervals.get(i).get(0);
            result[i][1] = newIntervals.get(i).get(1);
        }

        return result;

    }

    public static void main(String[] args) {
        int[][] result = new int[2][2];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.println(result[i][j]);
            }
        }
    }
}
