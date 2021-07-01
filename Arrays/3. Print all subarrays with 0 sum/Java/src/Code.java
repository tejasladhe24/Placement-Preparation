import java.util.StringTokenizer;
import java.util.Scanner;

public class Code {

    public static Scanner sc = new Scanner(System.in);

    public static int[] inputArray() {
        String input = sc.nextLine();
        StringTokenizer stringTokenizer = new StringTokenizer(input);
        int counts = stringTokenizer.countTokens();

        int[] arr = new int[counts];

        for (int i = 0; i < counts; i++) {
            arr[i] = Integer.parseInt((String)stringTokenizer.nextElement());
        }
        
        return arr;
    }

    public static void TwoElemsSubArrays(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i] + arr[j] == 0) {
                    System.out.println("(" + arr[i] + ", " + arr[j] + ")");
                }
            }
        }
    }

    public static void ThreeElemsSubArrays(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                for (int k = j+1; k < arr.length; k++) {
                    if (arr[i] + arr[j] + arr[k] == 0) {
                        System.out.println("(" + arr[i] + ", " + arr[j] + ", " + arr[k] + ")");
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        int[] arr = inputArray();
        TwoElemsSubArrays(arr);
        ThreeElemsSubArrays(arr);

        sc.close();
    }
}

// Input Example - 4 2 -3 -1 0 -4
