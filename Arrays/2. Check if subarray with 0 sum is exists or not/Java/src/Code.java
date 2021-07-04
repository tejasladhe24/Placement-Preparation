import java.util.Scanner;
import java.util.StringTokenizer;

public class Code {

    public static void printV(int[] v) {
        for (int i = 0; i < v.length; i++) {
            System.out.print(v[i] + " ");            
        }
        System.out.println("\n");            
    }

    public static boolean hasZeroSumSubList(int[] v) {
        int[] sums = new int[v.length];
        int sum = 0;

        for (int i = 0; i < v.length; i++) {
            sum = sum + v[i];

            for (int elem : sums ) {
                if (elem == sum) {
                    return true;
                }
            }
            sums[i] = sum;
        }

        return false;
    }

    public static void main(String[] args) throws Exception {        
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        StringTokenizer stringTokenizer = new StringTokenizer(input);
        int n = stringTokenizer.countTokens();
        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt((String) stringTokenizer.nextElement());
        }

        sc.close();

        boolean result = hasZeroSumSubList(arr);

        if (result)
        {
            System.out.println("True\n");
        }
        else
        {
            System.out.println("False\n");
        }

    }
}
// input example = 3 4 -7 3 1 3 1 -4 -2 -2