package inflearn.stack_queue;

import java.util.*;

public class P05_08 {
    public static String solution(int n, int m, int[] arr) {
        Queue<Integer> Q = new LinkedList<>();
        Queue<Integer> PQ = new PriorityQueue<>();
        for (int i : arr) {
            Q.offer(i);
            PQ.offer(i);
        }


    }

        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int m = sc.nextInt();
            sc.nextLine();
            int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            System.out.println(solution(n, m, arr));
    }
}
