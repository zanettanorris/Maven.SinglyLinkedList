package com.zipcodewilmington.singlylinkedlist;

import java.lang.reflect.Array;
/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedList<T> {
    private Node head;
    private int listSize = 0;

    private class Node {
        private T element;
        private Node next;

        //constructor with just generic element
        public Node(T element) {
            this.element = element;
        }

        //constructor with next node and generic element
        public Node(Node next, T element) {
            this.element = element;
            this.next = next;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public T getElement() {
            return element;
        }

    }

    private void incrementListSize() {
        listSize++;
    }

    private void decrementListSize() {
        listSize--;
    }

    private int getListSize() {
        return listSize;
    }

    //adds element to end of list

    public void addElement(T element) {
        //if list is empty, add element to head of list
        Node newNode = new Node(element);
        if (this.head == null) {
            this.head = newNode;
        }
        //else walk to the last node  and insert the new node there
        else {
            Node last = head;
            while (last.getNext() != null) {
                last = last.getNext();
            } //this bracket was in the wrong place.
            last.setNext(newNode);
        }
        incrementListSize();
    }
        //} it was over here.

    public boolean removeElementByIndex(int index) {
        //if the index is out of range exit
        if (index < 0 || index > getListSize() || head == null)
            return false;
        if (index == 0) {
            head = head.getNext();
            return true;
        }
        //find element at index
        Node previous = null;
        Node current = head;
        for (int listIndex = 1; listIndex < index; listIndex++) {
            previous = current;
            current = current.getNext();
        }
        previous.setNext(current.getNext());
        decrementListSize();
        return true;
    }

    public boolean containsElement(T element) {
        //if list contains element return true if not return false
        if (head == null) {
            return false;
        }
        Node selectedElement = head;
        if (selectedElement.getElement().equals(element)) {
            return true;
        }
        for (int i = 0; i < getListSize(); i++) {
            selectedElement = selectedElement.getNext();
            if (selectedElement.getElement().equals(element)) {
                return true;
            }
        }
        return false;
    }

    public int findIndexByElement(T element) {
        // param is element return index in list of element
        // or -1 if element is not in list
        if (head == null) {
            return -1;
        }
        Node selectedNode = head;
        for (int i = 0; i < getListSize(); i++) {
            if (selectedNode.getElement().equals(element)) {
                return i;
            }
            selectedNode = selectedNode.getNext();
        }
        return -1;
    }

    public Integer getSizeOfList() {
        return getListSize();
    }

    public T getElementByIndex(int index) {
        if (index < 0 || index > getListSize())
            return null;
        Node selectedElement = head;
        for (int i = 0; i < index; i++) {
            selectedElement = selectedElement.getNext();
        }
        return selectedElement.getElement();
    }


    public SinglyLinkedList<T> copySameValues() {
        return null;
    }

    public void sortList() {
    }
}
