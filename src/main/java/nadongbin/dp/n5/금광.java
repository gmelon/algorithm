package nadongbin.dp.n5;

import java.util.ArrayList;
import java.util.Scanner;

public class 금광 {

    static class TestCase {
        int n, m;
        int[][] board;

        public TestCase(int n, int m) {
            this.n = n;
            this.m = m;
            this.board = new int[n][m];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        ArrayList<TestCase> testCases = new ArrayList<>();

        for (int t = 0; t < T; t++) {
            TestCase curTestCase = new TestCase(sc.nextInt(), sc.nextInt());
            for (int i = 0; i < curTestCase.n; i++) {
                for (int j = 0; j < curTestCase.m; j++) {
                    curTestCase.board[i][j] = sc.nextInt();
                }
            }
            testCases.add(curTestCase);
        }

        sc.close();

        for (TestCase testCase : testCases) {
            System.out.println(solution(testCase.n, testCase.m, testCase.board));
        }
    }

    public static int solution(int n, int m, int[][] board) {
        for (int j = 1; j < m; j++) { // 열 순회
            for (int i = 0; i < n; i++) { // 행 순회
                // 이전 열에서의 3가지 값 만들기
                int leftTop = 0;
                int left = 0;
                int leftBottom = 0;
                if (i - 1 >= 0) {
                    leftTop = board[i - 1][j - 1];
                }
                left = board[i][j - 1];
                if (i + 1 < n) {
                    leftBottom = board[i + 1][j - 1];
                }

                // 최대값으로 dp 테이블 채우기
                board[i][j] = board[i][j] + Math.max(leftTop, Math.max(left, leftBottom));
            }
        }

        int answer = 0;
        // 마지막 열 순회해서 최대값 찾기
        for (int i = 0; i < n; i++) {
            answer = Math.max(answer, board[i][m - 1]);
        }
        return answer;
    }

}
