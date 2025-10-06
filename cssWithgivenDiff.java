public class cssWithgivenDiff {
    static int ccwd(int []arr,int diff){
        int sum=0;
        for (int i=0;i<arr.length;i++){
            sum+=arr[i];
        }
        if ((diff + sum) % 2 != 0) return 0;
        return css(arr,(diff+sum)/2,arr.length);
    }
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
    public static void main(String[] args) {
        int[]arr={1,1,2,3};
        int[]arr1={1, 2, 7, 1, 5};
        int diff=1;
        int diff1=3;
        System.out.println(ccwd(arr,diff));
    }
}
