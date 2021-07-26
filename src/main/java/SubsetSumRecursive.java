public class SubsetSumRecursive {


    private static boolean subsetSum(int[] arr, int sum, int n) {

        if (sum == 0) return true;
        if (n == 0 && sum != 0) return false;

        if (arr[n - 1] > sum)
            return subsetSum(arr, sum, n - 1);

        return subsetSum(arr, sum, n - 1) || subsetSum(arr, sum - arr[n - 1], n - 1);

    }


    public static void main(String[] args) {
        int[] arr = {2, 3, 5};
        int sum = 8;

        System.out.println(subsetSum(arr, sum, arr.length));
    }
}
