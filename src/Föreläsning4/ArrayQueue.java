package Föreläsning4;

import java.util.Arrays;

public class ArrayQueue<E> {
    private int front;
    private int rear;
    private int size;
    private int maxSize;
    private E[] data;
    public ArrayQueue(int initialCapacity){
        size = 0;
        front = 0;
        maxSize = initialCapacity;
        rear = 0;
        data = (E[]) new Object[maxSize];
    }
    public boolean offer(E element){
        if(rear-1 == front)
            this.reallocate();
        data[rear] = element;
        size++;
        rear = (rear+1) % maxSize;
        return true;
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        int count = 0;
        int tempFront = front;
            while (count < size){
               sb.append(data[tempFront]+",");
               tempFront = (tempFront +1) % maxSize;
               count++;
            }

        sb.append("]");
        return sb.toString();
    }
    public String fullToString(){
        return Arrays.toString(data);
    }
    public E peek(){
        if(size == 0)
            return null;
        else
            return data[front];
    }
    public E poll(){
         if(size==0)
             return null;
         E element = data[front];
         front = (front+1) % maxSize;
         size--;
         return element;
    }
    private void reallocate(){
        int oldMaxSize = maxSize;
        maxSize = maxSize *2;
        E[] newData = (E[]) new Object[maxSize];
        int count = 0;
        int tempFront = front;
        while (count < size){
            newData[count] = data[tempFront];
            tempFront = (tempFront +1) % maxSize;
            count++;
        }
        front = 0;
        rear = oldMaxSize-1;
        data = newData;
    }
    public static void main(String[] args){
        ArrayQueue<Integer> q = new ArrayQueue<>(2);
        q.offer(1);
        q.offer(2);
        q.offer(3);
        q.poll();
        q.offer(4);
        q.offer(5);
        q.poll();
        q.offer(6);
        System.out.println(q);
        q.offer(7);
        q.poll();
        q.poll();
        q.poll();
        q.poll();
        q.poll();
        q.offer(3);
        System.out.println(q);

    }
}
