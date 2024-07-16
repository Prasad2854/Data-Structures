package Array;

public class StringPalindrome {
    void displayArray (int[] arr){
        int n = arr.length;
        for(int i = 0; i < n; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public boolean isPalindrome(String word){
            char[] charArray = word.toCharArray();
            int start = 0;
            int end = word.length() - 1;
            while(start < end){
                if(charArray[start] != charArray[end]){
                    return false;
                }
                start++;
                end--;
            }
            return true;
    }

    public static void main(String[] args) {
        StringPalindrome s = new StringPalindrome();
        if(s.isPalindrome("that")){
            System.out.println("This is palindrome");
        }else {
            System.out.printf("This is not a palindrome");
        }
    }
}
