package inflearn.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P01_11 {

    public static String solution(String input) {

        /*
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

         */

        // 단순히 [i]와 [i+1]을 비교하는 것으로, 문자열의 마지막에 " "을 추가하는 것으로 코드를 단순화할 수 있음
        // 이떄는 count가 1부터 시작해야 함
        String result = "";
        input = input + " "; // i+1을 항상 확인하므로 문자열의 뒤에 문자를 하나 더해줌
        int count = 1;
        for (int i = 0; i < input.length() - 1; i++) {
            if (input.charAt(i) == input.charAt(i + 1)) {
                // 다음 문자와 현재 문자가 같은 경우 단순히 count 만 증가
                count++;
            } else { // 다음 문자와 다른 경우
                result += input.charAt(i);
                if (count > 1) result += String.valueOf(count); // count의 경우 1보다 큰 경우에만 표시
                count = 1; // count 초기화
            }
        }
        return result;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(solution(input));
    }


}
