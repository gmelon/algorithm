package inflearn.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class P09_01 {

    public static class Person implements Comparable<Person>{

        final int height;
        final int weight;

        public Person(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }

        @Override
        public int compareTo(Person o) {
            return o.height - this.height;
        }
    }

    public static int solution(int n, List<Person> personList) {
        int answer = 0;

        Collections.sort(personList);
        int max = Integer.MIN_VALUE;

        // height을 기준으로 내림차순 정렬했으므로, 몸무게가 이전 값보다 '커야만' 선발 기준에 부합
        for (Person person : personList) {
            if (person.weight > max) {
                max = person.weight;
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Person> personList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            personList.add(new Person(sc.nextInt(), sc.nextInt()));
        }
        System.out.println(solution(n, personList));
    }
}