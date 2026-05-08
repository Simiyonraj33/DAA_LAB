import java.util.*;

class MergeSort {

    // Function to divide array
    static void mergeSort(int a[], int low, int high) {

        // Check if more than one element
        if (low < high) {

            // Find middle
            int mid = (low + high) / 2;

            // Sort left half
            mergeSort(a, low, mid);

            // Sort right half
            mergeSort(a, mid + 1, high);

            // Merge two halves
            merge(a, low, mid, high);
        }
    }

    // Function to merge two sorted arrays
    static void merge(int a[], int low, int mid, int high) {

        // Temporary array
        int temp[] = new int[a.length];

        int i = low;       // Left half starting index
        int j = mid + 1;   // Right half starting index
        int k = low;       // Temp array index

        // Compare elements and store smaller one
        while (i <= mid && j <= high) {

            if (a[i] < a[j]) {
                temp[k] = a[i];
                i++;
            }
            else {
                temp[k] = a[j];
                j++;
            }

            k++;
        }

        // Copy remaining left half elements
        while (i <= mid) {
            temp[k] = a[i];
            i++;
            k++;
        }

        // Copy remaining right half elements
        while (j <= high) {
            temp[k] = a[j];
            j++;
            k++;
        }

        // Copy sorted elements back to original array
        for (i = low; i <= high; i++) {
            a[i] = temp[i];
        }
    }

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        // Read number of elements
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int a[] = new int[n];

        // Read array elements
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        // Call merge sort
        mergeSort(a, 0, n - 1);

        // Display sorted array
        System.out.println("Sorted array:");
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }

        sc.close();
    }
}