package nadongbin.greedy;

public class N4_1이될때까지 {

    public static void main(String[] args) {
        System.out.println(solution(25, 3));
    }

    public static int solution(int N, final int K) {
        int answer = 0;
        while (N >= K) {
            answer += N % K; // 1만큼 뺄 수
            N -= N % K; // N에서 빼야되는 만큼 1을 빼주기
//            if (N < K) {
//                // 더 이상 나눌 수 없으면 break
//                break;
//            }
            N /= K;
            answer++;
        }
        answer += N - 1; // 1 < N < K 인 경우 나머지를 모두 뺴준다
        return answer;
    }

}
