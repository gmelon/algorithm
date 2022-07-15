package inflearn.stack_queue;

import java.util.*;

public class P05_08 {

    public static class Person implements Comparable<Person> {
        int id;
        int priority;

        public Person(int id, int priority) {
            this.id = id;
            this.priority = priority;
        }

        @Override
        public int compareTo(Person o) {
            // DESC order
            return o.priority - this.priority;
        }
    }

    public static int solution(int n, int m, int[] arr) {
        /* 우선순위 큐 사용하여 우선순위 확인 */
//        int cnt = 0;
//
//        // priority와 id(m과 비교)를 동시에 갖는 클래스를 생성하여 Queue에 삽입..!
//        Queue<Person> Q = new LinkedList<>();
//        Queue<Person> PQ = new PriorityQueue<>();
//
//        // init
//        for (int i = 0; i < n; i++) {
//            Person tmp = new Person(i, arr[i]);
//            Q.offer(tmp);
//            PQ.offer(tmp); // priority 기준으로 내림차순 정렬되며 저장
//        }
//
//        while (!Q.isEmpty()) {
//            Person tmp = Q.poll();
//            if (tmp.priority == PQ.peek().priority) {
//                // 치료
//                cnt++;
//                PQ.poll();
//                if (tmp.id == m) return cnt;
//            } else Q.offer(tmp);       // 다시 Q에서 대기
//        }
//        return cnt; // never reachable

        /* for-loop으로 순회하여 직접 우선순위 확인 */
        int cnt = 0;

        // priority와 id(m과 비교)를 동시에 갖는 클래스를 생성하여 Queue에 삽입..!
        Queue<Person> Q = new LinkedList<>();

        // init
        for (int i = 0; i < n; i++) Q.offer(new Person(i, arr[i]));

        while (!Q.isEmpty()) {
            Person tmp = Q.poll();
            for (Person p : Q) {
                if (p.priority > tmp.priority) {
                    // 현재 환자보다 우선순위가 높은 환자가 있다면
                    Q.offer(tmp);   // 다시 대기
                    tmp = null; // 현재 환자는 치료하지 않음
                    break;
                }
            }
            if (tmp != null) {
                // 현재 환자가 치료 가능한 환자라면
                cnt++;
                if (tmp.id == m) return cnt;
            }
        }
        return cnt; // never reachable

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
