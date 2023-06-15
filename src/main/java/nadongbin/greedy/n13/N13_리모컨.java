package nadongbin.greedy.n13;

import java.util.Scanner;

public class N13_리모컨 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println(solution(sc.nextInt(), sc.nextInt()));

        sc.close();
    }

    public static int solution(int a, int b) {

        int target = Math.abs(a - b);
        int[] temperatures = {10, 5, 1};

        int index = 0;
        int count = 0;
        while (target != 0) {
            // 가능한 온도가 1만 남으면 target 만큼 count가 증가
            if (index == temperatures.length - 1) {
                return count + Math.abs(target);
            }

            // 현재 혹은 다음 온도를 뺐을 때 절댓값이 더 작아지는 쪽으로 계산
            if (Math.abs(target - temperatures[index]) < Math.abs(target - temperatures[index + 1])) {
                count++;
                if (target > 0) {
                    target -= temperatures[index];
                } else {
                    target += temperatures[index];
                }
            } else {
                // 다음 온도가 더 최적해면 index 증가
                index++;
            }
        }

        return count;
    }

}
