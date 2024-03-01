package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class 미로만들기 {

    static int[][] map;
    static int minCount = Integer.MAX_VALUE;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }
        br.close();

        bfs();

        System.out.println(minCount);
    }

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    static void bfs() {
        Deque<Position> queue = new ArrayDeque<>();
        int[][] counts = new int[N][N];
        int[][] steps = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                counts[i][j] = 1_000_000_000;
                steps[i][j] = 1_000_000_000;
            }
        }

        // init
        queue.offer(new Position(0, 0, 0, 0));
        counts[0][0] = 0;
        steps[0][0] = 0;

        while (!queue.isEmpty()) {
            Position current = queue.poll();
            if (current.destroyCount >= minCount) {
                continue;
            }

            if (current.x == N - 1 && current.y == N - 1) {
                // 도착점에 도달
                minCount = current.destroyCount;
            }

            for (int d = 0; d < 4; d++) {
                int nX = current.x + dx[d];
                int nY = current.y + dy[d];

                if (nX < 0 || nX >= N || nY < 0 || nY >= N) {
                    continue;
                }

                if (steps[nX][nY] <= current.step && counts[nX][nY] <= current.destroyCount) {
                    // 유망하지 않음
                    continue;
                }

                steps[nX][nY] = Math.min(steps[nX][nY], current.step + 1);
                if (map[nX][nY] == 1) {
                    counts[nX][nY] = Math.min(counts[nX][nY], current.destroyCount);
                    queue.offer(new Position(nX, nY, current.destroyCount, current.step + 1));
                } else {
                    counts[nX][nY] = Math.min(counts[nX][nY], current.destroyCount + 1);
                    queue.offer(new Position(nX, nY, current.destroyCount + 1, current.step + 1));
                }
            }
        }
    }

    static class Position {
        int x, y, destroyCount, step;

        public Position(int x, int y, int destroyCount, int step) {
            this.x = x;
            this.y = y;
            this.destroyCount = destroyCount;
            this.step = step;
        }
    }
}
