package Graph;

import com.sun.source.tree.WhileLoopTree;

import java.util.*;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // Include beginWord in the list to ensure it's in the graph
        if (!wordList.contains(beginWord)) wordList.add(beginWord);

        // 1) Precompute pattern → words map
        int M = beginWord.length();
        Map<String, List<String>> patternMap = new HashMap<>();
        for (String word : wordList) {
            for (int i = 0; i < M; i++) {
                String pattern = word.substring(0, i) + '*' + word.substring(i + 1);
                patternMap.computeIfAbsent(pattern, k -> new ArrayList<>()).add(word);
            }
        }

        // 2) BFS initialization
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        Map<String, Integer> dist = new HashMap<>();
        dist.put(beginWord, 1);

        // 3) BFS
        while (!queue.isEmpty()) {
            String word = queue.poll();
            int level = dist.get(word);

            // Generate all intermediate patterns
            for (int i = 0; i < M; i++) {
                String pattern = word.substring(0, i) + '*' + word.substring(i + 1);
                List<String> adj = patternMap.getOrDefault(pattern, Collections.emptyList());

                // Visit all neighbors matching this pattern
                for (String next : adj) {
                    if (next.equals(endWord)) {
                        return level + 1;
                    }
                    if (!dist.containsKey(next)) {
                        dist.put(next, level + 1);
                        queue.offer(next);
                    }
                }
                // Avoid re-visiting this pattern
                patternMap.put(pattern, Collections.emptyList());
            }
        }

        return 0;
    }
}
