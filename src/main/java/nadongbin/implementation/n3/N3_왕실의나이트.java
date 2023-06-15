package nadongbin.implementation.n3;

import java.util.List;
import java.util.Scanner;

public class N3_왕실의나이트 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        sc.close();

        System.out.println(solution(input));
    }

    public static int solution(final String input) {
        int x = Character.getNumericValue(input.charAt(1));
        int y = List.of('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h').indexOf(input.charAt(0));

        int[] dx = {-2, 2, -2, 2, 1, -1, 1, -1};
        int[] dy = {1, 1, -1, -1, 2, 2, -2, -2};

        int count = 0;
        for (int i = 0; i < dx.length; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (nextX >= 1 && nextX <= 8 && nextY >= 1 && nextY <= 8) {
                count++;
            }
        }
        return count;
    }

}
