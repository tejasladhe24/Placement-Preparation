import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Code {
    public static Scanner sc = new Scanner(System.in);

    public static void printArray(List<Integer> arr) {
        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i) + " ");
        }
    }

    public static List<Integer> binSort(List<Integer> arr) {
        List<Integer> result = new ArrayList<Integer>(); 
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) == 0) {
                result.add(0);
            }
        }

        int size = result.size();

        for (int i = 0; i < arr.size() - size; i++) {
            result.add(1);
        }

        return result;
    }
    public static void main(String[] args) throws Exception {
        StringTokenizer stringTokenizer = new StringTokenizer(sc.nextLine());
        int counts = stringTokenizer.countTokens();

        List<Integer> arr = new ArrayList<>(counts);

        for (int i = 0; i < counts; i++) {
            arr.add(Integer.parseInt((String) stringTokenizer.nextElement()));
        }

        List<Integer> result = binSort(arr);;

        printArray(result);

        sc.close();
    }
}

// Input example - 1 0 1 0 1 0 0 1
