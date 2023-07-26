import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    static class Bosuk {
        int weight;
        int price;
        public Bosuk(int weight, int price) {
            this.weight = weight;
            this.price = price;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        // 무게 기준 오름차순
        PriorityQueue<Bosuk> bosuksByWeight = new PriorityQueue<>(Comparator.comparingInt(a -> a.weight));
        for (int i = 0; i < N; i++) {
            bosuksByWeight.add(new Bosuk(sc.nextInt(), sc.nextInt()));
        }

        PriorityQueue<Integer> bagWeights = new PriorityQueue<>(Comparator.comparingInt(i -> i));
        for (int i = 0; i < K; i++) {
            bagWeights.add(sc.nextInt());
        }

        sc.close();

        // 풀이 시작

        long answer = 0L;
        PriorityQueue<Bosuk> bosuksByPrice = new PriorityQueue<>((a, b) -> b.price - a.price); // 가격 기준 내림차순
        // NlogN
        while (!bagWeights.isEmpty()) {
            int bagWeight = bagWeights.poll();
            // 현재 가방보다 무게가 작은 보석을 bosuksByPrice에 모두 넣음
            while (!bosuksByWeight.isEmpty() && bosuksByWeight.peek().weight <= bagWeight) {
                bosuksByPrice.offer(bosuksByWeight.poll());
            }
            if (!bosuksByPrice.isEmpty()) {
                answer += bosuksByPrice.poll().price;
            }
        }
        System.out.println(answer);
    }

}
