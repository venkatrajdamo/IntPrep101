package Graph;

import java.util.*;

public class AlienDictionary {
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> inDegree = new HashMap<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                graph.putIfAbsent(c, new HashSet<>());
                inDegree.putIfAbsent(c, 0);
            }
        }

        // Step 2: Build graph edges by comparing adjacent words.
        for (int i = 1; i < words.length; i++) {
            String word1 = words[i - 1];
            String word2 = words[i];
            int minLen = Math.min(word1.length(), word2.length());
            boolean foundDifference = false;
            for (int j = 0; j < minLen; j++) {
                char c1 = word1.charAt(j);
                char c2 = word2.charAt(j);
                if (c1 != c2) {
                    // If edge from c1 to c2 hasn't been added yet, add it.
                    if (!graph.get(c1).contains(c2)) {
                        graph.get(c1).add(c2);
                        inDegree.put(c2, inDegree.get(c2) + 1);
                    }
                    foundDifference = true;
                    break;
                }
            }
            // Edge case: Check for invalid order where word1 is longer than word2 but word2 is a prefix.
            if (!foundDifference && word1.length() > word2.length()) {
                return "";
            }
        }

        // Step 3: Use Kahn's algorithm (BFS) for topological sort.
        Queue<Character> queue = new LinkedList<>();
        // Add all nodes with in-degree 0.
        for (char c : inDegree.keySet()) {
            if (inDegree.get(c) == 0) {
                queue.offer(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            char curr = queue.poll();
            sb.append(curr);
            for (char neighbor : graph.get(curr)) {
                inDegree.put(neighbor, inDegree.get(neighbor) - 1);
                if (inDegree.get(neighbor) == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // If the topological order doesn't include all characters, a cycle exists.
        if (sb.length() != inDegree.size()) {
            return "";
        }
        return sb.toString();
    }
}
