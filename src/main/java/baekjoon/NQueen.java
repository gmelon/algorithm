package baekjoon;

import java.util.Scanner;

public class NQueen {

    static int answer = 0;
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        sc.close();

        // 풀이 시작
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                explore(i, j, 1,  visit(i, j, new boolean[N][N]));
            }
        }

        System.out.println(answer);
    }

    public static void explore(int curX, int curY, int depth, boolean[][] visited) {
        if (depth == N) {
            answer++;
            return;
        }

        for (int i = curX; i < N; i++) {
            for (int j = curY; j < N; j++) {
                if (i == curX && j == curY) {
                    continue;
                }

                if (!visited[i][j]) {
                    explore(i, j, depth + 1, visit(i, j, visited));
                }
            }
        }
    }

    // 상하좌우, 대각선 왼위,왼아,오위,오아
    static int[] dx = {-1, 1, 0, 0, -1, 1, -1, 1};
    static int[] dy = {0, 0, -1, 1, -1, -1, 1, 1};

    public static boolean[][] visit(int x, int y, boolean[][] visited) {
        boolean[][] newVisited = visited.clone();
        for (int i = 0; i < newVisited.length; i++) {
            newVisited[i] = visited[i].clone();
        }

        // 퀸 방문
        for (int i = 0; i < dx.length; i++) {
            int nextX = x;
            int nextY = y;
            while (nextX >= 0 && nextY >= 0 && nextX < N && nextY < N) {
                newVisited[nextX][nextY] = true;

                nextX += dx[i];
                nextY += dy[i];
            }
        }

        return newVisited;
    }

}
