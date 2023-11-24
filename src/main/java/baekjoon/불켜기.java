package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 불켜기 {

    static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < N * N; i++) { // 0 ~ N * N - 1 인덱스
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            int from = N * (sc.nextInt() - 1) + sc.nextInt();
            int to = N * (sc.nextInt() - 1) + sc.nextInt();

            graph.get(from).add(to);
        }

        sc.close();

        // 풀이 시작
        boolean[] visited = new boolean[N * N];
        visited[0] = true;

        dfs(0, visited, graph);

        System.out.println(answer);
    }

    private static void dfs(int index, boolean[] visited, List<List<Integer>> graph) {

        answer++;

        for (Integer neighbor : graph.get(index)) {
            if (!visited[neighbor]) {
                visited[neighbor] = true;
                dfs(neighbor, visited, graph);
            }
        }

    }

}
