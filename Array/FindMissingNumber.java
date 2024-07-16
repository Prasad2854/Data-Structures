package Array;
//1|2|4|5|6  -> here the missing number is 3
//arr.length = 5 && arr.length + 1 = 6

public class FindMissingNumber {
    public int missingNumber(int[] arr){
        int n = arr.length + 1;
        int sum = n*(n+1)/2;
        for (int num : arr){
            sum = sum - num;
        }
        return sum;
    }

    public static void main(String[] args) {

        FindMissingNumber f = new FindMissingNumber();
        int arr[] = {1, 2, 4 ,5,6};
        System.out.println("The missing number is "+ f.missingNumber(arr));
    }
}
