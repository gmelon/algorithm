package inflearn.string;

import java.util.ArrayList;
import java.util.Scanner;

public class P01_04 {

    public static ArrayList<String> solution(String[] strArray) {
        // 1. StringBuilder 사용 방법 (reverse 메서드 사용)
        ArrayList<String> answer = new ArrayList<>();
        for (String s : strArray) {
            StringBuilder stringBuilder = new StringBuilder(s);
            answer.add(stringBuilder.reverse().toString());
        }
        /*  2. 직접 뒤집는 방법 (toCharArray(), two point index 사용)
         *  ArrayList<String> answer = new ArrayList<>();
         *  for (String x : str) {
         *      char[] c = x.toCharArray();
         *      int lt = 0, rt = c.length()-1; // two point index
         *      while (lt < rt) {
         *          // swap
         *          char temp = c[lt];
         *          c[lt] = c[rt];
         *          c[rt] = temp;
         *          lt ++; rt --;
         *      } // while-loop end
         *      answer.add(String.valueOf(c)); // String의 static 메서드 valueOf, char 배열을 String으로 생성
         * } // for-loop end
         */
        return answer;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] strArray = new String[n];
        for (int i = 0 ; i < n ; i++) {
            strArray[i] = sc.nextLine();
        }
        for (String s : solution(strArray)) {
            System.out.println(s);
        }
    }

}
