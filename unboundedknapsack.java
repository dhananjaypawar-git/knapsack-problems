public class unboundedknapsack {

    static int unbounded(int[]wt,int []val,int w,int n){
        int[][] cache=new int[n+1][w+1];
        // initialisation
        for (int i = 0; i <n+1 ; i++) {
            for (int j = 0; j <w+1 ; j++) {
                if(i==0||j==0) cache[i][j]=0;
                if(i>=1&&j!=0) break;
            }
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<w+1;j++){
                if(wt[i-1]<=j){
                    cache[i][j]=Math.max(val[i-1]+cache[i][j-wt[i-1]],cache[i-1][j]);
                }else {
                    cache[i][j]=cache[i-1][j];
                }
            }
        }
        return cache[n][w];

    }
    public static void main(String[] args) {

        int weights[] = {2, 3, 4, 5};
       int  values[] = {3, 4, 5, 6};
        int capacity = 8;
        System.out.println(unbounded(weights,values,capacity,weights.length));
    }
}
