class Solution {
    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public void rotate(int[] nums, int k) {
        int n = nums.length, index = 0, startIndex = 0;
        for (int i = 0; i < n; i++) {
            int nextIndex = (index + k) % n;
            swap(nums, nextIndex, startIndex);
            index = nextIndex;
            if (index == startIndex) {
                index++; startIndex++;
            }
        }
    }
}
