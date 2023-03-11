package inflearn.string;

import java.util.Scanner;

public class P01_03 {

    public static String solution(String str) {
        String answer = "";
//        1. split() 사용
        int maxLen = Integer.MIN_VALUE;
        String[] splitStr = str.split(" ");
        for (String s : splitStr) {
            if (maxLen < s.length()) {
                maxLen = s.length();
                answer = s;
            }
        }

        // 2. indexOf(), substring 사용
//        int maxLen = Integer.MIN_VALUE;
//        int pos; // 공백의 위치를 저장
//        while ((pos = str.indexOf(" ")) != -1) {
//            String tmp = str.substring(0, pos);
//            if (maxLen < tmp.length()) {
//                maxLen = tmp.length();
//                answer = tmp;
//            }
//            str = str.substring(pos+1); // end 인자 없으면 끝까지
//        }
//        if (maxLen < str.length()) { // 마지막 str 체크 (while문에서는 더 이상 공백 없으므로 무시됨)
//            answer = str;
//        }
        return answer;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine(); // nextLine은 개행을 기준으로, next는 공백을 기준으로 넘겨줌
        System.out.println(solution(str));
    }

}
