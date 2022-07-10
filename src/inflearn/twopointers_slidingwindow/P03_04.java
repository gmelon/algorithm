package inflearn.twopointers_slidingwindow;

import java.util.Arrays;
import java.util.Scanner;

public class P03_04 {

    public static int solution(int n, int m, int [] arr) {
        int answer = 0;
        int startIdx = 0;
        int curSum = 0;
        for (int endIdx = 0; endIdx < n; endIdx++) {
            curSum += arr[endIdx];
            if (curSum == m) answer++;
            while (curSum >= m) {
                curSum -= arr[startIdx++];
                if (curSum == m) answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine(); // buffer clear

        int [] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(solution(n, m, arr));
    }
}