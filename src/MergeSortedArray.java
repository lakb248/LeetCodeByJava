package solution;

/**
 * Created by lakb2_000 on 2014/8/27.
 */
public class MergeSortedArray {

    public void merge(int A[], int m, int B[], int n) {
        int pointer_a = 0 , pointer_b = 0 ;

        int[] temp = new int[m + n] ;
        int index = 0 ;

        while(pointer_a < m && pointer_b < n){
            if(A[pointer_a] <= B[pointer_b]){
                temp[index ++] = A[pointer_a++] ;
            }else{
                temp[index ++] = B[pointer_b ++] ;
            }
        }

        while(pointer_a < m){
            temp[index ++] = A[pointer_a ++] ;
        }

        while(pointer_b < n){
            temp[index ++] = B[pointer_b ++] ;
        }

        for(int i = 0 ; i < m + n ; i ++){
            A[i] = temp[i] ;
        }
    }

}
