import java.util.*;

//Input: accounts = [["John","johnsmith@mail.com","john_newyork@mail.com"],["John","johnsmith@mail.com","john00@mail.com"],["Mary","mary@mail.com"],["John","johnnybravo@mail.com"]]
//        Output: [["John","john00@mail.com","john_newyork@mail.com","johnsmith@mail.com"],["Mary","mary@mail.com"],["John","johnnybravo@mail.com"]]
//        Explanation:
//        The first and second John's are the same person as they have the common email "johnsmith@mail.com".
//        The third John and Mary are different people as none of their email addresses are used by other accounts.
//        We could return these lists in any order, for example the answer [['Mary', 'mary@mail.com'], ['John', 'johnnybravo@mail.com'],
//        ['John', 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com']] would still be accepted.
public class AccountsMerge {
    class Solution {
        public List<List<String>> accountsMerge(List<List<String>> accounts) {
            Map<String, Set<String>> graph = new HashMap<>();
            Map<String, String> emailToName = new HashMap<>();

            // Step 1: Build the graph and emailToName map
            for (List<String> account : accounts) {
                String name = account.get(0);
                String firstEmail = account.get(1);
                for (int i = 1; i < account.size(); i++) {
                    String email = account.get(i);
                    emailToName.put(email, name);
                    graph.putIfAbsent(email, new HashSet<>());
                    if (i > 1) {
                        // Connect current email with the previous one
                        String prevEmail = account.get(i - 1);
                        graph.get(email).add(prevEmail);
                        graph.get(prevEmail).add(email);
                    }
                }
            }

            // Step 2: Traverse the graph to group related emails
            Set<String> visited = new HashSet<>();
            List<List<String>> result = new ArrayList<>();
            for (String email : graph.keySet()) {
                if (!visited.contains(email)) {
                    List<String> mergedAccount = new ArrayList<>();
                    dfs(graph, email, visited, mergedAccount);
                    Collections.sort(mergedAccount);
                    mergedAccount.add(0, emailToName.get(email));
                    result.add(mergedAccount);
                }
            }

            return result;
        }

        private void dfs(Map<String, Set<String>> graph, String email, Set<String> visited, List<String> mergedAccount) {
            visited.add(email);
            mergedAccount.add(email);
            for (String neighbor : graph.getOrDefault(email, new HashSet<>())) {
                if (!visited.contains(neighbor)) {
                    dfs(graph, neighbor, visited, mergedAccount);
                }
            }
        }
    }

}
