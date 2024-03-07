package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 뱀과_사다리_게임 {

    static int[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new int[101];
        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            graph[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }
        br.close();

        System.out.println(bfs());
    }

    static int bfs() {
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[101];

        queue.offer(1);
        visited[1] = true;

        int distance = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                int current = queue.poll();

                // 6방향 주사위 이동
                for (int i = 1; i <= 6; i++) {
                    int next = current + i;

                    if (next == 100) {
                        // 완료
                        return distance;
                    }

                    if (next > 100 || visited[next]) {
                        continue;
                    }

                    visited[next] = true;
                    if (graph[next] != 0) {
                        // 뱀 / 사다리 이동
                        queue.offer(graph[next]);
                        visited[graph[next]] = true;
                    } else {
                        // 일반 이동
                        queue.offer(next);
                    }
                }
            }

            distance++;
        }

        throw new AssertionError("100에 도달하지 못함");
    }

}
