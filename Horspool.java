import java.util.Scanner;

public class Horspool {

    // Main method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input text
        System.out.print("Enter Text : ");
        String text = sc.nextLine();

        // Input pattern
        System.out.print("Enter Pattern : ");
        String pattern = sc.nextLine();

        int n = text.length();
        int m = pattern.length();

        // Shift table
        int shift[] = new int[256];

        // Fill all values with pattern length
        for (int i = 0; i < 256; i++) {
            shift[i] = m;
        }

        // Create shift table
        for (int j = 0; j < m - 1; j++) {
            shift[pattern.charAt(j)] = m - 1 - j;
        }

        // Start matching from end of pattern
        int i = m - 1;

        while (i < n) {

            int j = 0;


            // Compare from right side
            while (j < m &&
                   pattern.charAt(m - 1 - j) == text.charAt(i - j)) {

                j++;
            }

            // Pattern found
            if (j == m) {
                System.out.println("Pattern found at position : " + (i - m + 1));
                return;
            }

            // Shift pattern
            i = i + shift[text.charAt(i)];
        }

        // Pattern not found
        System.out.println("Pattern not found");

        sc.close();
    }
}