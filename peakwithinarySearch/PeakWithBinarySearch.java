class Solution {

    boolean canGoRight(int[] nums, int i) {
        if (i == nums.length - 1) {
            return false;
        }
        return nums[i + 1] >= nums[i];
    }

    boolean canGoLeft(int[] nums, int i) {
        if (i == 0) {
            return false;
        }
        return nums[i - 1] >= nums[i];
    }

    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (canGoLeft(nums, middle)) {
                right = middle - 1;
            } else if (canGoRight(nums, middle)) {
                left = middle + 1;
            } else {
                return middle;
            }
        }
        return 0;
    }
};

