class Solution {

    int maxSumOfThreeSubarrays(int[] nums) {
        int n = nums.length;
        
        int[] leftMaxSum = new int[n];
        leftMaxSum[0] = nums[0];
        int maxSum = nums[0];
        for (int i = 1; i < n; ++i) {
            maxSum = nums[i] + Math.max(maxSum, 0);
            leftMaxSum[i] = Math.max(leftMaxSum[i - 1], maxSum);
        }

        int[] rightMaxSum = new int[n];
        rightMaxSum[n - 1] = nums[n - 1];
        maxSum = nums[n - 1];
        for (int i = n - 2; i >= 0; --i) {
            maxSum = nums[i] + Math.max(maxSum, 0);
            rightMaxSum[i] = Math.max(rightMaxSum[i + 1], maxSum);
        }
        
        maxSum = Integer.MIN_VALUE;
        for (int i = 1; i < n; ++i) {
            int sum1 = leftMaxSum[i - 1];
            int sum2 = 0;
            for (int j = i; j < n - 1; ++j) {
                sum2 += nums[j];
                int sum3 = rightMaxSum[j + 1];
                maxSum = Math.max(maxSum, sum1 + sum2 + sum3);
            }
        }
        
        return maxSum;
    }
};

