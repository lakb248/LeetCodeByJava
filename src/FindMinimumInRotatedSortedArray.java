package solution;

/**
 * Created by lakb2_000 on 2014/10/19.
 */

/**
 Suppose a sorted array is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 Find the minimum element.

 You may assume no duplicate exists in the array.
 **/

public class FindMinimumInRotatedSortedArray {

    public static void main(String[] args){

        FindMinimumInRotatedSortedArray find = new FindMinimumInRotatedSortedArray() ;
        int[] num = {4,5,6,1,2,3} ;
        System.out.print(find.findMin(num));

    }

    public int findMin(int[] num) {

        int start = 0 , end = num.length - 1 ;
        int mid = start;

        while(num[start] >= num[end]){
            if((end - start) == 1)
                return num[end] ;
            mid = (end + start) / 2 ;
            if(num[start] == num[end] && num[start] == num[mid]){
                return minInOrder(num,start,end) ;
            }
            if(num[mid] >= num[start])
                start = mid ;
            else if(num[mid] <= num[end]){
                end = mid ;
            }
        }

        return num[mid] ;

    }

    public int minInOrder(int[] num , int start , int end){
        int result = num[start] ;
        for(int i = 0 ; i <= end ; i ++){
            if(num[i] < result){
                result = num[i] ;
            }
        }
        return result ;
    }

}
