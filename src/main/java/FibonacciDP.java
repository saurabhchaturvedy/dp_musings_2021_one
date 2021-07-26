public class FibonacciDP {



    private static int nthFibonacci(int n)
    {
        int[]localState = new int[n+1];

        localState[0]=0;
        localState[1]=1;

        for(int i=2; i<=n; i++)
        {
            localState[i] = localState[i-1] + localState[i-2];
        }

        return localState[n];

    }


    public static void main(String[] args) {

        System.out.println(nthFibonacci(7));
    }
}
