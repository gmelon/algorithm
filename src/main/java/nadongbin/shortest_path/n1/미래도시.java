package nadongbin.shortest_path.n1;

import java.util.Scanner;

public class 미래도시 {

    private final static int INF = 1_000_000_000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] graph = new int[n + 1][n + 1];
        // 그래프 초기화
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                graph[i][j] = INF;
            }
        }

        for (int i = 0; i < n + 1; i++) {
            graph[i][i] = 0;
        }

        // 간선 입력
        for (int i = 0; i < m; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            graph[from][to] = 1;
            graph[to][from] = 1;
        }

        int x = sc.nextInt();
        int k = sc.nextInt();

        sc.close();

        // 풀이 시작
        // 플로이드-워셜

        for (int K = 1; K < n + 1; K++) {
            for (int A = 1; A < n + 1; A++) {
                for (int B = 1; B < n + 1; B++) {
                    graph[A][B] = Math.min(graph[A][B], graph[A][K] + graph[K][B]);
                }
            }
        }

        int answer = graph[1][k] + graph[k][x];

        if (answer >= INF) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }

}
