package Array;

import javax.swing.plaf.synth.SynthTextAreaUI;

public class ReverseArray {
    public void printArray(int[] arr){ //we have just declared the array
      for(int i = 0; i < arr.length; i++){
          System.out.println(arr[i] +" ");
      }
    }
    public void reverseOfArray(int[] arr){
        int t = arr.length-1;
        for(int i = t; i >= 0; i--){
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr= new int[10];
        ReverseArray r = new ReverseArray();
//        r.printArray();//now we need to initialise the array...
        r.reverseOfArray(new int[]{7,8,1,9,10});

    }
}
