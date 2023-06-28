package nadongbin.dfsnbfs.n1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class N1_음료수얼려먹기 {

    // 세로길이(N) x 가로길이(M)

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] board = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        sc.close();

        System.out.println(solution(N, M, board));
    }

    static class Position {
        int x, y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

//15 14
//0 0 0 0 0 1 1 1 1 0 0 0 0 0
//1 1 1 1 1 1 0 1 1 1 1 1 1 0
//1 1 0 1 1 1 0 1 1 0 1 1 1 0
//1 1 0 1 1 1 0 1 1 0 0 0 0 0
//1 1 0 1 1 1 1 1 1 1 1 1 1 1
//1 1 0 1 1 1 1 1 1 1 1 1 0 0
//1 1 0 0 0 0 0 0 0 1 1 1 1 1
//0 1 1 1 1 1 1 1 1 1 1 1 1 1
//0 0 0 0 0 0 0 0 0 1 1 1 1 1
//0 1 1 1 1 1 1 1 1 1 1 0 0 0
//0 0 0 1 1 1 1 1 1 1 1 0 0 0
//0 0 0 0 0 0 0 1 1 1 1 0 0 0
//1 1 1 1 1 1 1 1 1 1 0 0 1 1
//1 1 1 0 0 0 1 1 1 1 1 1 1 1
//1 1 1 0 0 0 1 1 1 1 1 1 1 1

    public static int solution(final int N, final int M, final int[][] board) {
        int count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 0) {
                    bfs(N, M, new Position(i, j), board);
                    count++;
                }
            }
        }

        return count;
    }

    // 여기서 만나는 0들을 모두 1로 만들어버린다
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void bfs(int N, int M, Position start, int[][] board) {
        Queue<Position> queue = new LinkedList<>();
        queue.offer(start);
        board[start.x][start.y] = 1; // 방문 처리

        while (!queue.isEmpty()) {
            Position current = queue.poll();

            for (int i = 0; i < dx.length; i++) {
                int nextX = current.x + dx[i];
                int nextY = current.y + dy[i];

                if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) {
                    continue;
                }

                if (board[nextX][nextY] == 0) {
                    queue.offer(new Position(nextX, nextY));
                    board[nextX][nextY] = 1;
                }
            }
        }

    }


}
