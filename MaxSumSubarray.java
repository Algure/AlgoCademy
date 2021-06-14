class Solution {
    
    int maxSumSubarray(int[] nums) {
        int result = nums[0];
        int maxSum = 0;
        for (int val : nums) {
            maxSum = val + Math.max(maxSum, 0);
            result = Math.max(result, maxSum);
        }
        return result;
    }

    int maxSumOfThreeSubarrays(int[] nums) {
        int n = nums.length;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            int sum1 = this.maxSumSubarray(Arrays.copyOfRange(nums, 0, i));
            int sum2 = 0;
            for (int j = i; j < n - 1; j++) {
                sum2 += nums[j];
                int sum3 = this.maxSumSubarray(Arrays.copyOfRange(nums, j + 1, nums.length));
                maxSum = Math.max(maxSum, sum1 + sum2 + sum3);
            }
        }
        return maxSum;
    }
}

