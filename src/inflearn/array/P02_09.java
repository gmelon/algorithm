package inflearn.array;

import java.util.Arrays;
import java.util.Scanner;

public class P02_09 {

    public static int solution(int n, int[][] arr) {
        int answer = Integer.MIN_VALUE;

        // 먼저 각 행, 열의 합에서 최대 값을 찾는다.
        int sumRow, sumCol;
        for (int i = 0; i < n; i++) {
            // 각 행, 열의 합계 초기화
            sumRow = 0;
            sumCol = 0;
            // 한번에 행과 열의 합계를 같이 구한다.
            // 반복하며 어떤 변수가 변하느냐에 따라 행, 열 여부가 결정된다.
            for (int j = 0; j < n; j++) {
                sumRow += arr[i][j];
                sumCol += arr[j][i];
            }
            // 세 값 중에 가장 큰 값을 answer로 선택한다.
            answer = Math.max(sumCol, Math.max(answer, sumRow));
        }
        // 마지막으로 대각선의 합을 구한다.
        int sumA = 0, sumB = 0;
        for (int i = 0; i < n; i++) {
            sumA += arr[i][i];
            sumB += arr[i][n - i - 1];
        }
        // 세 값 중에 가장 큰 값을 answer로 선택한다.
        answer = Math.max(sumA, Math.max(answer, sumB));
        return answer;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // 2차원 배열 입력받기
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(solution(n, arr));
    }

}
