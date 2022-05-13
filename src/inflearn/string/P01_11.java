package inflearn.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P01_11 {

    public static String solution(String input) {
        String result = "";

        int count = 0;
        char prevChar = '0'; // 초기값

        for (char c : input.toCharArray()) {
            if (prevChar != c) { // 새로운 문자가 나타난 경우
                // 지금까지의 누적을 result로 출력
                // count가 1이면 문자만 출력
                if (count == 1) result += prevChar;
                // 초기 값이 아닌 경우 (일반적인 경우)
                else if (count != 0) result += prevChar + String.valueOf(count);
                prevChar = c; // 이전 문자를 현재 문자로 초기화
                count = 1; // count는 다시 1부터 시작
            } else { // 기존 문자가 다시 나타난 경우
                count++;
            }
        }
        // 마지막 문자가 생략되지 않도록 더해주기
        // 지금까지의 누적을 result로 출력
        if (count == 1) result += prevChar;
        else result += prevChar + String.valueOf(count);

        return result;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(solution(input));
    }


}
