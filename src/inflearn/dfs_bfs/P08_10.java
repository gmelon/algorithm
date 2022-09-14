package inflearn.dfs_bfs;

import java.util.Scanner;

public class P08_10 {

    private static int answer = 0;
//    private static boolean[][] check; -> arr의 값을 1로 바꾸며 순회하는걸로 대체가능
    private static final int[] dx = {1, -1, 0, 0};
    private static final int[] dy = {0, 0, 1, -1};

    public static void solution(int[][] arr, int limit, int curX, int curY) {
        if (curX == limit && curY == limit) {
            answer++;
        }
        else {
            for (int i = 0; i < dx.length ; i++) {
                int newX = curX + dx[i];
                int newY = curY + dy[i];
                if (newX > 0 && newX <= limit && newY > 0 && newY <= limit && arr[newX][newY] == 0) {
                    arr[newX][newY] = 1;
                    solution(arr, limit, newX, newY);
                    arr[newX][newY] = 0;
                }
            }
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
        arr[1][1] = 1;
        solution(arr, SIZE, 1, 1);
        System.out.println(answer);
    }
}