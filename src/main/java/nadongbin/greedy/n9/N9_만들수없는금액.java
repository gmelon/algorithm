package nadongbin.greedy.n9;

import java.util.Arrays;
import java.util.Scanner;

public class N9_만들수없는금액 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();

        System.out.println(solution(N, arr));
    }

    public static int solution(final int N, final int[] coins) {

        Arrays.sort(coins);

        int nextAvailableValue = 1;
        for (int coin : coins) {
            if (coin > nextAvailableValue) {
                return nextAvailableValue;
            } else {
                nextAvailableValue += coin;
            }
        }
        return nextAvailableValue;
    }

}
