public class cutting_rod {

    // Problem is like a standard unbounded knapsack problem (we can the repetitive lengths of rod)
    static int cuttingrod(int []wt,int []val,int w){
        int[][] cache=new int[wt.length+1][w+1];
        for(int i=0;i<wt.length+1;i++){
            for(int j=0;j<w+1;j++){
                if(i==0 ||j==0) cache[i][j]=0;
                if(i>=1&&j!=0) break;
            }
        }
        for(int i=1;i<wt.length+1;i++){
            for(int j=1;j<w+1;j++){
                if(wt[i-1]<=j){
                    cache[i][j]=Math.max(val[i-1]+cache[i][j-wt[i-1]],cache[i-1][j]);
                }else {
                    cache[i][j]=cache[i-1][j];
                }
            }
        }
        return cache[wt.length][w];
    }

    public static void main(String[] args) {
        int lengths[] = {1, 2, 3, 4, 5, 6, 7, 8};
        int prices[] = {1, 5, 8, 9, 10, 17, 17, 20};
        int rodLength = 8 ;
        System.out.println(cuttingrod(lengths,prices,rodLength));
    }
}
