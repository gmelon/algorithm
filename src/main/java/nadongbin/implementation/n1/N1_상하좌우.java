package nadongbin.implementation.n1;

import java.util.Arrays;
import java.util.Scanner;

public final class N1_상하좌우 {

    private static class Position {
        // 시작 좌표 - 좌측 상단 [1, 1]
        int x = 1, y = 1;
        int N;

        public Position(int N) {
            this.N = N;
        }

        public void move(String route) {
            switch (route) {
                case "L":
                    validateAndMove(x, y - 1);
                    break;
                case "R" :
                    validateAndMove(x, y + 1);
                    break;
                case "U" :
                    validateAndMove(x - 1, y);
                    break;
                case "D":
                    validateAndMove(x + 1, y);
                    break;
            }
        }

        private void validateAndMove(int x, int y) {
            if (x >= 1 && x <= N && y >= 1 && y <= N) {
                this.x = x;
                this.y = y;
            }
        }

        @Override
        public String toString() {
            return x + " " + y;
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());

        String[] route = sc.nextLine().split(" ");

        System.out.println(Arrays.toString(route));

        System.out.println(solution(N, route));
    }

    public static String solution(final int N, final String[] route) {
        Position position = new Position(N);
        for (String r : route) {
            position.move(r);
        }
        return position.toString();
    }
}
