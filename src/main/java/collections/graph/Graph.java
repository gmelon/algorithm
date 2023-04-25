package collections.graph;

import lombok.Builder;

public class Graph {

    public final int a;
    public final int b;
    private int c;
    private int d;
    private int e;

    @Builder
    public Graph(int a, int b, int c, int d, int e) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
    }

    public static void main(String[] args) {
        Graph build = Graph.builder()
            .b(1)
            .build();

        System.out.println(build.a);
        System.out.println(build.b);
    }

}
