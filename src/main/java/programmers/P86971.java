package programmers;

import java.util.*;

class P86971 {

    public int solution(int n, int[][] wires) {

        int answer = Integer.MAX_VALUE;

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] wire : wires) {
            int nodeA = wire[0];
            int nodeB = wire[1];

            if (graph.get(nodeA) == null) {
                graph.put(nodeA, new ArrayList<>());
            }
            graph.get(nodeA).add(nodeB);

            if (graph.get(nodeB) == null) {
                graph.put(nodeB, new ArrayList<>());
            }
            graph.get(nodeB).add(nodeA);
        }

        for (int[] wire : wires) {
            graph.get(wire[0]).remove(Integer.valueOf(wire[1]));
            graph.get(wire[1]).remove(Integer.valueOf(wire[0]));

            int diff = dfs(n, graph, wire[0]) - dfs(n, graph, wire[1]);
            answer = Math.min(answer, Math.abs(diff));

            graph.get(wire[0]).add(wire[1]);
            graph.get(wire[1]).add(wire[0]);
        }

        return answer;
    }

    public int dfs(final int n, final Map<Integer, List<Integer>> graph, int startNode) {
        int count = 0;
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[n + 1];

        stack.push(startNode);

        while(!stack.isEmpty()) {
            Integer current = stack.pop();
            count++;
            visited[current] = true;

            if (graph.get(current) == null) {
                continue;
            }

            for (Integer neighbor : graph.get(current)) {
                if (!visited[neighbor]) {
                    stack.push(neighbor);
                }
            }
        }

        return count;
    }

}
