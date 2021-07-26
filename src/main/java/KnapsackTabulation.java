import java.util.Arrays;

public class KnapsackTabulation {


    private static int knapsackTabulation(int[] weight, int[] values, int W, int n) {

        int[][] localState = new int[n + 1][W + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= W; j++) {
                if (i == 0 || j == 0) {
                    localState[i][j] = 0;
                } else if (weight[i - 1] > j) {
                    localState[i][j] = localState[i - 1][j];

                } else {
                    localState[i][j] = Math.max(localState[i - 1][j], values[i - 1] + localState[i - 1][j - weight[i - 1]]);
                }
            }
        }
        return localState[n][W];
    }


    public static void main(String[] args) {

        int values[] = {60, 100, 120};
        int weight[] = {10, 20, 30};
        int W = 50;
        int maximizedProfit = knapsackTabulation(weight, values, W, weight.length);
        System.out.println(" Maximized profit : " + maximizedProfit);

    }
}
