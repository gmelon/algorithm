package inflearn.array;

import java.util.Arrays;
import java.util.Scanner;

public class P02_03 {

    public static char[] solution(int n, int[] a, int[] b) {
        char[] answer = new char[n];
        for (int i = 0; i < n; i++) {
            // 비긴 경우
            if (a[i] == b[i]) answer[i] = 'D';
            // A가 가위로 이김
            else if (a[i] == 1 && b[i] == 3) answer[i] = 'A';
            // A가 바위로 이김
            else if (a[i] == 2 && b[i] == 1) answer[i] = 'A';
            // A가 보자기로 이김
            else if (a[i] == 3 && b[i] == 2) answer[i] = 'A';
            // 나머지 B가 이기는 경우
            else answer[i] = 'B';
        }
        return answer;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        // nextLine()을 받아 split하여 String 배열 생성 후 int[]로 mapping
        int[] a = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] b = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        char[] answer = solution(n, a, b);
        for (char c : answer) {
            System.out.println(c);
        }
    }

}
