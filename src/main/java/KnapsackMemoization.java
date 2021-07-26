import java.util.Arrays;

public class KnapsackMemoization {


    static int[][]localState;
    private static int knapsackMemoization(int[]weight,int values[],int W,int n)
    {
        if(W==0 || n==0) return 0;
        if(localState[n][W]!=-1) return localState[n][W];

        if(W-weight[n-1]>W) {
            localState[n][W] = knapsackMemoization(weight, values, W, n - 1);
        }
        else {
            localState[n][W] = Math.max(knapsackMemoization(weight, values, W, n - 1), values[n - 1] + knapsackMemoization(weight, values, W - weight[n - 1], n - 1));

        }

        return localState[n][W];
    }


    public static void main(String[] args) {
        int value[] = {60, 100, 120};
        int weight[] = {10, 20, 30};
        int W = 50;
        localState=new int[weight.length+1][W+1];
        Arrays.stream(localState).forEach(x->Arrays.fill(x,-1));

        System.out.println(knapsackMemoization(weight,value,W, weight.length));

    }
}
