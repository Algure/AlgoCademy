class Solution {

    public int longestSubarrayWithoutReapeating(int[] nums) {
        Set<Integer> set = new HashSet();
        int result = Integer.MIN_VALUE;
        int j = 0;
        for(int i = 0; i < nums.length; i++){
            while( j < nums.length && !set.contains(nums[j])){
                set.add(nums[j]);
                j++;
            }
             result = Math.max(result, set.size());
             set.remove(nums[i]);
        }
      return result;
    }
}




 


