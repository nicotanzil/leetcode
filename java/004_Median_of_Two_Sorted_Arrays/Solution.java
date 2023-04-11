public class Solution {

    // this solution will first merge the two given arrays into
    // a single array and then find the median of the new array
    // the fastest way to merge the two sorted arrays is to use
    // the merge sort algorithm

    // Time: O(n + m)
    // Space: O(n + m)

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // merge the two arrays using merge sort
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[] ar = new int[n1 + n2];

        int i = 0, j = 0, k = 0;

        while (i < n1 && j < n2) {
            if (nums1[i] <= nums2[j]) {
                ar[k] = nums1[i++];
            } else {
                ar[k] = nums2[j++];
            }
            k++;
        }

        while (i < n1) {
            ar[k] = nums1[i];
            i++;
            k++;
        }

        while (j < n2) {
            ar[k] = nums2[j];
            j++;
            k++;
        }

        // find the median of the new array
        double res = 0;
        if (ar.length % 2 == 1)
            res = ar[ar.length / 2];
        else
            res = (ar[ar.length / 2 - 1] + ar[ar.length / 2]) / 2.0;

        return res;
    }
}
