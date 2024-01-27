package baekjoon.bruteforce;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 감시 {

    static final int EMPTY = 0; // 빈공간
    static final int WALL = 6; // 벽

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static int minZeroCount = Integer.MAX_VALUE;

    static List<Camera> cameras;

    static class Camera {
        int x, y;
        int type;
        int direction;

        public Camera(int x, int y, int type, int direction) {
            this.x = x;
            this.y = y;
            this.type = type;
            this.direction = direction;
        }

        public Camera(Camera camera) {
            this.x = camera.x;
            this.y = camera.y;
            this.type = camera.type;
            this.direction = camera.direction;
        }

        public void rotateDirection() {
            direction = (direction + 1) % 4;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int M = sc.nextInt();
        int[][] arr = new int[N][M];
        cameras = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = sc.nextInt();
                if (arr[i][j] >= 1 && arr[i][j] <= 5) {
                    cameras.add(new Camera(i, j, arr[i][j], 0));
                }
            }
        }
        sc.close();

        // 풀이 시작
        find(0, arr);

        System.out.println(minZeroCount);
    }

    static void find(int currentCameraIndex, int[][] arr) {
        if (currentCameraIndex == cameras.size()) {
            // 개수 확인
            int zeroCount = 0;
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[0].length; j++) {
                    if (arr[i][j] == EMPTY) {
                        zeroCount++;
                    }
                }
            }
            minZeroCount = Math.min(minZeroCount, zeroCount);
            return;
        }

        // 현재 카메라를 4방향으로 돌리면서 맵 변경


        // 각 방향에 대하여
        // 변경된 맵을 복사하고 다음 카메라 호출
        // 4방향이 모두 종료되면, 현재 카메라 위치 원복 (이전 호출에 대비)
    }

}
