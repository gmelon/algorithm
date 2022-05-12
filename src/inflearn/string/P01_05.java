package inflearn.string;

import java.util.Scanner;

public class P01_05 {

    public static String solution(String input) {
        // 문자열 swap을 위해서는 문자열을 배열로 만들어야 함
        char[] charArray = input.toCharArray();
        int lt = 0;
        int rt = charArray.length - 1;
        while (lt < rt) {
            // 각각의 문자가 알파벳이 될 때 까지 전진
            // 알파벳 여부 판단에는 Character.isAlphabetic 메서드 활용
            while(lt < charArray.length && !Character.isAlphabetic(charArray[lt])) lt++;
            while(rt >= 0 && !Character.isAlphabetic(charArray[rt])) rt--;
            // 두 char이 모두 알파벳인 경우에만 swap
            char temp = charArray[lt];
            charArray[lt] = charArray[rt];
            charArray[rt] = temp;
            // swap 후 다음 문자 확인
            lt++;
            rt--;
        }
        return String.valueOf(charArray);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(solution(input));
    }

}
