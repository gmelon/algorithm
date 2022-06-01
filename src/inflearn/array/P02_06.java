package inflearn.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P02_06 {

    public static String solution(int n, int[] intList) {
        List<Integer> answer = new ArrayList<>();

        for (int i : intList) {
            // i 뒤집기 -> StringBuilder 사용하지 말고 아래와 같이 몫/나머지 조작 방법 사용하기
            int reverseI = 0;
            while (i > 0) {
                reverseI = reverseI * 10 + i % 10;
                i = i / 10;
            }
            // 소수인지 판단하여 answer에 add
            if (isPrimeNum(reverseI)) answer.add(reverseI);
        }
        return answer.toString().replaceAll("[^0-9 ]", "");
    }

    // 소수인지 판별
    public static boolean isPrimeNum(int num) {
        if (num <= 1) return false;
        for (int i = 2; i < num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] intList = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.println(solution(n, intList));
    }

}
