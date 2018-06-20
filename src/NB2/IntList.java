package NB2;

import java.util.Arrays;
public class IntList {
    private int[] list;
    private int maxSize;
    private int nrOfElements;
    public IntList(int initialSize){
        nrOfElements = 0;
        this.maxSize = initialSize;
        list = new int[maxSize];
    }
    private void reallocate(){
        maxSize = maxSize * 2;
        list = Arrays.copyOf(list,maxSize);
    }
    private void pack(int index){
        for (int i = index; i < nrOfElements; i++) {
            list[i] = list[i+1];
        }
    }
    public boolean add(int element){
        if(nrOfElements == maxSize)
            reallocate();
        list[nrOfElements++] = element;
        return true;
    }

    public int getNrOfElements() {
        return nrOfElements;
    }

    public void setNrOfElements(int nrOfElements) {
        this.nrOfElements = nrOfElements;
    }

    public boolean add(int index, int element){
        if(index > nrOfElements || index < 0)
            throw new ArrayIndexOutOfBoundsException(index);
        if(nrOfElements == maxSize)
            reallocate();
        for(int i = index; i<nrOfElements;i++){
            list[i+1] = list[i];
        }
        list[index] = element;
        nrOfElements++;
        return true;
    }
    public int get(int index){
        if(index > nrOfElements-1 || index < 0)
            throw new ArrayIndexOutOfBoundsException(index);
        return list[index];
    }
    public int indexOf(int element){
        int index = 0;
        for (int i = 0; i < nrOfElements; i++) {
            if(list[i]==element)
                index = i;
        }
        return index;
    }
    public int remove(int index){
        if(index > nrOfElements-1 || index < 0)
            throw new ArrayIndexOutOfBoundsException(index);
        int element = list[index];
        pack(index);
        nrOfElements--;
        return element;
    }
    public int set(int index,int element){
        if(index > nrOfElements-1 || index < 0)
            throw new ArrayIndexOutOfBoundsException(index);
        int overwrittenNumber = list[index];
        list[index] = element;
        return overwrittenNumber;

    }
    @Override
    public String toString() {
        return Arrays.toString(list);
    }

    public static void main(String[] args){
        IntList list = new IntList(3);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(1,8);
        list.remove(0);
        list.remove(2);
        list.remove(2);
        System.out.println(list.maxSize);
        System.out.println(list.getNrOfElements());
        System.out.println(list);
        System.out.println(list.indexOf(8));
    }
}
