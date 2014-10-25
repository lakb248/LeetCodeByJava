package solution;

/**
 * Created by lakb2_000 on 2014/10/21.
 *
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.
 * For example, given the array [2,3,-2,4],
 * the contiguous subarray [2,3] has the largest product = 6.
 *
 */

public class MaximumProductSubarray {

    public static void main(String[] args){
        int[] num = {2,3,-4,6} ;
        System.out.print(new MaximumProductSubarray().maxProduct(num));
    }

    public int maxProduct(int[] A){
        if(A.length == 0)
            return 0 ;

        int max = A[0] ;
        int min = A[0] ;
        int result = A[0] ;
        int length = A.length ;
        int maxNow , minNow ;
        for(int i = 1 ; i < length ; i ++){
            maxNow = Math.max(Math.max(max * A[i] , min * A[i]) , A[i]) ;
            minNow = Math.min(Math.min(max * A[i] , min * A[i]) , A[i]) ;
            result = Math.max(maxNow , result) ;
            max = maxNow ;
            min = minNow ;
        }
        return result ;
    }

}
