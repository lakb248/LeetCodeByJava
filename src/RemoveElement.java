package solution;

/**
 * Created by lakb2_000 on 2014/8/29.
 */
public class RemoveElement {

    public int removeElement(int[] A, int elem) {
        int length = A.length ;

        int newLength = length ;
        for(int i = 0 ; i < newLength ; i ++){
            if(A[i] == elem){
                int temp = A[i] ;
                A[i] = A[--newLength] ;
                A[newLength] = temp ;
                i -- ;
            }
        }

        return newLength ;
    }

}
