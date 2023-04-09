class Solution {

    // implement merge sort for this problem
    // merge sort is a divide and conquer algorithm
    // with a time complexity of O(nlogn)
    // and a space complexity of O(n)

    public void merge(int[] nums, int left, int mid, int right) {
        // find the sizes of the two subarrays to be merged
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        for (int i = 0; i < n1; i++) {
            leftArr[i] = nums[left + i];
        }
        for (int i = 0; i < n2; i++) {
            rightArr[i] = nums[mid + i + 1];
        }

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                nums[k] = leftArr[i];
                i++;
            } else if (rightArr[j] < leftArr[i]) {
                nums[k] = rightArr[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            nums[k] = leftArr[i];
            i++;
            k++;
        }
        while (j < n2) {
            nums[k] = rightArr[j];
            j++;
            k++;
        }
    }

    public void mergeSort(int[] nums, int left, int right) {
        if (left >= right)
            return;

        int mid = (left + right) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

    public void sortColors(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
    }
}