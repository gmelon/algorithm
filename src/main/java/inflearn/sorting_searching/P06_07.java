package inflearn.sorting_searching;

import java.util.Arrays;
import java.util.Scanner;

public class P06_07 {

    public static Point[] solution(int n, Point[] arr) {
        // 1 3
        // 2 5
        // 2 6
        // 과 같이 정렬한다. x 좌표 기준으로 먼저 정렬하고 x가 같을 경우 y를 기준으로 정렬
        // 배열을 두고 값을 tmp에 넣고 바꾸기?
        // 클래스를 만들고, compareTo 재정의하여 x, y 좌표 우선순위를 명시

        Arrays.sort(arr);
        return arr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // 주어진 크기만큼의 Point 배열 생성
        Point[] arr = new Point[n];
        for (int i = 0; i < n ; i++) {
            arr[i] = new Point(sc.nextInt(), sc.nextInt());
        }
        for (Point p : solution(n, arr)) {
            System.out.println(p);
        }
    }

    public static class Point implements Comparable<Point> {

        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            // x가 동일할 경우 y를 비교
            if (this.x == o.x) {
                return this.y - o.y;
            }
            return this.x - o.x;
        }

        @Override
        public String toString() {
            return x + " " + y;
        }
    }
}