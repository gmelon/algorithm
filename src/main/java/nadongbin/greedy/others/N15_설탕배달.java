package nadongbin.greedy.others;

import java.util.Scanner;

public class N15_설탕배달 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println(solution(sc.nextInt()));

        sc.close();
    }

    public static int solution(int N) {
        int count = 0;
        while (N > 0) {
            count++;
            N -= 3;

            if (N % 5 == 0) {
                return count + N / 5;
            }
        }
        if (N == 0) {
            return count;
        } else {
            return -1;
        }
    }

}
