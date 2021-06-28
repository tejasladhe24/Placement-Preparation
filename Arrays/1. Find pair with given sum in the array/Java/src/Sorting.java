import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Sorting {

    public static void findPair(int[] arr, int sum) {
        Arrays.sort(arr);

        int low = 0; int high = arr.length-1;

        while (low < high) {
            if (arr[low] + arr[high] == sum) {
                System.out.println("(" + arr[low] + ", " + arr[high] + ")");
                low += 1;
            }
            if (arr[low] + arr[high] < sum) {
                low += 1;
            }
            if (arr[low] + arr[high] > sum) {
                high -= 1;
            }
        }
        
    }
    public static void main(String[] args) throws Exception {
        // Scanner sc = new Scanner(System.in);
        
        // String array_str = sc.nextLine();
        // StringTokenizer stringTokenizer = new StringTokenizer(array_str);
        // int n = stringTokenizer.countTokens();

        // int[] arr = new int[n];

        // for (int i = 0; i < arr.length; i++) {
        //     arr[i] = Integer.parseInt((String) stringTokenizer.nextElement());
        // }

        int n = 6;
        int[] arr = {8,7,2,5,3,1};
        int sum = 10;

        // sum = sc.nextInt();

        findPair(arr,sum);

    }
}
