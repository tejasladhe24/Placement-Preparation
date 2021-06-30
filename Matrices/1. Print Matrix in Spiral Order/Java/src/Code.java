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

    public static int[][] createMatrix(int m, int n) {
        int[][] matrix = new int[m][n];

        String ws = sc.nextLine(); // Removes initial whitespace; similar to 'cin>>ws;' in cpp code

        for (int i = 0; i < m; i++) {
            String input = sc.nextLine();
            StringTokenizer stringTokenizer = new StringTokenizer(input);
            int counts = stringTokenizer.countTokens();
            for (int j = 0; j < counts; j++) {
                matrix[i][j] = Integer.parseInt((String)stringTokenizer.nextElement()); 
            }
        }

        return matrix;
    }

    public static List<Integer> Spiral(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> arr = new ArrayList<Integer>(m*n);

        int s = 0;
        while (arr.size() < m * n)
        {
            for (int i = s; i < n - s; i++) // Horizontal Top
            {
                arr.add(matrix[s + 0][i]);
            }
            if (arr.size() == m * n)
                break;

            for (int i = s + 1; i < m - 1 - s; i++) // Vertical Right
            {
                arr.add(matrix[i][n - 1 - s]);
            }
            if (arr.size() == m * n)
                break;

            for (int i = s; i < n - s; i++) // Horizontal Bottom
            {
                arr.add(matrix[m - 1 - s][n - 1 - i]);
            }
            if (arr.size() == m * n)
                break;

            for (int i = s + 1; i < m - 1 - s; i++) // Vertical Left
            {
                arr.add(matrix[m - 1 - i][s + 0]);
            }
            if (arr.size() == m * n)
                break;

            s += 1; //  Increase depth by 1
        }

        return arr;
    }
    public static void main(String[] args) throws Exception {
        System.out.print("m: ");
        int m = sc.nextInt();
        System.out.print("n: ");
        int n = sc.nextInt();

        int[][] matrix = createMatrix(m, n);
        List<Integer> arr = Spiral(matrix);

        printList(arr);

        sc.close();

    }
}

/*
Example inputs - 

5
5
1 2 3 4 5
16 17 18 19 6
15 24 25 20 7
14 23 22 21 8
13 12 11 10 9

3
9
1 2 3 4 5 6 7 8 9
20 21 22 23 24 25 26 27 10
19 18 17 16 15 14 13 12 11

9
3
1 2 3
20 21 4
19 22 5
18 23 6
17 24 7
16 25 8
15 26 9
14 27 10 
13 12 11

//*/