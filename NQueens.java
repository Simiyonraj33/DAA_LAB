import java.util.Scanner;

public class NQueens {

    // Array to store queen positions
    // x[k] = column number where queen is placed in kth row
    int[] x = new int[20];

    // Function to check whether queen can be placed
    boolean place(int k, int i) {

        // Check previously placed queens
        for (int j = 1; j <= k - 1; j++) {

            // Condition 1 : Same column
            // Condition 2 : Same diagonal
            if ((x[j] == i) ||
                (Math.abs(x[j] - i) == Math.abs(j - k))) {

                // Position is unsafe
                return false;
            }
        }

        // Position is safe
        return true;
    }

    // Recursive function for N-Queens using backtracking
    void nQueens(int k, int n) {

        // Try placing queen in every column
        for (int i = 1; i <= n; i++) {

            // Check whether queen can be placed
            if (place(k, i)) {

                // Place queen in kth row and ith column
                x[k] = i;

                // If all queens are placed
                if (k == n) {

                    // Print solution
                    printSolution(n);

                } else {

                    // Recursively place next queen
                    nQueens(k + 1, n);
                }
            }
        }
    }

    // Function to print chessboard solution
    void printSolution(int n) {

        System.out.println("\nSolution:");

        // Row loop
        for (int i = 1; i <= n; i++) {

            // Column loop
            for (int j = 1; j <= n; j++) {

                // Print Q where queen is placed
                if (x[i] == j)
                    System.out.print(" Q ");

                // Print . for empty space
                else
                    System.out.print(" . ");
            }

            // Move to next line after each row
            System.out.println();
        }
    }

    // Main method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read number of queens
        System.out.print("Enter number of queens: ");
        int n = sc.nextInt();

        // Create object
        NQueens obj = new NQueens();

        // Start placing queens from row 1
        obj.nQueens(1, n);

        sc.close();
    }
}