import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Code {
    public static void printArray(List<Integer> arr) {
        for (int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i) + " ");
        }
        System.out.println("\n");
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        StringTokenizer stringTokenizer = new StringTokenizer(input);
        int counts = stringTokenizer.countTokens();

        List<Integer> arr = new ArrayList<>(counts);

        for (int i = 0; i < counts; i++) {
            arr.add(Integer.parseInt((String) stringTokenizer.nextElement()));
        }

        List<Integer> temp = new ArrayList<>();

        for (int i = 0; i < arr.size(); i++) {
            if (!temp.contains(arr.get(i))) {
                temp.add(arr.get(i));
            }
        }

        printArray(temp);

        sc.close();
    }
}

// Input example - 1 2 3 4 2 2 3 4 1
