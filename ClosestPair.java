import java.util.*;

class ClosestPair {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of points: ");
        int n = sc.nextInt();

        int x[] = new int[n];
        int y[] = new int[n];

        System.out.println("Enter x and y coordinates:");

        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }

        double min = Double.MAX_VALUE;

        System.out.println("\nDistances between all pairs:\n");

        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j < n; j++) {

                double d = Math.sqrt(
                        (x[i] - x[j]) * (x[i] - x[j]) +
                        (y[i] - y[j]) * (y[i] - y[j])
                );

                System.out.println(
                        "Distance between (" + x[i] + "," + y[i] + 
                        ") and (" + x[j] + "," + y[j] + 
                        ") = " + d
                );

                if (d < min) {
                    min = d;
                }
            }
        }

        System.out.println("\nMinimum distance = " + min);

        sc.close();
    }
}
