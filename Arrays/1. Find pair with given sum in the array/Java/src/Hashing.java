import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Hashing {
    public static void findPair(int[] arr, int sum) {
        Map<Integer,Integer> hashMap = new HashMap<Integer, Integer>();

        for (int i = 0; i < arr.length; i++) {
            if (hashMap.get(sum-arr[i]) != null) {
                System.out.println("(" + arr[hashMap.get(sum-arr[i])] + ", " + arr[i] + ")");
            }

            hashMap.put(arr[i],i);
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

        // int sum = sc.nextInt();

        int[] arr = {8,7,2,5,3,1};
        int sum = 10;

        findPair(arr, sum);
    }
}
