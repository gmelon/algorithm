package collections.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class LinkedList<T> {

    private int size;
    private Node<T> head;

    public LinkedList() {
        this.size = 0;
    }

    @SafeVarargs
    public static <T> LinkedList<T> of(T... newItems) {
        LinkedList<T> linkedList = new LinkedList<>();
        for (T newItem : newItems) {
            linkedList.addLast(newItem);
        }
        return linkedList;
    }

    /**
     * clear
     */
    public void clear() {
        this.head = null;
    }

    /**
     * get
     */
    public T get(int index) {
        return getTargetNode(index).getItem();
    }

    public List<T> getAll() {
        List<T> list = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            list.add(get(i));
        }
        return list;
    }

    /**
     * set
     */
    public void set(int index, T newItem) {
        Node<T> targetNode = getTargetNode(index);
        targetNode.setItem(newItem);
    }

    /**
     * add
     */
    public void addFirst(T newItem) {
        add(0, newItem);
    }

    public void addLast(T newItem) {
        add(size, newItem);
    }

    public void add(int index, T newItem) {
        if (index > size) {
            throw new IllegalArgumentException("해당 index에는 원소를 추가할 수 없습니다");
        }

        if (index == 0) {
            Node<T> lastHead = this.head;
            this.head = new Node<>(newItem, lastHead);
            size++;
            return;
        }

        Node<T> beforeNode = getTargetNode(index - 1);
        Node<T> targetNode = null;
        if (index < size) {
             targetNode = getTargetNode(index);
        }

        beforeNode.setNext(new Node<>(newItem, targetNode));
        size++;
    }

    /**
     * remove
     */
    public T remove(int index) {
        Node<T> beforeNode = getTargetNode(index - 1);
        Node<T> targetNode = getTargetNode(index);

        beforeNode.setNext(targetNode.getNext());
        size--;

        return targetNode.getItem();
    }

    /**
     * 보조 메서드
     */
    private Node<T> getTargetNode(int index) {
        if (index < 0) {
            return head;
        }
        if (index > size - 1) {
            throw new IndexOutOfBoundsException("해당 Index에는 원소가 존재하지 않습니다.");
        }

        Node<T> currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }
        return currentNode;
    }

}
