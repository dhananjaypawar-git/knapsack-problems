public class subsetSumProblem {
    static Boolean subsetSum(int[]arr,int capacity,int n) {
        boolean[][] cache = new boolean[n + 1][capacity + 1];  // Creating a TopDown matrix
        // Global Matrix works as a cache memory
        for (int i = 0; i < arr.length+1; i++) {       // Initialization of cache matrix
            for (int j = 0; j < capacity+1; j++) {   // Initialisation loop (Base condition)
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

//        // Traceback to find the subset elements
//        System.out.print("Subset elements: ");
//        int i = n, j = capacity;
//        while (i > 0 && j > 0) {
//            if (cache[i][j] && !cache[i - 1][j]) {
//                System.out.print(arr[i - 1] + " ");
//                j = j - arr[i - 1];
//            }
//            i--;
//        }
//        System.out.println();
        return  cache[n][capacity];
    }

    // for print subset :

    // If no subset is found
//    if (!cache[n][capacity]) {
//        System.out.println("No subset found");
//        return false;
//    }
//
//    // Traceback to find the subset elements
//    System.out.print("Subset elements: ");
//    int i = n, j = capacity;
//    while (i > 0 && j > 0) {
//        if (cache[i][j] && !cache[i - 1][j]) {
//            System.out.print(arr[i - 1] + " ");
//            j = j - arr[i - 1];
//        }
//        i--;
//    }



    public static void main(String[] args) {
        int []wt={2,3,7,8,10};
        int W=11;
        System.out.println(subsetSum(wt,W,wt.length) );
    }
}
