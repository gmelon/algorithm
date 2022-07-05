package inflearn.array;

import java.util.Arrays;
import java.util.Scanner;

public class P02_12 {

    public static int solution(int n, int m, int[][] arr) {
        int answer = 0;

        for (int i = 0; i < n; i++) {
            boolean flag = true;
            for (int j = 0; j < n; j++) {

            }
            if (flag) answer++;
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 학생 수
        int m = sc.nextInt(); // 수학테스트 횟수
        // 2차원 배열 입력받기
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(solution(n, m, arr));
    }

}
