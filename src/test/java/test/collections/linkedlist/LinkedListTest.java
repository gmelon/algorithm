package test.collections.linkedlist;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import collections.linkedlist.LinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LinkedListTest {

    LinkedList<Integer> linkedList;

    @BeforeEach
    void setUp() {
        linkedList = new LinkedList<>();
    }

    @Test
    void 원소_얻기() {
        linkedList.addLast(1);
        linkedList.addLast(2);
        linkedList.addLast(3);

        assertThat(linkedList.get(0)).isEqualTo(1);
        assertThat(linkedList.get(1)).isEqualTo(2);
        assertThat(linkedList.get(2)).isEqualTo(3);
    }

    @Test
    void 원소_추가_first_last() {
        linkedList.addFirst(1);
        linkedList.addFirst(0);
        linkedList.addLast(5);
        assertThat(linkedList.getAll()).containsExactly(0, 1, 5);
    }

    @Test
    void 원소_추가_index지정() {
        linkedList.addFirst(1);

        assertThatThrownBy(() -> linkedList.add(2, 10))
            .isInstanceOf(IllegalArgumentException.class);

        linkedList.add(1, 5);
        linkedList.add(2, 10);
        linkedList.add(1, 3);
        assertThat(linkedList.getAll()).containsExactly(1, 3, 5, 10);
    }

    @Test
    void 원소_삭제() {
        linkedList.add(0, 0);
        linkedList.add(1, 1);
        linkedList.add(2, 2);
        linkedList.add(3, 3);

        assertThatThrownBy(() -> linkedList.remove(4))
            .isInstanceOf(IndexOutOfBoundsException.class);

        linkedList.remove(2);

        assertThat(linkedList.getAll()).containsExactly(0, 1, 3);
    }

    @Test
    void 원소_교체() {
        linkedList.addLast(0);
        linkedList.addLast(1);
        linkedList.addLast(2);

        assertThatThrownBy(() -> linkedList.set(3, 10))
            .isInstanceOf(IndexOutOfBoundsException.class);

        linkedList.set(1, 10);

        assertThat(linkedList.getAll()).containsExactly(0, 10, 2);
    }

    @Test
    void 원소_전체_삭제() {
        linkedList.addLast(0);
        linkedList.addLast(1);
        linkedList.addLast(2);
        linkedList.clear();

        assertThat(linkedList.getAll()).isEmpty();
    }

    @Test
    void of() {
        assertThat(LinkedList.of(1, 2, 3, 4, 5).getAll())
            .containsExactly(1, 2, 3, 4, 5);
    }

    @Test
    void name() {
        String s = "asdas";
        for (char c : s.toCharArray()) {

        }
    }
}