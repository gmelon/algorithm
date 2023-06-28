package nadongbin.dfsnbfs.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Graph {

    public static void main(String[] args) {
        List<List<Integer>> graph = new ArrayList<>();

        // 정점이 8개라고 가정, index는 1부터 사용
        for (int i = 0; i < 9; i++) {
            graph.add(new ArrayList<>());
        }

        graph.get(1).add(2);
        graph.get(1).add(3);
        graph.get(1).add(4);

        graph.get(2).add(5);
        graph.get(2).add(6);

        graph.get(4).add(8);

        graph.get(6).add(7);

        System.out.print("BFS : ");
        bfs(graph);
        System.out.println();

        System.out.print("DFS Recursive : ");
        dfsRecursive(1, graph, new boolean[9]);
        System.out.println();

        System.out.print("DFS Stack : ");
        dfsStack(graph);
        System.out.println();
    }

    public static void bfs(List<List<Integer>> graph) {

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[9]; // 1 ~ 8

        queue.offer(1);
        visited[1] = true;

        while (!queue.isEmpty()) {
            Integer currentNode = queue.poll();

            System.out.print(currentNode + " ");

            for (Integer neighbor : graph.get(currentNode)) {
                if (!visited[neighbor]) {
                    queue.offer(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
    }

    public static void dfsRecursive(Integer currentNode, List<List<Integer>> graph, boolean[] visited) {
        // 방문 처리
        visited[currentNode] = true;

        System.out.print(currentNode + " ");

        for (Integer neighbor : graph.get(currentNode)) {
            if (!visited[neighbor]) {
                dfsRecursive(neighbor, graph, visited);
            }
        }
    }

    public static void dfsStack(List<List<Integer>> graph) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[9];

        stack.push(1);
        visited[1] = true;

        while (!stack.isEmpty()) {
            Integer currentNode = stack.pop();

            System.out.print(currentNode + " ");

            for (Integer neighbor : graph.get(currentNode)) {
                if (!visited[neighbor]) {
                    stack.push(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
    }

}
