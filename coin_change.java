public class coin_change {
    // Coin Change Problem (counting the number of ways to make change)
    // Problem is as same as count of subset sum problem
    static int coinchange(int [] wt,int sum){
        int[][] cache=new int [wt.length+1][sum+1];   // DP matrix
        for(int i=0;i<wt.length+1;i++){
            for(int j=0;j<sum+1;j++){
                if(i==0) cache[i][j]=0;
                if(j==0) cache[i][j]=1;
                if(j>=1&&i>=1) break;
            }
        }
        for(int i=1;i<wt.length+1;i++){
            for(int j=1;j<sum+1;j++){
                if(wt[i-1]<=j){
                    cache[i][j]=cache[i][j-wt[i-1]]+cache[i-1][j];
                }else{
                    cache[i][j]=cache[i-1][j];
                }
            }
        }
        return cache[wt.length][sum];
    }

    public static void main(String[] args) {
        int coins[] = {1, 2, 5};
        int amount = 5;


        System.out.println( coinchange(coins,amount));
    }
}
