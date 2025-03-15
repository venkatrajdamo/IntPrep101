/*
Problem Statement:
You are given a list of accounts where each account is represented by a list of strings. The first element in each account is the name of the account owner, and the remaining elements are emails belonging to that account.

We want to merge accounts if they share a common email.
After merging, return the accounts in the following format:
	•	Each account should contain the account name followed by all unique emails sorted lexicographically.
	•	The final accounts should be sorted by the name in lexicographical order.

IP:
[
    ["John", "johnsmith@mail.com", "john_newyork@mail.com"],
    ["John", "johnsmith@mail.com", "john00@mail.com"],
    ["Mary", "mary@mail.com"],
    ["John", "johnnybravo@mail.com"]
]

OP:
[
    ["John", "john00@mail.com", "john_newyork@mail.com", "johnsmith@mail.com"],
    ["John", "johnnybravo@mail.com"],
    ["Mary", "mary@mail.com"]
]
*/
/*
Time Complexity:
	•	Building Disjoint Set: O(N*K)
	•	Path Compression in Union-Find: O(N*K * α(N*K)), where α is the inverse Ackermann function (very slow-growing).
	•	Sorting emails: O(N*K log K)
	•	Total Complexity: O(N*K log K)
*/
package Graph;

import java.util.*;

public class AccountsMerge {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> parent = new HashMap<>();
        Map<String, String> emailToName = new HashMap<>();
        Map<String, List<String>> unions = new HashMap<>();

        // Step 1: Initialize parent mapping
        for (List<String> account : accounts) {
            String name = account.get(0);
            for (int i = 1; i < account.size(); i++) {
                parent.put(account.get(i), account.get(i));
                emailToName.put(account.get(i), name);
            }
        }

        // Step 2: Union emails in the same account
        for (List<String> account : accounts) {
            String root = find(account.get(1), parent);
            for (int i = 2; i < account.size(); i++) {
                parent.put(find(account.get(i), parent), root);
            }
        }

        // Step 3: Group emails by their root
        for (String email : parent.keySet()) {
            String root = find(email, parent);
            unions.putIfAbsent(root, new ArrayList<>());
            unions.get(root).add(email);
        }

        // Step 4: Sort and format results
        List<List<String>> result = new ArrayList<>();
        for (String root : unions.keySet()) {
            List<String> emails = unions.get(root);
            Collections.sort(emails);
            emails.add(0, emailToName.get(root));
            result.add(emails);
        }

        return result;
    }

    private String find(String email, Map<String, String> parent) {
        if (!parent.get(email).equals(email)) {
            parent.put(email, find(parent.get(email), parent));  // Path compression
        }
        return parent.get(email);
    }
}
