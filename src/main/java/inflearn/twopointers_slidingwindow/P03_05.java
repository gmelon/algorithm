package inflearn.twopointers_slidingwindow;

import java.util.Scanner;

public class P03_05 {

    public static int solution(int n) {
        int answer = 0, curSum = 0;
        int lt = 1;

        // 연속된 두 자연수의 합으로 n을 만드는 조건이므로
        // endIdx(마지막 자연수)가 n/2+1 일 때 까지만 확인하는 것으로 충분함
        for (int rt = 1; rt <= n / 2 + 1; rt++) {
            curSum += rt;
            if (curSum == n) answer++;
            while (curSum >= n) {
                curSum -= lt++; // curSum == n일 때 항상 실행됨
                if (curSum == n) answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(solution(n));
    }
}