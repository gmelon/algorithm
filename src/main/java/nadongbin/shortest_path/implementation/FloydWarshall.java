package nadongbin.shortest_path.implementation;

import java.util.Scanner;

public class FloydWarshall {

    private static final int INF = 1_000_000_000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 노드 개수
        int m = sc.nextInt(); // 간선 개수

        int[][] graph = new int[n + 1][n + 1]; // 인덱스로 1 ~ n 까지 사용

        // 그래프의 모든 값을 INF로 초기화
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                graph[i][j] = INF;
            }
        }

        // 자기 자신으로 가는비용은 0으로 초기화
        for (int i = 1; i < n + 1; i++) {
            graph[i][i] = 0;
        }

        // 인접 간선 정보 입력
        for (int i = 0; i < m; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int distance = sc.nextInt();

            graph[from][to] = distance;
        }

        sc.close();

        // 풀이 시작
        for (int k = 1; k < n + 1; k++) {
            for (int a = 1; a < n + 1; a++) {
                for (int b = 1; b < n + 1; b++) {
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
                }
            }
        }

        // 출력
        for (int a = 1; a < n + 1; a++) {
            for (int b = 1; b < n + 1; b++) {
                if (graph[a][b] == INF) {
                    System.out.print("INF ");
                } else {
                    System.out.print(graph[a][b] + " ");
                }
            }
            System.out.println(); // 개행
        }

    }

}
