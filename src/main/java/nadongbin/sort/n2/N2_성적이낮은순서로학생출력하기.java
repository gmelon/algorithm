package nadongbin.sort.n2;

import java.util.Arrays;
import java.util.Scanner;

public class N2_성적이낮은순서로학생출력하기 {

    static class Student implements Comparable<Student> {
        String name;
        int score;

        public Student(String name, int score) {
            this.name = name;
            this.score = score;
        }

        @Override
        public int compareTo(Student o) {
            return this.score - o.score;
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine(); // 개행 제거

        Student[] arr = new Student[N];
        for (int i = 0; i < N; i++) {
            String[] input = sc.nextLine().split(" ");
            arr[i] = new Student(input[0], Integer.parseInt(input[1]));
        }

        Arrays.sort(arr);

        for (Student student : arr) {
            System.out.print(student.name + " ");
        }
    }

}
