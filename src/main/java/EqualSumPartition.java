public class EqualSumPartition {


    private static boolean equalSumPartition(int[] array) {
        int sum = 0;
        for (int k : array) {
            sum = sum + k;
        }

        if (sum%2==1) return false;

        boolean[][] localState = new boolean[array.length + 1][sum / 2 + 1];

        for (int i = 0; i <= array.length; i++) {
            for (int j = 0; j <= sum / 2; j++) {

                if (i == 0 || j == 0)
                    localState[i][j] = false;

                else if (array[i - 1] > j)
                    localState[i][j] = localState[i - 1][j];
                else if (array[i - 1] == 1)
                    localState[i][j] = true;
                else
                    localState[i][j] = localState[i - 1][j] || localState[i - 1][j - array[i - 1]];
            }
        }

        return localState[array.length][sum / 2];
    }


    public static void main(String[] args) {

        int[] array = {1,5,11,5};

        System.out.print(" is equal sum partition ? " + equalSumPartition(array));
    }
}
