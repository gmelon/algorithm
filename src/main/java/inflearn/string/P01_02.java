package inflearn.string;

import java.util.Scanner;

public class P01_02 {

    public static String solution(String str) {
        String answer = "";
        for (char c : str.toCharArray()) {
            if(Character.isLowerCase(c))
                answer +=  Character.toUpperCase(c);
            else
                answer += Character.toLowerCase(c);
            /* 아스키코드로 직접 비교 (65 -> A, 90 -> Z)
                if (c >= 65 && c <= 90)
                    answer += (char) (c-32);
                else
                    answer += (char) (c+32);
             */
        }
        return answer;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(solution(str));
    }

}
