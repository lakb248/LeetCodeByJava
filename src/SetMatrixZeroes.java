package solution;

/**
 * Created by lakb2_000 on 2014/8/26.
 */
public class SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {
        int m = matrix.length , n = matrix[0].length ;
        String[] array = new String[m + n] ;
        int index = -1 ;
        for(int i = 0 ; i < m ; i ++){
            for(int j = 0 ; j < n ; j ++){
                if(matrix[i][j] == 0){
                    array[++index] = i + "," + j ;
                    if(index == (m + n -1))
                        break ;
                }
            }
        }

        int p , q ;

        for(int i = 0 ; i <= index ; i ++){
            p = Integer.valueOf(array[i].split(",")[0]) ;
            q = Integer.valueOf(array[i].split(",")[1]) ;

            for(int a = 0 ; a < n ; a ++){
                matrix[p][a] = 0 ;
            }

            for(int b = 0 ; b < m ; b ++){
                matrix[b][q] = 0 ;
            }
        }
    }

}
