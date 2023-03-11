package inflearn.stack_queue;

import java.util.Scanner;
import java.util.Stack;

public class P05_02 {
    public static String solution(String str) {
        String answer = "";
        Stack<Character> stack = new Stack<>();

//        for (char c : str.toCharArray()) {
//            if (c == '(') stack.push(c);
//            else if (c == ')') stack.pop();
//            else {
//                // 일반 문자인 경우 스택이 비어있을 경우에만 answer에 concat
//                if (stack.isEmpty()) {
//                    answer += c;
//                }
//            }
//        }
        for (char c : str.toCharArray()) {
            if (c == ')') {
                while (stack.pop() != '('); // stack에서 '('를 pop하기 전까지 계속해서 원소를 pop
            } else stack.push(c);
        }
        for (char c : stack) {
            answer += c;
        }
        return answer;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(solution(str));
    }
}
