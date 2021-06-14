class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> words) {
        Set<String> wordSet = new HashSet<>(words);
        Deque<String> queue = new ArrayDeque<>();
        Map<String, Integer> minDist = new HashMap<>();
        queue.add(beginWord);
        minDist.put(beginWord, 1);
        while (!queue.isEmpty()) {
            String word = queue.poll();
            if (endWord.equals(word)) {
                break;
            }
            for (int i = 0; i < word.length(); ++i) {
                for (char c = 'a'; c <= 'z'; ++c) {
                    String nextWord = word.substring(0, i) + c + word.substring(i + 1);
                    if (!wordSet.contains(nextWord)) {
                        continue;
                    }
                    if (minDist.containsKey(nextWord)) {
                        continue;
                    }
                    minDist.put(nextWord, minDist.get(word) + 1);
                    queue.add(nextWord);
                }
            }
        }
        return minDist.getOrDefault(endWord, 0);
    }
}

