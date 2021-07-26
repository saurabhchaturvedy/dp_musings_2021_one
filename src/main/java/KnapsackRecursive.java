public class KnapsackRecursive {


    static private int knapsack(int[] weight, int value[], int W, int n) {

        if (W == 0 || n == 0) return 0;

        if (W - weight[n - 1] > W)
            return knapsack(weight, value, W, n - 1);

        return Math.max(knapsack(weight, value, W, n - 1), value[n - 1] + knapsack(weight, value, W - weight[n - 1], n - 1));

    }


    public static void main(String[] args) {


        int value[] = {60, 100, 120};
        int weight[] = {10, 20, 30};
        int W = 50;


        System.out.println(" maximized profit is : " + knapsack(weight, value, 50, weight.length));

    }
}
