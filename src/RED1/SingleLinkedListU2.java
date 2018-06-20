package RED1;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SingleLinkedListU2<E> implements Iterable<E>{
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

    }
    public Iterator<E> iterator(){
        return new Itr(head);
    }

    public boolean add(E item){
        if(size == 0){
            addFirst(item);
            tail = head;
        }
        else{

           tail = addAfter(getNode(size-1),item);

        }

        size++;
        return true;
    }
    public boolean add(int index, E item){
        if(index <0 || index > size)
            throw new ArrayIndexOutOfBoundsException(index);
        if(index == 0){
            addFirst(item);
        }
        else{
            if(size-1 == index){
                 Node<E> prev = getNode(index-1);
                 prev.next = new Node<E>(item,tail);
            }
            else{
                System.out.println("hej");
                Node<E> node = getNode(index-1);
                addAfter(node,item);
            }
        }
        size++;
        return true;
    }
    public E remove(int index) {
        E data = null;
        if(index == 0) {
            data = head.data;
            head = head.next;
            size--;
            return data;
        }
        else if(index==size-1){ // uppdatera tail.
            Node<E> node = getNode(index-1);
            data = node.next.data;
            node.next = null;
            tail = node;
            size--;
            System.out.println("hello");
            return data;
        }
        else{
            Node<E> toRemove = getNode(index);
            Node<E> prev = getNode(index-1);
            data = toRemove.data;
            prev.next = toRemove.next;
            size--;
            return data;
        }
    }
    private void addFirst(E element){
        head = new Node<>(element,head);
    }
    private void addLast(E element){
        tail.next = new Node<E>(element,null);
    }
    private Node<E> addAfter(Node<E> node, E item){
        node.next = new Node<>(item,node.next);
        return node.next;
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
    private Node<E> tail;
    public static void main(String[] args){
        SingleLinkedListU2<String> list = new SingleLinkedListU2<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("2");
        list.add(3,"5");
        list.remove(4);
        System.out.println(list.tail.data);
        System.out.println(list);
    }
}