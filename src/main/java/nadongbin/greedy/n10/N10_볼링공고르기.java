package nadongbin.greedy.n10;

import java.util.Arrays;
import java.util.Scanner;

public class N10_볼링공고르기 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();

        System.out.println(solution(N, M, arr));
    }

    public static int solution(final int N, final int M, final int[] arr) {
        int answer = 0;

        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            int count = arr.length - i - 1;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] == arr[i]) {
                    count--;
                } else {
                    break;
                }
            }
            answer += count;
        }

        return answer;
    }

}
