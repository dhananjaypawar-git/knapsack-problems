public class equalSumPartition {
    static Boolean subsetSum(int[]arr,int capacity,int n) {

        boolean[][] cache = new boolean[n +1][capacity + 1];  // Creating a TopDown matrix
        // Global Matrix works as a cache memory
        for (int i = 0; i < arr.length; i++) {       // Initialization of cache matrix
            for (int j = 0; j < capacity; j++) {   // Initialisation loop (Base condition)
                if (i == 0) cache[i][j] =false ;
                if (j == 0) cache[i][j] =true ;
            }
        }
        for (int i = 1; i < n + 1; i++) {     // Choice Diagram
            for (int j = 1; j < capacity + 1; j++) {
                if (arr[i - 1] <= j) {      // Choice
                    cache[i][j] =  cache[i-1][j- arr[i - 1]]|| cache[i - 1][j];
                } else {  // No choice
                    cache[i][j] = cache[i - 1][j];
                }
            }
        }
        return cache[n][capacity];
    }
    static boolean equalSumPartition(int []arr){
        long sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
        }
        if(sum%2!=0){
            return false;
        }
        else {
           if( subsetSum(arr,(int)sum/2,arr.length)){
               return true;
           }
           else {
               return false;
           }
        }
    }

    public static void main(String[] args) {
        int []wt={1,5,12,3,6,3};
        int W=11;
        System.out.println(equalSumPartition(wt));
    }
}
