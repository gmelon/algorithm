package inflearn.dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P08_11 {

    private static final int[] dx = {1, -1, 0, 0};
    private static final int[] dy = {0, 0, 1, -1};

    public static class Point {

        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void solution(int[][] arr, int SIZE) {

        Queue<Point> Q = new LinkedList<>();
//        boolean[][] check = new boolean[SIZE+1][SIZE+1]; -> arr[x][y] = 1 설정, arr[x][y] == 0 체크로 대체 가능
        int[][] distance = new int[SIZE+1][SIZE+1];

        Q.offer(new Point(1, 1));
        arr[1][1] = 1;

        while (!Q.isEmpty()) {
            Point curPoint = Q.poll();
            for (int i = 0; i < dx.length; i++) {
                int newX = curPoint.x + dx[i];
                int newY = curPoint.y + dy[i];
                if (newX >= 1 && newX <= SIZE && newY >= 1 && newY <= SIZE && arr[newX][newY] == 0) {
                    arr[newX][newY] = 1;
                    distance[newX][newY] = distance[curPoint.x][curPoint.y] + 1;
                    Q.offer(new Point(newX, newY));
                }
            }
        }

        if (distance[SIZE][SIZE] != 0) {
            System.out.println(distance[SIZE][SIZE]);
        }
        else {
            System.out.println(-1);
        }

    }





    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int SIZE = 7;
        int[][] arr = new int[SIZE+1][SIZE+1];
        for (int i = 1; i <= SIZE; i++) {
            for (int j = 1; j <= SIZE; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        solution(arr, SIZE);
    }
}