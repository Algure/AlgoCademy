class Solution {

    List<Integer> computeProfits(List<Integer[]> bottomTopPrices) {
        Stack<Integer[]> stack = new Stack<>();
        List<Integer> profits = new ArrayList<>();
        for (Integer[] bottomTop : bottomTopPrices) {
            int bottom = bottomTop[0];
            int top = bottomTop[1];
            while (!stack.empty() && bottom < stack.peek()[0]) {
                profits.add(stack.peek()[1] - stack.peek()[0]);
                stack.pop();
            }
            while (!stack.empty() && top >= stack.peek()[1]) {
                profits.add(stack.peek()[1] - bottom);
                bottom = stack.peek()[0];
                stack.pop();
            }
            stack.add(new Integer[]{bottom, top});
        }
        while (!stack.empty()) {
            profits.add(stack.peek()[1] - stack.peek()[0]);
            stack.pop();
        }
        return profits;
    }

    List<Integer[]> findBottomTopPrices(int[] prices) {
        int n = prices.length, i = 0;
        List<Integer[]> bottomTopPrices = new ArrayList<>();
        while (i < n) {
            int bottom = i;
            while (bottom + 1 < n && prices[bottom] >= prices[bottom + 1]) {
                ++bottom;
            }
            int top = bottom;
            while (top + 1 < n && prices[top] <= prices[top + 1]) {
                ++top;
            }
            bottomTopPrices.add(new Integer[]{prices[bottom], prices[top]});
            i = top + 1;
        }
        return bottomTopPrices;
    }

    int maxProfit(int[] prices, int k) {
        List<Integer[]> bottomTopPrices = findBottomTopPrices(prices);
        List<Integer> profits = computeProfits(bottomTopPrices);
        k = Math.min(k, profits.size());
    }
};
