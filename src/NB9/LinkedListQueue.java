package NB9;

public class LinkedListQueue<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;
    public LinkedListQueue(){
        head = null;
        tail = null;
        size = 0;
    }
    public boolean enqueue(E element){
        if(size== 0){
            head = new Node(element,null);
            tail = head;
        }else{
            tail.next = new Node(element,null);
            tail = tail.next;
        }
        size++;
        return true;
    }
    public E dequeue(){
        if(size == 0)
            return null;
        E element = head.data;
        head = head.next;
        return element;
    }
    public String toString(){
        Node<E> node = head;
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while(node.next!=null){
            sb.append(node.data.toString()+",");
            node = node.next;
        }
        sb.append(node.data.toString()+"]");
        return sb.toString();
    }
    private class Node<E>{
        private E data;
        private Node<E> next;
        public Node(E data, Node<E> next){
            this.data = data;
            this.next = next;
        }

    }
    public static void main(String[] args){
        LinkedListQueue<Integer> q = new LinkedListQueue<>();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.dequeue();
        q.enqueue(2);
        q.dequeue();
        System.out.println(q);
    }
}
