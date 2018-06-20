package Föreläsning2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SingleLinkedList<E> implements Iterable<E>{
    private static class Node<E>{
        private E data;
        private Node<E> next;
        public Node(E data, Node<E> next){
            this.data = data;
            this.next = next;
        }
    }
    private class Itr implements Iterator<E>{
        Node<E> current;
        public Itr(Node<E> start){
            current = start;
        }
        @Override
        public boolean hasNext() {
            return current!=null;
        }

        @Override
        public E next() {
            if(current == null)
                throw new NoSuchElementException();
            E returnValue  = current.data;
            current = current.next;
            return returnValue;
        }
        public E remove(int index) {
            E data = null;
            if(index == 0) {
                data = head.data;
                head = head.next;
                size--;
                return data;
            }
            else if(index==size-1){
                Node<E> node = getNode(index);
                data = node.data;
                node = null;
                size--;
            }
            else{
                Node<E> toRemove = getNode(index);
                Node<E> prev = getNode(index-1);
                data = toRemove.data;
                prev.next = toRemove.next;
                size--;
            }
            return data;
        }
    }
    public Iterator<E> iterator(){
        return new Itr(head);
    }
    public boolean add(E item){
        if(size == 0)
            addFirst(item);
        else
            addAfter(getNode(size-1),item);
        size++;
        return true;
    }
    public boolean add(int index, E item){
        if(index <0 || index > size)
            throw new ArrayIndexOutOfBoundsException(index);
        if(index == 0){
            addFirst(item);
        }else{
            Node<E> node = getNode(index-1);
            addAfter(node,item);
        }
        size++;
        return true;
    }
    private void addFirst(E element){
        head = new Node<>(element,head);
    }
    private void addLast(E element){
        add(size,element);
    }
    private void addAfter(Node<E> node, E item){
        node.next = new Node<>(item,node.next);
    }
    public E get(int index){
        if(index <0 || index >= size)
            throw new ArrayIndexOutOfBoundsException(index);
        Node<E> node = getNode(index);
        return node.data;
    }
    private Node<E> getNode(int index){
        Node<E> node = head;
        for (int i = 0; i <index && node!=null; i++ ) {
            node = node.next;
        }
        return node;
    }
    @Override
    public String toString(){
        Node<E> node = head;
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if(node!=null){
            while(node.next!=null){
                sb.append(node.data.toString()+",");
                node = node.next;
            }
            sb.append(node.data.toString());
        }
        sb.append("]");
        return sb.toString();
    }
    private Node<E> head;
    private int size;
    public static void main(String[] args){
        SingleLinkedList<String> list = new SingleLinkedList<>();
        for (int i = 0; i < 11; i++) {
            list.add("Sträng"+i);
        }
        System.out.println("hej");
        Iterator<String> iter = list.iterator();
        System.out.println(list);
        while(iter.hasNext()){
            System.out.println(iter.next());
        }

        while(iter.hasNext()){
            System.out.println(iter.next());
        }
    }
}