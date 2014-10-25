package solution;

/**
 * Created by lakb2_000 on 2014/8/27.
 */
public class ClimbingStairs {

    public static void main(String[] args){
        ClimbingStairs solution = new ClimbingStairs() ;
        System.out.print(solution.climbStairs(44));
    }

    public int climbStairs(int n) {
        if(n == 0)
            return 0 ;
        if(n == 1)
            return 1 ;
        if(n == 2)
            return 2 ;
        int[] temp = new int[n] ;
        temp[0] = 1 ;
        temp[1] = 2 ;

        for(int i = 2 ; i < n ; i ++){
            temp[i] = temp[i - 1] + temp[i - 2] ;
        }
        return temp[n - 1] ;
    }


/***** Recursion Solution*****/
//    public int climbStairs(int n) {
//        if(n == 0)
//            return 0 ;
//        if(n == 1)
//            return 1 ;
//        if(n == 2)
//            return 2 ;
//
//        return climbStairs(n - 1) + climbStairs(n - 2) ;
//    }

}
