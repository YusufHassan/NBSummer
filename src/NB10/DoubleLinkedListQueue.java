package NB10;

public class DoubleLinkedListQueue<E>{
    private Node<E> front;
    private Node<E> rear;
    private int size;
    private class Node<E>{
        private E data;
        private Node<E> next;
        private Node<E> prev;
        public Node(E data, Node<E> next,Node<E> prev){
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }
    public DoubleLinkedListQueue(){

    }
    public String toString(){
        Node<E> node = front;
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while(node.next!=null){
            sb.append(node.data.toString()+",");
            node = node.next;
        }
        sb.append(node.data.toString()+"]");
        return sb.toString();
    }
    public boolean offerLast(E element){
        if(size == 0){
            front = new Node<>(element,null,null);
            rear = front;
        }else{
            rear.next = new Node(element,null,rear);
            rear = rear.next;
        }
        size++;
        return true;
    }
    public E pollFirst(){
        E element;
        if(size == 0){
            return null;
        }else{
            element = front.data;
            front = front.next;
        }
        size--;
        return element;
    }
    public boolean offerFirst(E element){
        if(size == 0){
            front = new Node<>(element,null,null);
            rear = front;
        }else{
            Node<E> node = new Node<>(element,front,null);
            front = node;
        }
        size++;
        return true;
    }
    public E pollLast(){
        E element = rear.data;
        Node<E> node = rear;
        rear = null;
        rear  = node.prev;
        return element;
    }
    public static void main(String[] args){
        DoubleLinkedListQueue<Integer> q = new DoubleLinkedListQueue<>();
        q.offerLast(1);
        q.offerLast(2);
        q.offerLast(3);
        System.out.println(q);
        q.pollLast();
        q.offerLast(4);
        q.offerFirst(1);
        q.pollFirst();
        System.out.println(q);
    }
}
