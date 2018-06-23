package NB8;
import java.util.Arrays;


    public class ArrayQueueNB8<E> {
        private int front;
        private int rear;
        private int size;
        private int maxSize;
        private E[] data;
        public ArrayQueueNB8(int initialCapacity){
            size = 0;
            front = 0;
            maxSize = initialCapacity;
            rear = 0;
            data = (E[]) new Object[maxSize];
        }
        public boolean offer(E element){
            if(maxSize == size)
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
            if(size < (maxSize / 4) + 1)
                deallocate();
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
            rear = oldMaxSize-1;
            data = newData;
        }
        private void deallocate(){
            int oldMaxSize = maxSize;
            maxSize = maxSize / 2;
            int count = 0;
            int tempFront = front;
            E[] newData = (E[]) new Object[maxSize];
            while(count < size){
                newData[count] = data[tempFront];
                tempFront = (tempFront +1) % oldMaxSize;
                count++;
            }
            front = 0;
            rear = count-1;
            data = newData;

        }
        public static void main(String[] args){
            ArrayQueueNB8<Integer> q = new ArrayQueueNB8<>(8);
            q.offer(1);
            q.offer(2);
            q.offer(3);
            q.offer(4);
            q.offer(5);
            q.offer(6);
            q.offer(7);
            q.offer(8);
            q.poll();
            q.poll();
            q.poll();
            q.poll();
            q.poll();
            q.poll();
            System.out.println(q.fullToString());
            System.out.println(q.front);
            System.out.println(q.rear);
            System.out.println(q);
            q.offer(4);
            q.offer(10);
            System.out.println(q);
            System.out.println(q.fullToString());
            q.offer(1);
            System.out.println(q.fullToString());

        }




}
