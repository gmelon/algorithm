package test.collections.linkedlist;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import collections.linkedlist.LinkedList;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LinkedListTest {

    LinkedList<Integer> list;

    @BeforeEach
    void setUp() {
         list = new LinkedList<>();
    }

    @Test
    void 원소_추가() {
        list.addFirst(1);
        assertThat(list.getAll()).size(1);
    }
}