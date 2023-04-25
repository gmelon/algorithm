package collections.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class GraphAlgorithms {

    // Graph 표현을 위한 Node
    static class Node {
        Integer data;
        List<Node> edges = new LinkedList<>();
        boolean visited;

        public Node(int data) {
            this.data = data;
        }

        // link() 메서드를 통해 현재 노드에 이웃한 Node를 추가
        public void link(Node node) {
            this.edges.add(node);
        }

        // 양방향 연관관계 추가
        public void linkBiderectional(Node node) {
            this.link(node);
            node.link(this);
        }

        // 방문 여부 체크, 확인 관련
        public void visit() {
            this.visited = true;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

//    static class Graph {
//
//        int[][] matrix;
//        boolean[] visited;
//
//        public Graph(int size) {
//            this.matrix = new int[size + 1][size + 1];
//            this.visited = new boolean[size + 1];
//        }
//
//        public void link(int vertexA, int vertexB) {
//            matrix[vertexA][vertexB] = 1;
//        }
//
//        public void linkBidirectional(int vertexA, int vertexB) {
//            link(vertexA, vertexB);
//            link(vertexB, vertexA);
//        }
//
//        public void visit(int vertex) {
//            visited[vertex] = true;
//        }
//
//    }

    // BFS (Queue 사용)
    public static void bfs(Node head, Integer target) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(head);

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            // 현재 노드 방문 처리
            currentNode.visit();
            System.out.println(currentNode);

            // 타겟 여부 확인
            if (currentNode.data == target) {
                System.out.println("Target 발견 : " + currentNode.data);
                break;
            }

            // 이웃 노드 Queue에 삽입
            for (Node node : currentNode.edges) {
                if (!node.visited && !queue.contains(node)) {
                    queue.offer(node);
                }
            }
        }
    }

    // DFS (Stack 사용)
    public static void dfsStack(Node head, Integer target) {
        Stack<Node> stack = new Stack<>();
        stack.push(head);

        while (!stack.isEmpty()) {
            Node currentNode = stack.pop();
            // 현재 노드 방문 처리
            currentNode.visit();
            System.out.println(currentNode);

            // 타겟 여부 확인
            if (currentNode.data == target) {
                System.out.println("Target 발견 : " + currentNode.data);
                break;
            }

            // 이웃 노드 Stack에 삽입
            for (Node node : currentNode.edges) {
                if (!node.visited && !stack.contains(node)) {
                    stack.push(node);
                }
            }
        }
    }

    // DFS (재귀 사용)
    public static void dfsRecursion(Node head, Integer target) {
        // 현재 노드 방문 처리
        head.visit();
        System.out.println(head);

        // 타겟 여부 확인
        if (head.data == target) {
            System.out.println("Target 발견 : " + head.data);
        }

        // 이웃 노드 호출
        for (Node node : head.edges) {
            if (!node.visited) {
                dfsRecursion(node, target);
            }
        }
    }

    public static void main(String[] args) {
        // graph 구성
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);

        node1.linkBiderectional(node2);
        node1.linkBiderectional(node3);

        node2.linkBiderectional(node4);
        node2.linkBiderectional(node5);

        node3.linkBiderectional(node6);
        node3.linkBiderectional(node7);


        // dfs, dfs 호출
//        bfs(node1, 7);
        dfsRecursion(node1, 7);
    }


}
