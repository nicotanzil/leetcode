import java.util.HashMap;
import java.util.Map;

public class Solution {

    // intuitive approach using hash map to count the
    // number of occurence of each element
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int res = 0;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (e.getValue() >= (nums.length / 2 + 1)) {
                res = e.getKey();
                break;
            }
        }
        return res;
    }

    // faster approach using Boyer-Moore Voting Algorithm
    // source: https://www.cs.utexas.edu/~moore/best-ideas/mjrty/index.html
    public int majorityElementFastest(int[] nums) {
        int currCandidate = nums[0];
        int counter = 0;
        for (int i = 0; i < nums.length; i++) {
            if (counter == 0) {
                currCandidate = nums[i];
                counter = 1;
            } else if (counter != 0) {
                if (nums[i] == currCandidate)
                    counter++;
                else
                    counter--;
            }
        }

        return currCandidate;
    }
}
