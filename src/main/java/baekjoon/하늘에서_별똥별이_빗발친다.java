package baekjoon;

import java.util.Scanner;

public class 하늘에서_별똥별이_빗발친다 {

    static class Position {
        int x, y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 별똘별 낙하 가로
        int M = sc.nextInt(); // 뼐똥별 낙하 세로
        int L = sc.nextInt(); // 트램펄린 한 변
        int K = sc.nextInt();

        Position[] positions = new Position[K]; // 병똘별이 떨어지는 위치의 좌표
        for (int i = 0; i < K; i++) {
            positions[i] = new Position(sc.nextInt(), sc.nextInt());
        }
        sc.close();

        // 풀이 시작

    }

}
