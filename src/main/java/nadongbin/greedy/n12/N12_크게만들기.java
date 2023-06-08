package nadongbin.greedy.n12;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class N12_크게만들기 {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        String text = sc.next();
        String answer = "";

        Stack<Integer> stack = new Stack<>();
        int count = 0;
        for (int i = 0; i < N; i++) {
            int num = text.charAt(i) - '0';

            if (!stack.isEmpty()) {
                while (!stack.isEmpty() && count < K) {
                    if (stack.peek() < num) {
                        stack.pop();
                        count++;
                    } else {
                        break;
                    }
                }
            }

            stack.push(num);

            if (count == K) {
                answer += text.substring(i + 1);
                break;
            }
        }

        while (!stack.isEmpty()) {
            int num = stack.pop();
            if (count < K) {
                count++;
                continue;
            }
            answer = num + answer;
        }

        System.out.println(answer);
    }

}
