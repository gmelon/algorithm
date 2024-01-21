package baekjoon.two_pointer;

import java.util.Arrays;
import java.util.Scanner;

public class 두수의합 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] numbers = new int[n];
        int x = sc.nextInt();
        sc.close();

        Arrays.sort(numbers);

        int left = 0;
        int right = 1;

        int answer = 0;

        while (right < numbers.length && left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == x) {
                answer++;
                right++;
            } else if (sum < x) {
                left++;
            } else {
                right++;
            }
        }

        System.out.println(answer);
    }

}
