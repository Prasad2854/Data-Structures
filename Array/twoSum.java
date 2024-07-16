package Array;

import java.lang.reflect.Array;
import java.util.Arrays;

public class twoSum {
    public int[] twoSum(int[] arr, int target) {
        Arrays.sort(arr); //sorting the array
        int left = 0;
        int right = arr.length - 1;
        int results[] = new int[2];
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == target) {
                results[0] = arr[left];
                results[1] = arr[right];
                return results;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        twoSum t = new twoSum();
        int arr[] = {6, 7, 8, 9, 1};
        int target = 10;
        int[] result = t.twoSum(arr, target);
        if (result.length == 2) {
            System.out.println("The two numbers whose sum is equal to " + target + " are: " + result[0] + " and " + result[1]);
        } else {
            System.out.println("No two numbers found whose sum is equal to " + target);
        }
    }
}

