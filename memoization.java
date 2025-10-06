import java.util.Arrays;

public class memoization {
     // Global Matrix works as a cache memory

    static int memoize(int[]wt,int[]val,int w,int n,int[][]arr){
        if(w==0||n==0){
            return 0;
        }
        if(arr[n][w]!=-1){   // Returns element if present in the array prevents repeating call.
            return arr[n][w];
        }
        if(wt[n-1]<=w){  // Choice Diagram
             return arr[n][w]=Math.max(val[n-1]+memoize(wt,val,w-wt[n-1],n-1,arr),
                    memoize(wt,val,w,n-1,arr));
        }else{  // No Choice
            return arr[n][w]= memoize(wt,val,w,n-1,arr);
        }
    }

public static void main(String[] args) {
        int []wt={1,3,4,5};
         int[] val={1,4,5,7};
         int W=8;
         int [][] arr=new int[5][9];
         for(int i=0;i<=wt.length;i++){
             Arrays.fill(arr[i],-1);   // Initialization of cache matrix
         }

    System.out.println(memoize(wt,val,W,wt.length,arr));

    }
}
