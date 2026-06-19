import java.util.*;

class Item {
    int weight, profit;
    double ratio;

    Item(int weight, int profit) {
        this.weight = weight;
        this.profit = profit;
        this.ratio = (double) profit / weight;
    }
}

class Node {
    int level;
    int profit;
    int weight;
    double bound;
}

public class Knapsack {

    static double bound(Node u, int n, int W, Item[] items) {
        if (u.weight >= W)
            return 0;

        double profitBound = u.profit;
        int j = u.level + 1;
        int totalWeight = u.weight;

        while (j < n && totalWeight + items[j].weight <= W) {
            totalWeight += items[j].weight;
            profitBound += items[j].profit;
            j++;
        }

        if (j < n)
            profitBound += (W - totalWeight) * items[j].ratio;

        return profitBound;
    }

    static int knapsack(int W, Item[] items, int n) {

        Arrays.sort(items, (a, b) -> Double.compare(b.ratio, a.ratio));

        Queue<Node> q = new LinkedList<>();

        Node u = new Node();
        Node v = new Node();

        v.level = -1;
        v.profit = 0;
        v.weight = 0;
        v.bound = bound(v, n, W, items);

        q.offer(v);

        int maxProfit = 0;

        while (!q.isEmpty()) {

            v = q.poll();

            if (v.level == n - 1)
                continue;

            u = new Node();
            u.level = v.level + 1;

            // Include item
            u.weight = v.weight + items[u.level].weight;
            u.profit = v.profit + items[u.level].profit;

            if (u.weight <= W && u.profit > maxProfit)
                maxProfit = u.profit;

            u.bound = bound(u, n, W, items);

            if (u.bound > maxProfit)
                q.offer(u);

            // Exclude item
            u = new Node();
            u.level = v.level + 1;
            u.weight = v.weight;
            u.profit = v.profit;
            u.bound = bound(u, n, W, items);

            if (u.bound > maxProfit)
                q.offer(u);
        }

        return maxProfit;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        Item[] items = new Item[n];

        System.out.println("Enter weight and profit of each item:");

        for (int i = 0; i < n; i++) {
            int weight = sc.nextInt();
            int profit = sc.nextInt();
            items[i] = new Item(weight, profit);
        }

        System.out.print("Enter knapsack capacity: ");
        int W = sc.nextInt();

        int result = knapsack(W, items, n);

        System.out.println("Maximum Profit = " + result);

        sc.close();
    }
}
