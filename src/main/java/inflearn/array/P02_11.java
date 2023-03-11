package inflearn.array;

import java.util.Scanner;

public class P02_11 {

    public static int solution(int n, int[][] arr) {
        int answer = 0;
        int max = Integer.MIN_VALUE;

        // 학생 수 찾기
        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int j = 1; j <= n; j++) {
                if (i == j) continue; // 자기 자신과는 비교하지 않음
                for (int k = 1; k < 5; k++) {
                    if (arr[i][k] == arr[j][k]) {
                        count++;
                        break; // 전체 학년 (k)를 통틀어 한 번이라도 같은 반이 되었다면 그 한번만 카운트한다.
                    }
                }
            }
            if (count > max) {
                max = count;
                answer = i;
            }
        }
        return answer;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // 2차원 배열 입력받기
        int[][] arr = new int[n+1][6];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 5; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(solution(n, arr));
    }

}
