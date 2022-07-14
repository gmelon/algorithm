package inflearn.stack_queue;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class P05_03 {
    public static int solution(int n, int[][] board, int m, int[] moves) {
        int answer = 0;

        // stack 만들기
        List<Stack<Integer>> stacks = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Stack<Integer> tmp = new Stack<>();
            for (int j = n - 1; j >= 0; j--) {
                if (board[j][i] == 0) break;
                tmp.push(board[j][i]);
            }
            stacks.add(tmp);
        }

        Stack<Integer> bucket = new Stack<>();
        for (int i : moves) {
            if (!stacks.get(i-1).isEmpty()){
                int newItem = stacks.get(i - 1).pop();
                if (!bucket.isEmpty() && bucket.peek() == newItem) {
                    bucket.pop();
                    answer += 2;
                } else bucket.push(newItem);
            }
        }
        return answer;
//        int answer=0;
//        Stack<Integer> stack = new Stack<>();
//        for(int pos : moves){
//            for(int i=0; i<board.length; i++){
//                if(board[i][pos-1]!=0){
//                    int tmp=board[i][pos-1];
//                    board[i][pos-1]=0;
//                    if(!stack.isEmpty() && tmp==stack.peek()){
//                        answer+=2;
//                        stack.pop();
//                    }
//                    else stack.push(tmp);
//                    break;
//                }
//            }
//        }
//        return answer;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        int m = sc.nextInt();
        int[] moves = new int[m];
        for (int i = 0; i < m; i++) {
            moves[i] = sc.nextInt();
        }
        System.out.println(solution(n, board, m, moves));
    }
}
