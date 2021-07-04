import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Code {

    public static Scanner sc = new Scanner(System.in);
    
    public static void printMatrix(int[][] matrix) {
        System.out.println("\n");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println("\n");
        }
    }

    public static void printList(List<Integer> arr) {
        System.out.println("\n");
        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i) + " ");
        }
        System.out.println("\n");
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

    public static int[][] Spiral(List<Integer> arr, int m, int n) {
        return createSpiral(arr, m, n);
    }


    public static List<Integer> shiftArray(List<Integer> arr, int steps) {
        List<Integer> temp = new ArrayList<>(arr.size());

        for (int i = arr.size()-steps; i < arr.size(); i++) {
            temp.add(arr.get(i));
        }

        for (int i = 0; i < arr.size()-steps; i++) {
            temp.add(arr.get(i));
        }

        return temp;
    }
    
    public static int[][] shiftedSpiral(List<Integer> arr, int m, int n) {
        arr = shiftArray(arr, 1);
        return createSpiral(arr, m, n);
    }
    public static void main(String[] args) throws Exception {
        System.out.print("m: ");
        int m = sc.nextInt();
        System.out.print("n: ");
        int n = sc.nextInt();
        List<Integer> arr = createList(m, n);

        int[][] matrix1 = Spiral(arr, m, n);
        int[][] matrix2 = shiftedSpiral(arr, m, n);

        printMatrix(matrix1);
        printMatrix(matrix2);

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