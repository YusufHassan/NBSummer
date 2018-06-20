package NB7;

import NB5.StackInt;

import java.util.NoSuchElementException;

public class LinkedStack<E> implements StackInt<E> {
    private class Node<E>{
        private E data;
        private Node<E> next;
        public Node(E data, Node<E> next){
            this.data = data;
            this.next = next;
        }
    }
    boolean firstPush = true;
    public LinkedStack(){
        top = null;
    }
    private Node<E> top;
    @Override
    public int search(Object o) {
        return 0;
    }

    @Override
    public E push(E item) {
        if(firstPush){
                top = new Node(item,null);
            firstPush = false;
        }
        else{
            Node<E> node = new Node(item,null);
            node.next = top;
            top = node;
        }

        return item;
    }
    public E peek(int index){
        Node<E> node = top;
        for (int i = 0; i <index && node!=null ; i++) {
           node = node.next;
        }
        return node.data;
    }
    public E flush(){
        Node<E> node = top;
        firstPush = false;
        while(node.next!=null)
            node = node.next;
        top = null;
        return node.data;
    }
    public int size(){
        Node<E> node = top;
        int counter = 0;
        while(node!=null){
            counter++;
            node = node.next;
        }

        return counter;
    }

    @Override
    public boolean empty() {
        return top == null;
    }

    @Override
    public E pop() {
        E element = top.data;
        top = top.next;
        return element;
    }

    @Override
    public String toString() {
        Node<E> node = top;
        if(node==null)
            throw new NoSuchElementException();
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        while(node.next != null){
            sb.append(node.data.toString() +",");
            node = node.next;
        }
        sb.append(node.data.toString()+"]");
        return sb.toString();
    }

    @Override
    public E peek() {
        return top.data;
    }
    public static void main(String[] args){
        LinkedStack<Integer> stack = new LinkedStack<>();
        stack.push(3);
        stack.push(2);
        stack.push(1);
        System.out.println(stack.size());
        System.out.println(stack.flush());
        System.out.println(stack.size());
    }
}
