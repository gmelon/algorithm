# 정렬 이론 학습 (구현해보기)

## 선택 정렬

- 가장 작은 데이터를 맨 앞과 바꾸고,
- 다시 그다음 작은 데이터를 맨 앞에서 두 번째 데이터와 바꾼다

→ 매번 가장 작은 것을 ‘선택’ 하기 때문에 ‘선택 정렬’이라고 한다

```java
public static void sort(int[] arr) {
    for (int i = 0; i < arr.length - 1; i++) {
        // i번째 원소를 정렬하려고 함
        int curMinIndex = i;
        for (int j = i + 1; j < arr.length; j++) {
            // i + 1 ~ 끝 까지 원소 중 가장 작은 원소를 찾음
            if (arr[j] < arr[curMinIndex]) {
                curMinIndex = j;
            }
        }
        // i + 1 ~ 끝까지 원소 중 가장 작은 원소를 i번째에 넣기
        int temp = arr[curMinIndex];
        arr[curMinIndex] = arr[i];
        arr[i] = temp;
    }
}
```

- 정렬하려는 원소(n개) index 별로 가장 작은 원소를 탐색하는 과정(n번)이 필요하기 때문에 시간 복잡도는 대략 O(n^2)
    - 따라서 실제로 사용하기엔 매우 느린 방법

## 삽입 정렬

- **앞 쪽의 데이터는 모두 정렬되어 있다고 가정** 하고 **새로운 데이터를 정렬된 데이터 중 적절한 위치에 삽입** 하는 알고리즘
    - 따라서, 최초에 **가장 앞에 있는 원소 하나** 는 그 자체로 이미 정렬되어 있다고 가정 (앞 부분은 원소가 하나인 정렬된 배열이라고 가정)하고 정렬을 시작한다
- 이후에 비교를 당하는 원소는 자신보다 이전에 있는 원소가 자신보다 클 경우에만 정렬을 수행하면 된다
    - 자신보다 작으면 (오름차순의 경우) 이미 정렬이 된 것이므로 아무런 동작을 하지 않는다
- 마찬가지로, 최초에 왼쪽의 원소가 자신보다 크다고 하더라도 이후에 만나는 최초의 자신 보다 작은 원소가 있다면 그 원소 다음에 자신을 위치시킬 수 있다 (그 전 원소는 확인할 필요 X)
    - 앞 부분의 배열은 항상 정렬된 상태로 유지하고 있기 때문이다

```java
public static void sort(int[] arr) {
    for (int i = 1; i < arr.length; i++) {
				// j는 1까지만 와야함 -> arr[0] <-> arr[1]과의 비교를 마지막으로 수행 후 종료
        for (int j = i ; j > 0; j--) { 
            // 현재 값이 이전 원소보다 작으면, 교체하면서 앞으로 나아감
            if (arr[j - 1] > arr[j]) {
                // swap
                int temp = arr[j - 1];
                arr[j - 1] = arr[j];
                arr[j] = temp;
            }
        }
    }
}
```

- 시간복잡도는 선택 정렬과 동일하게 O(N^2) 이지만, 정렬이 되어 있지 않을 경우에만 교체를 수행하므로 배열이 거의 정렬되어 주어질 경우 O(N)으로 동작한다

## 퀵 정렬

- 기준 데이터 (피벗) 을 설정하고 피벗보다 작은 데이터와 피벗보다 큰 데이터를 교환한다
    - 호어 분할은 단순히 리스트에서 가장 좌측의 원소를 피벗으로 삼는다
    - 작은 데이터는 우측에서부터, 큰 데이터는 좌측에서 부터 찾는다
- 각각 피벗보다 작은/큰 데이터를 찾을 때마다 서로 교환해주며 진행하다 각각의 index가 서로 어긋나는 경우
    - 피벗과 작은 쪽 데이터를 교환한다
    - 그럼 피벗을 기준으로 좌측에는 모두 피벗보다 작은 데이터, 우측에는 피벗보다 큰 데이터가 모이게 된다
- 이제 각각의 영역에 재귀적으로 위 과정을 반복하면 → 전체 리스트가 정렬된다
    - 재귀의 종료 조건은 리스트에 원소가 하나만 남았을 때 이다.

```java
public static void sort(int[] arr, int start, int end) {
    if (start >= end) {
        // 원소가 하나일 경우 종료
        return;
    }
    int pivot = start; // 피벗은 첫번째 원소
    int left = start + 1;
    int right = end;
    while (left <= right) {
				/* left, right 각각 등호 포함 여부에 주의 */

        // left는 pivot보다 큰 값을 찾는다
        while (left <= end && arr[left] <= arr[pivot]) {
            left++;
        }
        // right는 pivot보다 작은 값을 찾는다
        while (start < right && arr[right] >= arr[pivot]) {
            right--;
        }
        // left, right모두 탐색 종료
        if (left > right) {
            // 둘이 어긋난 경우
            // pivot과 작은 쪽을 바꾼다
            int temp = arr[pivot];
            arr[pivot] = arr[right];
            arr[right] = temp;
        } else {
            // 어긋나지 않은 경우
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
        }
    }

    // 나누어진 부분에 대해 재귀적으로 퀵 소트 수행
    sort(arr, start, right - 1);
    sort(arr, right + 1, end);
}
```

- 평균 O(NlogN)의 시작 복잡도를 갖는다
    - 데이터가 N개 일 때 평균 (반으로 나눠진다고 하면) 높이가 logN이기 떄문
- 그러나 또 이 때문에 정렬된 데이터가 주어지면 높이가 N이 되고 따라서 최악의 경우 O(N^2) 이 될 수도 있다
    - 이때는 피벗을 선택하는 별도의 알고리즘을 사용해 최악의 경우에도 NlogN으로 맞춰줄 수 있다

## 계수 정렬

```java
public static void sort(int[] arr) {
    int max = Arrays.stream(arr)
        .max()
        .orElse(0);
    int[] count = new int[max + 1];

    for (int number : arr) {
        count[number]++;
    }

    System.out.print("[");
    for (int i = 0; i < count.length; i++) {
        for (int j = 0; j < count[i]; j++) {
            System.out.print(i + " ");
        }
    }
    System.out.println("]");
}
```

- 왜 공간 복잡도가 O(N + K) 인가?

## 버블 정렬

## 병합 정렬

- 퀵 정렬보다 느리지만, 최악의 경우에도 O(NlogN)을 보장해준다
