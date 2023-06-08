package nadongbin.greedy.n7;

import java.util.Scanner;

public class N7_곱하기혹은더하기 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.next();
        sc.close();

        System.out.println(solution(S));
    }

    public static int solution(final String S) {
        int answer = S.charAt(0) - '0';

        for (int i = 1; i < S.length(); i++) {
            int curVal = S.charAt(i) - '0';
            if (answer == 0 || answer == 1 || curVal == 0 || curVal == 1) {
                answer += curVal;
            } else {
                answer *= curVal;
            }
        }
        return answer;
    }

}
