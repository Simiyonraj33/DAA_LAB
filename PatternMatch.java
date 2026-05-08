import java.util.*;

class PatternMatching {
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        char text[] = new char[50];
        char pattern[] = new char[50];

        System.out.print("Enter text: ");
        String s1 = sc.nextLine();

        System.out.print("Enter pattern: ");
        String s2 = sc.nextLine();

        // Store characters in array
        int n = 0;
        for (char ch : s1.toCharArray()) {
            text[n] = ch;
            n++;
        }

        int m = 0;
        for (char ch : s2.toCharArray()) {
            pattern[m] = ch;
            m++;
        }

        boolean found = false;

        for (int i = 0; i <= n - m; i++) {

            int j = 0;

            while (j < m && text[i + j] == pattern[j]) {
                j++;
            }

            if (j == m) {
                System.out.println("Pattern found at position " + i);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Pattern not found");
        }

        sc.close();
    }
}