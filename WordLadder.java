class Solution {
    int numOfChanges(String first, String second) {
        int differences = 0;
        for (int i = 0; i < first.length(); ++i) {
            differences += (first.charAt(i) != second.charAt(i)) ? 1 : 0;
        }
        return differences;
    }

    public int ladderLength(String beginWord, String endWord, List<String> words) {
        Deque<String> queue = new ArrayDeque<>();
        Map<String, Integer> minDist = new HashMap<>();
        queue.add(beginWord);
        minDist.put(beginWord, 1);
        while (!queue.isEmpty()) {
            String word = queue.poll();
            if (endWord.equals(word)) {
                break;
            }
            for (String nextWord : words) {
                if (numOfChanges(word, nextWord) != 1) {
                    continue;
                }
                if (minDist.containsKey(nextWord)) {
                    continue;
                }
                minDist.put(nextWord, minDist.get(word) + 1);
                queue.add(nextWord);
            }
        }
        return minDist.getOrDefault(endWord, 0);
    }
}

