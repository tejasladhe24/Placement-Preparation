import java.util.*;

public class BruteForce {
    public static void findPair(int[] arr,int sum) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i==j) {
                    continue;
                }
                else if (arr[i] + arr[j] == sum) {
                    System.out.println("(" + arr[i] + ", " + arr[j] + ")");
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        String array_str = sc.nextLine();
        StringTokenizer stringTokenizer = new StringTokenizer(array_str);
        int n = stringTokenizer.countTokens();
        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt( (String)stringTokenizer.nextElement());
        }

        int sum = sc.nextInt();

        findPair(arr, sum);

        sc.close();
    }
}