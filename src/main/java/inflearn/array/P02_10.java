package inflearn.array;

import java.util.Scanner;

public class P02_10 {

    public static int solution(int n, int[][] arr) {
        int answer = 0; // 봉우리 개수
        // 상하좌우 탐색할 index를 미리 정해놓는다. -> for-loop으로 간단하게 처리가능
        int[] dx = {0, 0, 1, -1};
        int[] dy = {-1, 1, 0, 0};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                /*
                // 전체를 순회하며 상하좌우보다 값이 큰 원소를 카운트한다.
                // 각 인덱스가 가장자리에 위치하면 항상 봉우리가 될 가능성이 있으므로 이 경우 바로 다음 조건을 검사한다.
                if (i-1 >= 0 && arr[i][j] <= arr[i-1][j]) continue;
                if (i+1 < n && arr[i][j] <= arr[i+1][j]) continue;
                if (j-1 >= 0 && arr[i][j] <= arr[i][j-1]) continue;
                if (j+1 < n && arr[i][j] <= arr[i][j+1]) continue;

                // 여기에 도달하면 arr[i][j]는 봉우리다.
                answer++;
                 */
                boolean flag = true;
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if(nx >= 0 && nx < n && ny >= 0 && ny < n && arr[nx][ny] >= arr[i][j]) {
                        flag = false;
                        break; // 하나라도 크거나 같다면 이미 arr[i][j]는 봉우리가 아님
                    }
                }
                if (flag) answer++;
            }
        }
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
