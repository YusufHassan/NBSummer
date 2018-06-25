package NB11;


import java.util.Arrays;
import java.util.Random;

public class BiggestInt {
    public static int biggestInt(int[] arr, int pos, int currentBiggest){
        if(currentBiggest < arr[pos])
            currentBiggest = arr[pos];
        if(pos == arr.length-1)
            return currentBiggest;
        else
            return biggestInt(arr,pos+1,currentBiggest);
    }
    public static void main(String[] args){
        Random randomizer = new Random(2);
        int[] arr = new int[7];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = randomizer.nextInt(10);
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(BiggestInt.biggestInt(arr,0,0));
    }
}