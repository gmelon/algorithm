package inflearn.array;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P02_04 {

    public static String solution(int n) {
        int[] answer = new int[n];
        // 3 <= n <= 45 이므로
        answer[0] = 1;
        answer[1] = 1;
        for (int i = 2; i < n; i++) {
            answer[i] = answer[i - 1] + answer[i - 2];
        }
        return Arrays.toString(answer).replaceAll("[^0-9 ]", "");
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        System.out.println(solution(n));
    }

}
