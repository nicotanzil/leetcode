import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class Solution {

    // use a linked list to store the intervals
    // sort the intervals by their starting points
    // if the last interval in the linked list has a greater ending point than the
    // current interval, then merge the two intervals
    // otherwise, add the current interval to the linked list

    // time complexity: O(nlogn)
    // space complexity: O(n)

    public int[][] merge(int[][] intervals) {
        LinkedList<int[]> res = new LinkedList<>();

        if (intervals.length == 1) {
            return intervals;
        }
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));

        res.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            if (res.getLast()[1] >= intervals[i][0])
                res.getLast()[1] = Math.max(res.getLast()[1], intervals[i][1]);
            else
                res.add(intervals[i]);
        }

        int[][] output = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            output[i] = res.get(i);
        }

        return output;
    }
}
