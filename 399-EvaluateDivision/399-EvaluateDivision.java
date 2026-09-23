// Last updated: 9/23/2026, 2:44:39 PM
import java.util.*;

class Solution {

    public double[] calcEquation(
            List<List<String>> equations,
            double[] values,
            List<List<String>> queries) {

        // Graph
        Map<String, List<Node>> graph = new HashMap<>();

        // Build graph
        for (int i = 0; i < equations.size(); i++) {

            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double value = values[i];

            graph.putIfAbsent(a, new ArrayList<>());
            graph.putIfAbsent(b, new ArrayList<>());

            // a / b = value
            graph.get(a).add(new Node(b, value));

            // b / a = 1 / value
            graph.get(b).add(new Node(a, 1.0 / value));
        }

        double[] result = new double[queries.size()];

        // Process queries
        for (int i = 0; i < queries.size(); i++) {

            String start = queries.get(i).get(0);
            String end = queries.get(i).get(1);

            if (!graph.containsKey(start) ||
                !graph.containsKey(end)) {

                result[i] = -1.0;
            } 
            else {
                Set<String> visited = new HashSet<>();

                result[i] = dfs(
                    start,
                    end,
                    1.0,
                    graph,
                    visited
                );
            }
        }

        return result;
    }

    private double dfs(
            String current,
            String target,
            double product,
            Map<String, List<Node>> graph,
            Set<String> visited) {

        // Found target
        if (current.equals(target)) {
            return product;
        }

        visited.add(current);

        for (Node node : graph.get(current)) {

            if (visited.contains(node.name)) {
                continue;
            }

            double result = dfs(
                node.name,
                target,
                product * node.value,
                graph,
                visited
            );

            if (result != -1.0) {
                return result;
            }
        }

        return -1.0;
    }

    // Graph node
    class Node {
        String name;
        double value;

        Node(String name, double value) {
            this.name = name;
            this.value = value;
        }
    }
}