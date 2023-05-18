package programmers;

import java.util.Comparator;
import java.util.PriorityQueue;

public class P42891 {

    static class Food {

        long index;
        int leftTime;

        Food(long index, int leftTime) {
            this.index = index;
            this.leftTime = leftTime;
        }
    }

    public int solution(int[] food_times, long k) {
        PriorityQueue<Food> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.leftTime));

        for (int i = 0; i < food_times.length; i++) {
            queue.offer(new Food(i + 1, food_times[i]));
        }

        long pre = 0;
        while (!queue.isEmpty()) {
            Food current = queue.peek();

            long minusValue = (current.leftTime - pre) * queue.size();

            if (minusValue <= k) {
                pre = queue.poll().leftTime;
                k -= minusValue;
                while (!queue.isEmpty() && queue.peek().leftTime == current.leftTime) {
                    queue.poll();
                }
            }
            else if (minusValue > k) {
                PriorityQueue<Food> indexQueue = new PriorityQueue<>((o1, o2) -> (int) (o1.index - o2.index));

                for (Food food : queue) {
                    indexQueue.offer(food);
                }

                long answer = 0;
                long iterSize = k % indexQueue.size();
                for (long i = 0; i <= iterSize; i++) {
                    answer = indexQueue.poll().index;
                }
                return (int) answer;
            }
        }
        return -1;
    }

}
