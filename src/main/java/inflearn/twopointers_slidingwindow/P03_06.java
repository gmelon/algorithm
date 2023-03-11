package inflearn.twopointers_slidingwindow;

import java.util.Arrays;
import java.util.Scanner;

public class P03_06 {

    public static int solution(int n, int k, int[] arr) {
        // 기본적으로 1만을 더해가되, k번까지는 0을 포함해서 최대 길이를 계산하도록
        // lt를 제외할 때도 0을 뺴면 k++
        int answer = 0;
//        int curSum = 0;
        int remainK = k;
        int lt = 0;

//        for (int rt = 0; rt < n; rt++) {
//            if (arr[rt] == 1) {
//                curSum++;
//            } else {    // arr[rt] == 0
//                if (remainK > 0) {
//                    // 아직 바꿀 수 있는 0이 남음
//                    remainK--;
//                    curSum++;
//                } else {
//                    // 더 이상 바꿀 수 있는 0이 없음
//                    while (arr[lt] != 0) {
//                        lt++;
//                        curSum--;
//                    }
//                    lt++;
//                }
//            }
//            answer = Math.max(answer, curSum);
//        }

        for (int rt = 0; rt < n; rt++) {
            // curSum을 rt-lt+1 로 구함
            // 따라서, curSum++ 과정 필요 X
            // 오직 k 값 관련 처리 (arr[rt] == 0 일 경우)만 해주면 됨
            if (arr[rt] == 0) {
                if (remainK > 0) remainK--;
                else {
                    while(arr[lt] != 0) lt++;
                    lt++;
                }
            }
            answer = Math.max(answer, rt - lt + 1);
        }

        /* 모범 답안 */
//        int answer=0, cnt=0, lt=0;
//        for(int rt=0; rt<n; rt++){
//            if(arr[rt]==0) cnt++;
//            while(cnt>k){
//                if(arr[lt]==0) cnt--;
//                lt++;
//            }
//            answer=Math.max(answer, rt-lt+1);
//        }

        return answer;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        sc.nextLine(); // buffer clear
        int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(solution(n, k, arr));
    }
}