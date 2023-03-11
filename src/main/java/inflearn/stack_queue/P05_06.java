package inflearn.stack_queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P05_06 {
    public static int solution(int n, int k) {
        Queue<Integer> Q = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            Q.offer(i);
        }

        while (Q.size() > 1) {
            for (int i = 1; i < k; i++) Q.offer(Q.poll());
            Q.poll(); // k번째 원소 제거
        }
        return Q.poll();
    }


        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int k = sc.nextInt();
            System.out.println(solution(n, k));
    }
}
