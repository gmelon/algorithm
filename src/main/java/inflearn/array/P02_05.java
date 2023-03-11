package inflearn.array;

import java.util.Scanner;

public class P02_05 {

    public static int solution(int n) {
        int answer = 0;
        int[] arr = new int[n + 1]; // 소수 여부를 저장하는 배열, 소수이면 0으로 남는다
        for (int i = 2; i <= n; i++) {
            if (arr[i] == 0) {
                answer++;
                for (int j = i; j <= n; j = j + i) {
                    // j가 i만큼씩 증가하므로 j는 무조건 i의 배수!
                    // j를 1씩 증가시켜서 모두 비교하게 하면 time limit를 초과한다.
                    arr[j] = -1;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        System.out.println(solution(n));
    }

}
