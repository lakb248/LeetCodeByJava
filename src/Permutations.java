package solution;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lakb2_000 on 2014/9/4.
 */
public class Permutations {

    public static void main(String[] args){
        Permutations permutations = new Permutations() ;
//        permutations.allRange(new int[]{1,3,3} , 0);
    }

    public List<List<Integer>> permute(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>() ;

        allRange(result , num , 0);

        return result ;
    }

    public void allRange(List<List<Integer>> result , int[] list , int start){
        int length = list.length ;

        if(start == length - 1){
            ArrayList<Integer> item = new ArrayList<Integer>() ;
            for (int i = 0 ; i < length ; i ++){
                item.add(list[i]);
            }
            result.add(item);
        }else{
            for(int i = start ; i <= length - 1 ; i ++){
                if(canSwap(list,start,i)){
                    swap(list,start,i);
                    allRange(result ,list,start + 1);
                    swap(list,start,i);
                }
            }
        }


    }

    public boolean canSwap(int[] list,int start,int end){
        for(int i = start ; i < end ; i ++){
            if(list[i] == list[end])
                return false ;
        }
        return true ;
    }

    public void swap(int[] list , int start , int end){
        int temp = list[start] ;
        list[start] = list[end] ;
        list[end] = temp ;
    }

}
