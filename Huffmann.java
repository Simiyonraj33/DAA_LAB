import java.util.PriorityQueue;
import java.util.Scanner;

// Node class
class Node {

    char ch;              // Character
    double freq;          // Frequency

    Node left;            // Left child
    Node right;           // Right child

    // Constructor
    Node(char c, double f) {
        ch = c;
        freq = f;
        left = null;
        right = null;
    }
}

public class Huffmann {

    // Function to print Huffman Codes
    static void printCode(Node root, String code) {

        // Check leaf node
        if (root.left == null && root.right == null) {

            System.out.println(root.ch + " : " + code);
            return;
        }

        // Traverse left
        printCode(root.left, code + "0");

        // Traverse right
        printCode(root.right, code + "1");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input number of characters
        System.out.print("Enter number of characters : ");
        int n = sc.nextInt();

        // Priority Queue
        // Small frequency has high priority
        PriorityQueue<Node> pq =
                new PriorityQueue<>(
                        (a, b) -> Double.compare(a.freq, b.freq)
                );

        // Input characters and frequencies
        for (int i = 0; i < n; i++) {

            System.out.print("Enter character : ");
            char ch = sc.next().charAt(0);

            System.out.print("Enter frequency : ");
            double freq = sc.nextDouble();

            // Add node to queue
            pq.add(new Node(ch, freq));
        }

        // Build Huffman Tree
        while (pq.size() > 1) {

            // Remove 2 minimum nodes
            Node left = pq.poll();
            Node right = pq.poll();

            // Create new parent node
            Node newNode =
                    new Node('-', left.freq + right.freq);

            // Connect children
            newNode.left = left;
            newNode.right = right;

            // Add again to queue
            pq.add(newNode);
        }

        // Final node is root
        Node root = pq.poll();

        // Print Huffman Codes
        System.out.println("\nHuffman Codes :");
        printCode(root, "");

        sc.close();
    }
}