## 개요

- 탐색 → 많은 양의 데이터 중 원하는 데이터를 찾는 과정
    - 주로 그래프, 트리 등에 데이터가 담겨있다.
- BFS/DFS → 대표적인 탐색 알고리즘

## 자바에서의 Stack, Queue, Deque

### Stack

- java.util 패키지의 `Stack` 클래스 사용 가능
- LIFO 구조를 구현하고 있음

![image](https://github.com/gmelon/blog-post/assets/33623106/3fe1e7b5-83b5-49ee-af2b-34fb50e1ea70)

- 기본적으로 push, pop, peek 등을 지원하며 `AbstractList` 를 상속받기 때문에 List에서 가능한 연산들도 모두 지원함 (isEmpty, size, contains 등)
- 여담으로, Stack이 상속받는 Vector는 ArrayList와 유사하나 모든 메서드에 `syncronized`를 적용한다
    - 따라서, Stack의 모든 메서드는 쓰레드-안전 하다. (알고리즘 풀 땐 하등 필요없다)

### Queue

- java.util 패키지의 `LinkedList` 클래스 사용 가능
    - `Queue` 타입으로 선언 가능
    - FIFO 구조를 지원

![image](https://github.com/gmelon/blog-post/assets/33623106/613c447f-ff98-4f5a-bfc5-193e9ed3d7b4)

- offer, poll, peek 등을 지원하며 마찬가지로 AbstractList의 메서드도 사용 가능하다
- LinkedList 자료구조를 활용하기 때문에 Queue의 메서드들은 아래와 같이 동작한다
    - offer → tail에 원소 추가
    - poll → head의 원소 제거
    - peek → head의 원소 반환

### Deque(Double Ended Queue)

- 자바도 Deque를 지원한다.
    - 인터페이스 Queue를 확장하고 LinkedList 등에 의해 구현된다
    - LinkedList는 애초에 head와 tail에 대한 포인터를 모두 가지고 있다
- 기존 Queue의 메서드 외에 offerFirst, offerLast, pollLast, peekLast 등을 지원한다
- Queue를 확장하기 때문에 offer, peek, poll도 그대로 사용 가능하고,
    - 이는 각각 offerLast, peekFirst, pollFirst와 동일하다
    - LinkedList가 Queue를 구현할 때 tail로 삽입하고 head로 삭제되도록 설계되었기 때문
- 또한 head에 원소를 삽입하고 head에서 원소를 가져오는 push, pop (+ peek) 도 지원하기 때문에 원한다면 Deque를 **Stack 처럼 활용**할 수도 있다

## 재귀 함수

### 종료 조건

- 재귀 함수가 종료되는 조건
    - 명시하지 않으면 무한 루프
- 재귀 함수를 종료시키는데 사용할 변수와 목표 값 등을 가지고 있어야 함

### 점화식

- 재귀 함수는 동일한 동작을 수행하는 반복문보다 간단
    - 수학의 **점화식**을 그대로 코드로 옮길 수 있기 때문
- 점화식 → 특정한 함수를 **자신보다 더 작은 변수에 대한 함수와의 관계**로 표현한 것
    - e.g.) 팩토리얼의 경우
    - n == 0 || n == 1 → `f(n) = 1`
    - n > 1 → `f(n) = n * f(n - 1)`
- 점화식에서 **종료 조건**을 찾을 수 있음

### 스택

- 재귀 함수는 스택 구조를 사용하므로, 스택을 사용해 구현해야 하는 로직은 재귀 함수로도 구현 가능

![image](https://github.com/gmelon/blog-post/assets/33623106/4f97af0e-091a-47af-827d-cd3b4e5a69c2)

## 그래프

### 용어 정의

- 노드(node) == 정점(vertex)
- 간선(edge)
- 탐색 → 하나의 노드를 시작으로 다수의 노드를 방문
- 노드가 **인접** → 두 노드가 **간선으로 연결**됨

### 그래프의 표현

- 인접 행렬
    - 2차원 배열을 사용해 그래프를 표현

  ![image](https://github.com/gmelon/blog-post/assets/33623106/03ca6442-cc46-437d-8411-b80874f2551a)

- 인접 리스트
    - 자바 구현 예제

    ```java
    class Node {
    
        private int index;
        private int distance;
    
        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }
    }
    
    public class Main {
    
    		// 2차원 ArrayList를 사용
    		public static List<List<Integer>> graph = new ArrayList<>();
    
        public static void main(String[] args) {
    				// 외부 ArrayList에 내부 ArrayList를 넣는 과정
    				// 여기서 넣는 내부 ArrayList가 정점의 개수가 된다
            for (int i = 0; i < 3; i++) {
                graph.add(new ArrayList<Node>());
            }
    
            // 노드 0에 연결된 노드 정보 저장 (index, distance)
            graph.get(0).add(new Node(1, 7));
            graph.get(0).add(new Node(2, 5));
    
            // 노드 1 연결 노드
            graph.get(1).add(new Node(0, 7));
    
            // 노드 2 연결 노드
            graph.get(2).add(new Node(0, 5));
        }
    
    }
    
    // 출처 - https://github.com/ndb796/python-for-coding-test/blob/master/5/7.java
    ```

- 두 방식의 차이점
    - **간선 존재 유무 확인**
        - 인접 행렬 → 원하는 간선의 존재 유무를 한 번에 파악할 수 있음
        - 인접 리스트 → 각 정점의 ArrayList를 탐색해봐야 간선 존재 유뮤를 파악 가능
    - **메모리 사용 관점**
        - 인접 행렬 → 간선이 적더라도 정점 x 정점 크기의 배열이 필요
        - 인접 리스트 → 간선의 개수만큼만 메모리가 필요

## DFS

- **D**epth-**F**irst **S**earch / 깊이 우선 탐색
    - 그래프에서 **깊은 부분을 우선적**으로 탐색한다
- **스택** 자료구조 or 재귀를 사용

### 동작 과정

1. 탐색 시작 노드를 스택에 push 후 ‘방문 처리’
2. 스택 최상단 노드의 인접 노드를 스택에 push하고 ‘방문 처리’, 만약 더 이상 인접 노드가 없으면 최상단 노드를 꺼낸다
3. `2` 과정을 스택이 비게될 때 까지 반복

> 스택에 넣을 때 바로 방문 처리가 되어야 무한 루프에 빠지지 않는다
→ 계속해서 자신을 넣은 원인이 되는 노드를 다시 스택에 넣게 됨
>

### 자바 구현 (재귀)

```java
// (탐색 시작 노드, 그래프 객체, 방문 기록할 배열)
dfsRecursive(1, graph, new boolean[9]);

---

public static void dfsRecursive(Integer currentNode, List<List<Integer>> graph, boolean[] visited) {
    // 방문 처리
    visited[currentNode] = true;

    System.out.print(currentNode + " ");

    for (Integer neighbor : graph.get(currentNode)) {
        if (!visited[neighbor]) {
            dfsRecursive(neighbor, graph, visited);
        }
    }
}
```

### 자바 구현 (스택)

```java
public static void dfsStack(List<List<Integer>> graph) {
    Stack<Integer> stack = new Stack<>();
    boolean[] visited = new boolean[9];

    // 탐색 시작 노드 지정
    stack.push(1);
    visited[1] = true;

    while (!stack.isEmpty()) {
        Integer currentNode = stack.pop();

        System.out.print(currentNode + " ");

        for (Integer neighbor : graph.get(currentNode)) {
            if (!visited[neighbor]) {
                stack.push(neighbor);
                visited[neighbor] = true;
            }
        }
    }
}
```

## BFS

- **B**readth-**F**irst **S**earch / 너비 우선 탐색
    - 그래프에서 **가까운 노드를 우선**적으로 탐색한다
- **큐** 자료구조를 사용
    - FIFO이므로 자연스럽게 **먼저 들어온 노드가 먼저 나가게 되어** 가까운 노드부터 탐색이 진행된다
- 일반적으로 DFS보다 BFS가 더 빠르게 동작한다고 한다

### 동작 과정

1. 탐색 시작 노드를 큐에 offer하고 ‘방문 처리’
2. 큐에서 노드를 poll 하고 해당 노드의 인접 노드를 큐에 **모두** offer하면서 ‘방문 처리’
3. `2` 과정을 큐가 비게될 때 까지 반복

### 자바 구현 (큐)

```java
public static void bfs(List<List<Integer>> graph) {
    Queue<Integer> queue = new LinkedList<>();
    boolean[] visited = new boolean[9]; // 1 ~ 8

		// 탐색 시작 노드 지정
    queue.offer(1);
    visited[1] = true;

    while (!queue.isEmpty()) {
        Integer currentNode = queue.poll();

        System.out.print(currentNode + " ");

        for (Integer neighbor : graph.get(currentNode)) {
            if (!visited[neighbor]) {
                queue.offer(neighbor);
                visited[neighbor] = true;
            }
        }
    }
}
```
