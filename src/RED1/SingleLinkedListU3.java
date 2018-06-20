package RED1;
import java.util.*;

public class SingleLinkedListU3<E> implements Iterable<E> {
    @Override
    public Iterator<E> iterator() {
        return new Itr(head);
    }
    private class Itr<E> implements Iterator<E>  {
        private Node<E> current;
        private Node<E> bcurrent;
        private Node<E> bbcurrent;
        int itrCount = 1;
        boolean isRemovedCalled = false;
        public Itr(Node<E> start){
            current = start;
        }
        @Override
        public E next() {
            System.out.println("This is currentPre: "+current.data);
            E element = null;
            if(current == null)
                throw new NoSuchElementException();
            if(itrCount == 1){
                bbcurrent = current;
                bcurrent = current;
                element = current.data;
                current = current.next;
                itrCount++;
            }
            else if(itrCount == 2){
                bcurrent = current;
                element = current.data;
                current = current.next;
                itrCount++;
            }
            else if(itrCount >= 3){
                bbcurrent = bcurrent;
                bcurrent = current;
                element = current.data;
                current = current.next;
                itrCount++;
            }
            System.out.println("This is beforebefore: "+bbcurrent.data);
            System.out.println("This is before: "+bcurrent.data);
          return element;
        }
        @Override
        public boolean hasNext() {
            return current.next != null;
        }

        @Override
        public void remove() {
            if(itrCount==2){
            isRemovedCalled = true;
            head = head.next;
            bbcurrent = current;
            bcurrent = current;
            itrCount--;
            size--;
            }else{
                isRemovedCalled = true;
                bbcurrent.next = current;
                itrCount--;
                size--;
            }
        }
    }
    private static class Node<E>{
        private E data;
        private Node<E> next;
        public Node(E data, Node<E> next){
            this.data = data;
            this.next = next;
        }
        public String toString(){
            boolean test = next != null;
            if(test)
             return this.data + "true";
            else
                return this.data + "false";
        }
    }
    public Node<E> head;
    private int size;
    public boolean add(E element){
        if(size==0)
            addFirst(element);
        else {
            Node<E> node = getNode(size-1);
            addAfter(node,element);
        }
        size++;
        return true;
    }
    private void addFirst(E element){
        head = new Node(element,null);
    }
    private void addAfter(Node<E> prevNode, E element){
        if(prevNode.next == null)
            prevNode.next = new Node(element,null);
        else
            prevNode.next = new Node(element,prevNode.next);
    }
    private Node<E> getNode(int index){
        if(index < 0 || index >= size)
            throw new ArrayIndexOutOfBoundsException(index);
        Node<E> node = head;
        for(int i = 0; i < index && node!= null; i++){
            node = node.next;
        }
        return node;
    }
    public E get(int index){
        if(index < 0 || index >= size)
            throw new ArrayIndexOutOfBoundsException(index);
        return getNode(index).data;
    }
    public boolean add(int index, E element){
        if(index <0 || index > size)
            throw new ArrayIndexOutOfBoundsException(index);
        Node<E> save;
        if(index == 0){
           head = new Node(element,head);
        }else{
            addAfter(getNode(index-1),element);
        }
        size++;
        return true;
    }

    public String toString(){
        Node<E> node = head;
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if(node!=null) {
            while (node.next != null) {
                sb.append(node.data + ",");
                node = node.next;

            }
            sb.append(node.data);
            sb.append("]");
        }
        return sb.toString();
    }
    public static void main(String[] args){
        SingleLinkedListU3<Integer> list = new SingleLinkedListU3();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        Iterator itr = list.iterator();
        itr.next();
        itr.next();
        itr.remove();
        itr.next();
        itr.remove();
        itr.next();
        itr.remove();
        itr.next();
        itr.remove();
        System.out.println(list);
    }
}