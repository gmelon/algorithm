package inflearn.array;

import java.util.Scanner;

public class P02_12 {

    public static int solution(int n, int m, int[][] arr) {
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int cnt = 0;
                for (int problem = 0; problem < m; problem++) {
                    int idxOfI = 0;
                    int idxOfJ = 0;
                    for (int score = 0; score < n; score++) {
                        if (arr[problem][score] == i) idxOfI = score;
                        if (arr[problem][score] == j) idxOfJ = score;
                    }
                    if (idxOfI < idxOfJ) cnt++;
                }
                if (cnt == m) answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 학생 수
        int m = sc.nextInt(); // 수학테스트 횟수
        // 2차원 배열 입력받기
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(solution(n, m, arr));
    }

}
