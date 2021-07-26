public class SubsetSumDP {


    private static boolean subsetSum(int[] arr, int sum, int n) {
        boolean[][] localState = new boolean[n + 1][sum + 1];

        for (int i = 0; i <= n; i++) {
            localState[i][0] = true;
        }

        for (int i = 1; i <= sum; i++) {
            localState[0][i] = false;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {

                if (arr[i - 1] > j) {
                    localState[i][j] = localState[i - 1][j];
                } else {
                    localState[i][j] = localState[i - 1][j] || localState[i - 1][j - arr[i - 1]];
                }
            }
        }
        return localState[n][sum];
    }


    public static void main(String[] args) {
        int[] arr = {2, 3, 5};
        int sum = 7;

        System.out.println(subsetSum(arr,sum, arr.length));
    }
}
