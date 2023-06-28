package nadongbin.dfsnbfs.n2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class N2_미로탈출 {

    static class Position {
        int x, y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine(); // 개행 처리

        int[][] maze = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < M; j++) {
                maze[i][j] = line.charAt(j) - '0';
            }
        }

        sc.close();

        System.out.println(solution(N, M, maze));
    }

    // 0 -> 괴물, 1 -> 통로
    private static int solution(int N, int M, int[][] maze) {
        int[][] length = new int[N][M];
        Queue<Position> queue = new LinkedList<>();

        queue.offer(new Position(0, 0)); // (0, 0) 에서 시작
        maze[0][0] = 0; // 방문 처리
        length[0][0] = 1; // 도달에 걸린 거리 기록

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        while (!queue.isEmpty()) {
            Position current = queue.poll();

            if (current.x == N - 1 && current.y == M - 1) {
                // BFS이므로 목표 지점에 도달하는 순간 최단 거리가 구해진다
                break;
            }

            for (int i = 0; i < dx.length; i++) {
                int nextX = current.x + dx[i];
                int nextY = current.y + dy[i];

                if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) {
                    continue;
                }

                // 통로만 방문
                if (maze[nextX][nextY] == 1) {
                    maze[nextX][nextY] = 0; // 방문 처리
                    length[nextX][nextY] = length[current.x][current.y] + 1; // 길이 기록
                    queue.offer(new Position(nextX, nextY));
                }
            }
        }
        return length[N - 1][M - 1];
    }


}
