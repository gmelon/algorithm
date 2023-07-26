# 순차 탐색

- 앞에서 부터 하나씩 원소를 확인하며 찾고자 하는 원소를 탐색한다
    - 시간 복잡도 - 최대 N개의 원소 모두를 한번씩 확인해야 하므로 O(N)

# 이진 탐색

- 내부 데이터가 정렬되어 있을 때만 사용 가능
- 탐색 범위를 절반씩 좁혀가며 데이터를 탐색한다
- 시작점, 중간점, 끝점을 잡고 확인하려는 데이터와 비교했을 때 중간점이 더 큰지, 작은지, 같은지를 비교한다
    - 중간점 = (시작점 + 끝점) / 2 이며 나머지는 버림한다
    - ex) start = 0, end = 9 → mid = 4 (4.5 에서 0.5 버림)

![image](https://github.com/gmelon/algorithm_problems/assets/33623106/b14b7eb1-e2ed-49ff-89a9-a27a4ef8eeed)

![image](https://github.com/gmelon/algorithm_problems/assets/33623106/9caefdaa-e468-4a86-970f-b4cbfbac2aa7)

![image](https://github.com/gmelon/algorithm_problems/assets/33623106/7371147e-855f-4b61-8fbb-d470098fe786)

## 시간 복잡도

- 매 탐색 마다 최선의 경우 데이터가 1/2로 줄어들기 때문에 전체 연산 횟수는 밑이 2인 logN이고, 따라서 시간 복잡도는 O(logN)이라고 할 수 있다.

## 구현

### 재귀 함수

```java
public static void main(String[] args) {
    System.out.println(recursiveBinarySearch(new int[]{1, 4, 6, 10, 15, 22, 26, 30, 31}, 15, 0, 8));
}

public static int recursiveBinarySearch(int[] arr, int target, int start, int end) {
    if (start > end) {
        return -1;
    }
    int mid = (start + end) / 2;

    if (arr[mid] == target) {
        return mid;
    }
    if (arr[mid] < target) {
        return recursiveBinarySearch(arr, target, mid + 1, end);
    } else {
        return recursiveBinarySearch(arr, target, start, mid - 1);
    }
}
```

### 반복문

```java
public static void main(String[] args) {
    System.out.println(loopBinarySearch(new int[]{1, 4, 6, 10, 15, 22, 26, 30, 31}, 10, 0, 8));
}

public static int loopBinarySearch(int[] arr, int target, int start, int end) {
    while (start <= end) {
        int mid = (start + end) / 2;

        if (arr[mid] == target) {
            return mid;
        }

        if (arr[mid] < target) {
            start = mid + 1;
        } else {
            end = mid - 1;
        }
    }
    return -1;
}
```

## 코딩 테스트에서의 이진 탐색

- 이진 탐색 문제는 출제가 빈번하고 구현할 일이 많으므로 외워두기
- 데이터의 개수가 1,000만 단위를 넘어가면 이진탐색과 같이 O(logN)의 속도를 내는 알고리즘을 사용해야 정답 처리 될 수 있다.

## 자바에서의 이진 탐색

- Collections 클래스의 binarySearch() 메서드를 사용할 수 있다
    - 인자로 (정렬된 리스트, 찾고자 하는 원소 key, Comparator) 를 받는다
    - Comparator를 따로 전달하는 경우 해당 Comparator 또는 원소 클래스의 기본 Comparator/Comparable의 정렬 순서가 전달된 리스트의 현재 정렬된 순서와 동일해야 의도한 결과가 출력된다.

```java
// java api
List<Integer> list = new ArrayList<>(List.of(1, 4, 6, 10, 15, 22, 26, 30, 31));
Collections.binarySearch(list, 10); // 3
Collections.binarySearch(list, 13); // -5 (-(insertion point) - 1)

list.sort(Comparator.reverseOrder());
Collections.binarySearch(list, 10, Comparator.reverseOrder()); // 5
Collections.binarySearch(list, 13, Comparator.reverseOrder()); // -6 (-(insertion point) - 1)
```

# 트리

![image](https://github.com/gmelon/algorithm_problems/assets/33623106/cea4c767-0c57-4eb9-963c-0c87feba5d81)

## 정의

- 모든 정점이 연결되어 있고 사이클이 없는 `그래프`를 `트리`라고 한다
    - 위 정의 때문에 트리의 정점이 V개 라면, 간선은 항상 V - 1개 이며 아닐 경우 해당 자료 구조는 트리가 아닌 `그래프`이다.

## 특징

- 그래프의 일종
    - 많은 양의 데이터를 관리하기 위한 목적으로 사용
- 최상단 노드 → 루트 노드
- 최하단 노드 → 단말 노드
- 일부를 떼어내도 다시 재귀적으로 트리 구조를 이루며 이를 전체 트리에서보면 서브 트리 라고 한다
    - 때문에 계층적, 정렬된 데이터를 다루기에 적합

## 이진 트리

- 트리 중 모든 노드가 **최대** 2개의 자식을 갖는 트리를 특별히 `이진 트리` 라고 한다.
    - 각각의 자식은 left, right child라고 부른다
- 아래와 같이 모든 노드가 꼭 2개의 자식을 가질 필요는 없고 1개만 가질 수도, 아예 없을 수도 있다.

![image](https://github.com/gmelon/algorithm_problems/assets/33623106/8ea992f1-d5c0-41ee-8869-b30d43bd53f0)

## Full Binary Tree

- 모든 노드가 0개 또는 2개의 자식을 갖는 이진 트리

![image](https://github.com/gmelon/algorithm_problems/assets/33623106/b516b07d-37f4-44cd-b571-f1693b847197)

## Complete Binary Tree

- 마지막 레벨을 제외한 모든 레벨이 모두 노드로 채워져있는 이진 트리
    - 따라서 마지막 레벨과 그 부모를 제외한 모든 노드는 항상 2개의 자식을 갖는다
- 마지막 레벨의 경우 좌측에서부터 마지막 노드까지 빈 노드 없이 모두 채워져 있어야 함

![image](https://github.com/gmelon/algorithm_problems/assets/33623106/74f4c47a-23c8-4d5a-9d77-990a99296d79)

## Perfect Binary Tree

- (마지막 레벨을 포함해) 모든 노드가 정확히 2개 (리프일 경우 0개) 의 자식을 가지면서 모든 리프 노드가 같은 레벨에 있는 이진 트리
    - 때문에, 좌우가 균형을 이룬다

![image](https://github.com/gmelon/algorithm_problems/assets/33623106/49980a0b-22c3-4696-8012-77493654fad4)

## Balanced Binary Tree (균형 이진 트리)

- 모든 노드의 두 자식이 depth 차이가 최대 1개인 이진 트리

![image](https://github.com/gmelon/algorithm_problems/assets/33623106/7486ba0c-121d-4b04-859b-11d90242dec5)

## Degenerate Binary Tree

- 모든 노드가 최대 하나의 자식만을 가지는 이진 트리

![image](https://github.com/gmelon/algorithm_problems/assets/33623106/08231cc8-8c28-4dee-a6e8-358b5b3835fe)

## Red-Black Tree

- https://code-lab1.tistory.com/62

## 이진 탐색 트리

- 이**진 탐색이 동작할 수 있도록 고안된** 이진 트리 자료 구조이다

### 특징

![image](https://github.com/gmelon/algorithm_problems/assets/33623106/08e20ff2-0bdd-4889-bccc-d68992b73cde)

- 왼쪽 자식 노드 < 부모 노드
- 부모 노드 < 오른쪽 자식 노드

### 탐색

- 이진 탐색과 동일하게 찾고자 하는 값이 현재 노드보다 작다면 left child로, 현재 노드보다 크다면 right child로 이동해서 탐색을 진행한다.

# 자바에서 빠르게 입/출력하기

- 데이터의 개수가 1,000만을 넘어가면 일반적인 Scanner를 통한 입력, System.out 을 통한 출력으로는 시간 초과가 날 수 있다.
- 아래의 방법을 사용하여 보다 빠르게 입력 / 출력을 할 수 있다.

## 입력

- BufferedReader 사용
    - 여러 타입으로 입력 받을 수 있고 Space, Enter를 모두 경계로 인식해 편하게 사용할 수 있도록 입력을 처리하는 Scanner와 달리 String만 입력받을 수 있고, Enter만 경계로 인식하기 때문에 사용하기엔 불편하지만 대량의 데이터를 처리할 때는 속도 때문에 BufferedReader를 사용해야 한다.

```java
public static void main(String[] args) {
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
        String line;
        while ((line = reader.readLine()) != null) {
            StringTokenizer tokenizer = new StringTokenizer(line);
            tokenizer.nextToken();
        }
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
}
```

## 출력

- BufferedWriter 사용
- 주의할 점
    - writer.write() 메서드는 String만을 인자로 받으므로 숫자 등 출력 시 String으로 변환해야 함. 안 그러면 해당 숫자 (4바이트) 중 낮은 2바이트 부분이 char 타입으로 인식되어 의도치 않은 문자가 출력됨
    - 마지막에 꼭 writer.flush()를 해주어야 함. BufferedWriter 특성 상 최적화를 위해 버퍼가 다 찼을 때만 문자열을 출력하게 되는데, 아직 버퍼가 차지 않았어도 남은 문자열을 콘솔에 출력하기 위해 flush()가 사용됨

```java
try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
    for (Integer integer : list) {
        writer.write(String.valueOf(integer));
        writer.newLine();
    }
    writer.flush();
} catch (IOException e) {
    throw new RuntimeException(e);
}
```

a
