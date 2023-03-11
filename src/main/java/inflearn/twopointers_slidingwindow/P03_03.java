package inflearn.twopointers_slidingwindow;

import java.util.Arrays;
import java.util.Scanner;

public class P03_03 {

    public static int solution(int n, int k, int [] arr) {
        int answer, curSum = 0;
        // 최초 k개 원소의 sum으로 answer init
        for (int i = 0; i < k; i++) {
            curSum += arr[i];
        }
        answer = curSum;
        // max sum 구하기
        for (int i = k; i < n; i++) {
            curSum += (arr[i] - arr[i - k]); // calc sliding window
            answer = Math.max(curSum, answer);
        }
        return answer;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        sc.nextLine(); // buffer clear

        int [] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(solution(n, k, arr));
    }
}