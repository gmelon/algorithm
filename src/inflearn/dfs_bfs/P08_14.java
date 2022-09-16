package inflearn.dfs_bfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P08_14 {

    public static class Point {

        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static List<Point> home;
    private static List<Point> pizzaStore;
    private static int[][] board;
    private static int[] combi;

    public static void solution(int curCombiIndex, int curValue) {
        if (curCombiIndex == combi.length) {
            // ((모든 집과 피자집의 거리) 중 최소 값)의 합 중 최소값을 구함
            for (Point h : home) {
                int distanceWithPizzaStore = 0;
                for (int i = 0; i < ; i++) {
                    
                }
            }
        }
        else {
            for (int i = curValue; i < combi.length; i++) {
                combi[curCombiIndex] = i;
                solution(curCombiIndex + 1, curValue + 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        board = new int[n + 1][n + 1];

        combi = new int[m];
        home = new ArrayList<>();
        pizzaStore = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                board[i][j] = sc.nextInt();
                if (board[i][j] == 1) {
                    home.add(new Point(i, j));
                }
                else if (board[i][j] == 2) {
                    pizzaStore.add(new Point(i, j));
                }
            }
        }
        solution(0, 0);
    }
}