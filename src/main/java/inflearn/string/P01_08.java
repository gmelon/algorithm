package inflearn.string;

import java.util.Scanner;

public class P01_08 {

    public static String solution(String input) {
        // 1. lt, rt를 사용하는 방법
        /*
        input = input.toLowerCase(); // 대소문자 무시
        int lt = 0;
        int rt = input.length() - 1;
        while (lt < rt) {
            // 알파벳끼리만 팰린드롬 여부를 확인하므로 lt, rt 각각 알파벳이 나올 때 까지 이동
            if(!Character.isAlphabetic(input.charAt(lt))) lt++;
            else if (!Character.isAlphabetic(input.charAt(rt))) rt--;
            else {
                if (!(input.charAt(lt) == input.charAt(rt))) return "NO";
                else {
                    // 같은 경우 lt, rt 모두 이동시켜주어야 함에 주의하기!! -> 무한 반복됨..
                    lt++;
                    rt--;
                }
            }
        }
        // 모든 문자가 알파벳이 아니거나 팰린드롬이면 YES 반환
        return "YES";
        */

        // 2. replaceAll()을 사용하는 방법
        input = input.toLowerCase();
        // replaceAll 에는 정규식을 사용할 수 있다. (replace 는 불가)
        input = input.replaceAll("[^a-z]", ""); // 소문자 알파벳이 아니면 모두 "" 으로 replace
        String reversedInput = new StringBuilder(input).reverse().toString(); // 뒤집어서 같은지 비교
        if (!input.equals(reversedInput)) return "NO";
        else return "YES";
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(solution(input));
    }

}
