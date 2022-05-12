package inflearn.string;

import java.util.Scanner;

public class P01_09 {

    public static int solution(String input) {
        /*
        int result = 0;
        // 숫자를 제외하고 삭제
        input = input.replaceAll("[^0-9]", "");
        // 자릿수에 맞춰 더하기
        int expo = input.length() - 1;
        for (int i = 0; i < input.length(); i++) {
            // 자바에서 ^는 XOR 비트 연산자임. Math.pow() 쓰기!
            result += Character.getNumericValue(input.charAt(i)) * (Math.pow(10, expo--));
        }
        return result;
        */

        // Character.isDigit() + Integer.parseInt() 조합을 사용할 수도 있다.
        // parseInt()를 하면 "0208" 과 같은 문자열을 208 이라는 정수로 바꿔준다.
        String result = "";
        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) result += c;
        }
        return Integer.parseInt(result);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(solution(input));
    }

}
