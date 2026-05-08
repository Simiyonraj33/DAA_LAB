import java.util.*;

class InsertionSort {

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        // Read number of elements
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int A[] = new int[n];

        // Read array elements
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }

        // Insertion Sort
        for (int i = 1; i < n; i++) {

            int v = A[i];
            int j = i - 1;

            // Move greater elements one position ahead
            while (j >= 0 && A[j] > v) {

                A[j + 1] = A[j];
                j = j - 1;
            }

            // Insert element in correct position
            A[j + 1] = v;
        }

        // Display sorted array
        System.out.println("Sorted array:");

        for (int i = 0; i < n; i++) {
            System.out.print(A[i] + " ");
        }

        sc.close();
    }
}