package Föreläsning4;

import java.util.Arrays;
import java.util.spi.AbstractResourceBundleProvider;

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
        if(size == maxSize)
           this.reallocate();
        rear = (rear+1) % maxSize;
        data[rear] = element;
        size++;
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
            tempFront = (tempFront +1) % oldMaxSize;
            count++;
        }
        front = 0;
        rear = size-1;
        data = newData;
        System.out.println(Arrays.toString(newData) + "This new data!!!" );
    }
    public static void main(String[] args){
        ArrayQueue<Integer> q = new ArrayQueue<>(1);
        q.offer(1);
        q.offer(2);
        q.offer(3);
        q.offer(4);
        q.offer(5);
        q.poll();
        q.offer(6);
        q.offer(7);
        q.poll();
        q.offer(8);
        System.out.println(q);
        q.offer(9);
        q.poll();
        q.poll();
        q.poll();
        q.poll();
        q.poll();
        q.offer(10);
        System.out.println(q.front+ "front");
        System.out.println(q.rear);
        System.out.println(q);
    }
}
