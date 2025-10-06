public class mini_no_coin {
    // Coin Change Problem (minimum number of coins)
    static int minicoin(int []coin ,int sum){
        int [][]cache=new int [coin.length+1][sum+1];
        for(int j=0;j<sum+1;j++){
            cache[0][j]=Integer.MAX_VALUE-1;
        }
        for(int i=1;i<coin.length+1;i++){
            cache[i][0]=0;
        }
        for (int i=1;i<sum+1;i++){
            if(i%coin[0]==0) {
                cache[1][i] = i / coin[0];
            }else{
                cache[1][i]=Integer.MAX_VALUE-1;
            }
        }
        for(int i=2;i<coin.length+1;i++){
            for(int j=1;j<sum+1;j++){
                if(coin[i-1]<=j){
                    cache[i][j]=Math.min(cache[i][j-coin[i-1]]+1,cache[i-1][j]);
                }else{
                    cache[i][j]=cache[i-1][j];
                }
            }
        }
        return cache[coin.length][sum];
    }

    public static void main(String[] args) {
//        int coins[] = {1, 2, 3};
        int coins[] = {1, 2, 5};
        int amount = 11;
        System.out.println(minicoin(coins,amount));
    }
}
