public class countofSSwithgivenSum {
    static int css(int[]arr,int sum,int n){
        int[][]cache=new int[n+1][sum+1];
        for(int i=0;i<n+1;i++){                                             // subset sum and count of subset with given sum is same problem
            for(int j=0;j<sum+1;j++){                                      //  (  || ---->  +  )  this is a minor change
                if(i==0) cache[i][j]=0;
                if(j==0) cache[i][j]=1;
            }
        }
        for(int i=1;i<n+1;i++) {
            for (int j = 1; j < sum+1; j++) {
                if(arr[i-1]<=j){
                cache[i][j]=cache[i-1][j-arr[i-1]]+cache[i-1][j];
                }
                else {
                    cache[i][j]=cache[i-1][j];
                }
            }
        }
        return cache[n][sum];
    }
    static int subsetSum(int[]arr,int capacity,int n) {
        int[][] cache = new int[n + 1][capacity + 1];  // Creating a TopDown matrix
        // Global Matrix works as a cache memory
        for (int i = 0; i < arr.length; i++) {       // Initialization of cache matrix
            for (int j = 0; j < capacity; j++) {   // Initialisation loop (Base condition)
                if (i == 0) cache[i][j] = 0;
                if (j == 0) cache[i][j] = 1;
            }
        }
        for (int i = 1; i < n + 1; i++) {     // Choice Diagram
            for (int j = 1; j < capacity + 1; j++) {
                if (arr[i - 1] <= j) {      // Choice
                    cache[i][j] = cache[i - 1][j - arr[i - 1]] + cache[i - 1][j];
                } else {  // No choice
                    cache[i][j] = cache[i - 1][j];
                }
            }
        }
        return cache[n][capacity];
    }
    public static void main(String[] args) {
    int []arr={2, 3, 5, 6, 8, 10};
    int sum=22;
        System.out.println(css(arr,sum,arr.length));
    }
}
