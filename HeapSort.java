import java.util.*;

class HeapSort {

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        // Read number of elements
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        // Heap array (index starts from 1)
        int H[] = new int[n + 1];

        // Read elements
        System.out.println("Enter elements:");
        for (int i = 1; i <= n; i++) {
            H[i] = sc.nextInt();
        }

        // Heap Bottom-Up Algorithm
        for (int i = n / 2; i >= 1; i--) {

            int k = i;
            int v = H[k];

            boolean heap = false;

            while (!heap && 2 * k <= n) {

                int j = 2 * k;

                // Check right child
                if (j < n) {

                    if (H[j] < H[j + 1]) {
                        j = j + 1;
                    }
                }

                // Check heap condition
                if (v >= H[j]) {
                    heap = true;
                }
                else {

                    H[k] = H[j];
                    k = j;
                }
            }

            H[k] = v;
        }

        // Display heap
        System.out.println("Heap elements:");

        for (int i = 1; i <= n; i++) {
            System.out.print(H[i] + " ");
        }

        sc.close();
    }
}