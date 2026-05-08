import java.util.*;

class QuickSort {

    // Quick Sort Function
    static void quickSort(int a[], int l, int r) {

        if (l < r) {

            // Find partition position
            int s = hoarePartition(a, l, r);

            // Sort left part
            quickSort(a, l, s - 1);

            // Sort right part
            quickSort(a, s + 1, r);
        }
    }

    // Hoare Partition Function
    static int hoarePartition(int a[], int l, int r) {

        // First element as pivot
        int p = a[l];

        int i = l + 1;
        int j = r;

        while (i <= j) {

            // Move i to right
            while (i <= r && a[i] < p) {
                i++;
            }

            // Move j to left
            while (a[j] > p) {
                j--;
            }

            // Swap elements
            if (i < j) {

                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;

                i++;
                j--;
            }
        }

        // Place pivot in correct position
        int temp = a[l];
        a[l] = a[j];
        a[j] = temp;

        return j;
    }

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        // Read size
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int a[] = new int[n];

        // Read array elements
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        // Call quick sort
        quickSort(a, 0, n - 1);

        // Display sorted array
        System.out.println("Sorted array:");
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }

        sc.close();
    }
}