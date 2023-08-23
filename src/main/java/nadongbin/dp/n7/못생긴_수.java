package nadongbin.dp.n7;

import java.util.PriorityQueue;
import java.util.Scanner;

public class 못생긴_수 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        // 풀이 시작
        PriorityQueue<Integer> numbers = new PriorityQueue<>();
        boolean[] visited = new boolean[100000];
        int[] primeNumbers = {2, 3, 5};

        numbers.offer(1);
        visited[1] = true;

        for (int i = 0; i < n - 1; i++) {
            Integer curNumber = numbers.poll();
            for (int primeNumber : primeNumbers) {
                int nextNumber = curNumber * primeNumber;
                if (!visited[nextNumber]) {
                    numbers.offer(nextNumber);
                    visited[nextNumber] = true;
                }
            }
        }
        System.out.println(numbers.poll());
    }

}
