package nadongbin.implementation.n4;

import java.util.*;

public class N4_게임개발 {

    // 북, 동, 남, 서 방향
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};

    // 왼쪽으로 회전
    public static int turnLeft(int direction) {
        direction -= 1;
        if (direction == -1) {
            return 3;
        }
        return direction;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        // 캐릭터의 초기 위치
        int currentX = sc.nextInt();
        int currentY = sc.nextInt();

        int direction = sc.nextInt(); // 캐릭터의 초기 방향
        int[][] visited = new int[50][50];
        visited[currentX][currentY] = 1; // 현재 좌표 방문 처리

        // 맵 정보 입력
        int[][] map = new int[50][50];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        // 시뮬레이션 시작
        int visitedCount = 1;
        int turnAttempt = 0;
        while (true) {
            // 왼쪽으로 회전
            direction = turnLeft(direction);
            // 회전 후 이동될 좌표 계산
            int nextX = currentX + dx[direction];
            int nextY = currentY + dy[direction];

            // 회전한 이후 정면에 가보지 않은 칸이 존재하는 경우 이동
            /**
             * visited == 0 -> 방문 X
             * map == 0 -> 육지
             */
            if (visited[nextX][nextY] == 0 && map[nextX][nextY] == 0) {
                // 이동 처리
                currentX = nextX;
                currentY = nextY;
                visited[nextX][nextY] = 1;

                visitedCount += 1; // 방문 횟수 카운트
                turnAttempt = 0; // 방문 시도 횟수 초기화
                continue;
            } else {
                //
                turnAttempt += 1;
            }

            // 4번 시도 후에도 이동이 불가능한 경우 (4방향이 모두 바다거나 방문한 좌표)
            if (turnAttempt == 4) {
                // 뒤가 이동 가능한 좌표인지 확인
                nextX = currentX - dx[direction];
                nextY = currentY - dy[direction];
                if (map[nextX][nextY] == 0) { // 육지이면
                    currentX = nextX;
                    currentY = nextY;

                    turnAttempt = 0;
                }
                else {
                    // 뒤가 바다인 경우 시뮬레이션 종료
                    break;
                }
            }
        }

        System.out.println(visitedCount);
    }

}
