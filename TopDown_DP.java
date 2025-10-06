public class TopDown_DP {

    static int topDown(int[]wt,int[]val,int capacity,int n){
        int[][] cache=new int[n+1][capacity+1];  // Creating a TopDown matrix
        // Global Matrix works as a cache memory
        for(int i=0;i<wt.length+1;i++){       // Initialization of cache matrix
            for(int j=0;j<capacity+1;j++) {   // Initialisation loop (Base condition)
                if (i == 0 || j == 0) cache[i][j] = 0;
            }
        }
        for(int i=1;i<n+1;i++){     // Choice Diagram
            for(int j=1;j<capacity+1;j++){
                if(wt[i-1]<=j){      // Choice
                cache[i][j]= Math.max(val[i-1]+cache[i-1][j-wt[i-1]],
                            cache[i-1][j]);
                }
                else {  // No choice
                    cache[i][j]= cache[i-1][j];
                }
            }
        }
        return cache[n][capacity];
    }
    public static void main(String[] args) {
        int []wt={1,3,4,5};
        int[] val={1,4,5,7};
        int W=8;
        System.out.println(topDown(wt,val,W,wt.length));
    }
}
