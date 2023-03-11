package inflearn.stack_queue;

import java.util.Scanner;
import java.util.Stack;

public class P05_05 {
    public static int solution(String str) {
        /* stack 사용 X 버전 */
//        int answer = 0;
//        int curNum = 0;
//
//        for (int i = 0; i < str.length(); i++) {
//            if (str.charAt(i) == '(' && str.charAt(i + 1) == ')') {
//                answer += curNum;
//                i += 1; // ignore ')'
//            } else if (str.charAt(i) == '(') {
//                curNum++;
//                answer++;
//            } else {    // str.charAt(i) == ')'
//                curNum--;
//            }
//        }
//        return answer;
//    }

        /* stack 사용 O 버전 */
        Stack<Character> stack = new Stack<>();
        int answer = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') stack.push('(');
            else {
                stack.pop(); // always '('
                if (str.charAt(i-1) == '(') answer += stack.size();
                else answer++;
            }
        }
        return answer;
    }


        public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(solution(str));
    }
}
