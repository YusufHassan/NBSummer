package NB5;

import java.util.Arrays;

public class ArrayStack<E> implements StackInt<E> {
    private E[] data;
    private int top;
    private int size;
    private int maxSize;
    public ArrayStack(int initialCapacity){
        maxSize = initialCapacity;
        top = -1;
        data = (E[]) new Object[maxSize];
        size = 0;
    }
    private void reallocate(){
        maxSize = maxSize * 2;
        data = Arrays.copyOf(data,maxSize);
    }
    @Override
    public E peek() {
        return data[top];
    }
    public E peek(int index){
        return data[index];
    }
    public E flush(){
        E element = data[0];
        top = -1;
        return element;
    }
    public int size(){
        return size;
    }
    @Override
    public E pop() {
        E element = data[top];
        top--;
        size--;
        return element;
    }

    @Override
    public int search(Object o) {
        return 0;
    }

    @Override
    public boolean empty() {
        return top == -1;
    }

    @Override
    public E push(E item) {
        if(size == maxSize)
            reallocate();
        top++;
        size++;
        data[top] = item;
        return item;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            if(i == size-1)
                sb.append(data[i].toString());
            else
                sb.append(data[i].toString()+",");
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args){
        ArrayStack<String> stack = new ArrayStack<>(5);
        System.out.println(stack.empty());
        stack.push("First");
        stack.push("Second");
        stack.push("Third");
        stack.push("Hello");
        stack.push("Second");
        stack.push("Third");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.top);
        System.out.println(stack.peek());
        System.out.println(stack.empty());

    }
}
