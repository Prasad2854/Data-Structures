package Array;

public class EvenNumOutOFArray {
    int[] removeEven(int[] arr){
        int oddCount = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] % 2 != 0){
                oddCount++;
            }
        }
        int[] results = new int[oddCount];
        int index = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] % 2 != 0){
                results[index] = arr[i];
                index++;
            }
        }
    return results;
    }
    public static void main(String[] args) {
        int arr[] = new  int[10];
        EvenNumOutOFArray e = new EvenNumOutOFArray();
        e.removeEven(new int[]{4, 7,8,9,0,2,1});
    }
}
