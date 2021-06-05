class Solution {
    public int[] kSmallest(int[] nums, int k) {
        PriorityQueue<Integer> smallestKNums = new PriorityQueue<>((x, y) -> y - x);
        
        for (int value : nums) {
            if (smallestKNums.size() < k) {
                smallestKNums.add(value);
            } else if (value < smallestKNums.peek()) {
                smallestKNums.poll();
                smallestKNums.add(value);
            }
        }
        
        int[] result = new int[k];
        for (int i = 0; i < k; ++i) {
            result[i] = smallestKNums.poll();
        }
        return result;
    }
}


