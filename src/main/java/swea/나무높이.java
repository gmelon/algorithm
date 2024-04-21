package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 나무높이 {

    static class Node implements Comparable<Node> {
        int value;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return value - o.value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] arr = new int[N];
            int max = 0;
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                max = Math.max(max, arr[i]);
            }

            PriorityQueue<Node> maxPQ = new PriorityQueue<>(Comparator.reverseOrder());
            PriorityQueue<Node> minPQ = new PriorityQueue<>();

            for (int i = 0; i < N; i++) {
                if (max - arr[i] > 0) {
                    maxPQ.offer(new Node(max - arr[i]));
                    minPQ.offer(new Node(max - arr[i]));
                }
            }

            int step = 0;
            while (!maxPQ.isEmpty()) {
                // 완료된 애들 제거
                while (!maxPQ.isEmpty() && maxPQ.peek().value == 0) {
                    maxPQ.poll();
                }

                // 2먼저 제거
                if (!maxPQ.isEmpty() && maxPQ.peek().value >= 2) {
                    Node cur = maxPQ.poll();
                    cur.value -= 2;
                    if (cur.value > 0) {
                        maxPQ.offer(cur);
                    }
                    step++;
                }

                // 완료된 애들 제거
                while (!minPQ.isEmpty() && minPQ.peek().value == 0) {
                    minPQ.poll();
                }

                // 그다음 1 제거
                if (!minPQ.isEmpty()) {
                    Node cur = minPQ.poll();
                    cur.value -= 1;
                    if (cur.value > 0) {
                        minPQ.offer(cur);
                    }
                    step++;
                } else {
                    // 2에서 완료됐으므로 1일 추가
                    step++;
                }
            }

            sb.append("#").append(tc).append(" ").append(step).append("\n");
        }

        System.out.println(sb);
    }

}
