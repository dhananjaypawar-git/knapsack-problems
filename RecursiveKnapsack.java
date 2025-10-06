import java.util.Arrays;

public class RecursiveKnapsack {

    static int recursive01(int[]wt,int[]val,int W,int n) {
        if (n == 0 || W == 0) {
            return 0;
        }
        if (wt[n - 1] <= W) {  // Choice either take it or not.
            return Math.max(val[n - 1] + recursive01(wt, val, W - wt[n - 1],
                    n - 1), recursive01(wt, val, W, n - 1));
        } else { // No choice because it is overloaded than knapsack capacity
            return  recursive01(wt, val, W, n - 1);
        }
    }
    public static void main(String[] args) {
        int[][] arr=new int [5][4];
        for (int i = 0; i < arr.length; i++) {
            Arrays.fill(arr[i], -1); // fill each row with 7
        }
//        System.out.println(Arrays.deepToString(arr)); // for printing multidimensional array

//        System.out.println(sr.length);
    int []wt={1,1};
    int[] val={1,2};
    int W=6;
        System.out.println(recursive01(wt,val,W,wt.length));
    }

}
