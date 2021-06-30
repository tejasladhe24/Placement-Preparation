import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Code {

    public static Scanner sc = new Scanner(System.in);
    
    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.println(matrix[i][j] + " ");
            }
            System.out.println("\n");
        }
    }

    public static void printList(List<Integer> arr) {
        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i) + " ");
        }
    }

    public static List<Integer> createList(int m, int n) {
        List<Integer> arr = new ArrayList<Integer>(m*n);

        String ws = sc.nextLine(); // Removes initial whitespace; similar to 'cin>>ws;' in cpp code

        String input = sc.nextLine();
        StringTokenizer stringTokenizer = new StringTokenizer(input);
        int counts = stringTokenizer.countTokens();

        for (int i = 0; i < counts; i++) {
            arr.add(Integer.parseInt((String) stringTokenizer.nextElement()));
        }

        return arr;
    }

    public static int[][] createSpiral(List<Integer> arr, int m, int n) {
        int[][] matrix = new int[m][n];

        int idx = 0;
        int s = 0;
        while (idx < m * n)
        {
            for (int i = s; i < n - s; i++) // Horizontal Top
            {
                matrix[s + 0][i] = arr.get(idx);
                idx = idx + 1;
            }
            if (idx == m * n)
                break;

            for (int i = s + 1; i < m - 1 - s; i++) // Vertical Right
            {
                matrix[i][n - 1 - s] = arr.get(idx);
                idx = idx + 1;
            }
            if (idx == m * n)
                break;

            for (int i = s; i < n - s; i++) // Horizontal Bottom
            {
                matrix[m - 1 - s][n - 1 - i] = arr.get(idx);
                idx = idx + 1;
            }
            if (idx == m * n)
                break;

            for (int i = s + 1; i < m - 1 - s; i++) // Vertical Left
            {
                matrix[m - 1 - i][s + 0] = arr.get(idx);
                idx = idx + 1;
            }
            if (idx == m * n)
                break;

            s += 1; //  Increase depth by 1
        }

        return matrix;
    }
    public static void main(String[] args) throws Exception {
        System.out.print("m: ");
        int m = sc.nextInt();
        System.out.print("n: ");
        int n = sc.nextInt();
        List<Integer> arr = createList(m, n);

        int[][] matrix = createSpiral(arr, m, n);

        printMatrix(matrix);

        sc.close();

    }
}

/*
Example inputs - 

5
5
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25

3
9
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27

9
3
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27


//*/