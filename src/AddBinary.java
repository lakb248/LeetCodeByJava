package solution;

/**
 * Created by lakb2_000 on 2014/9/8.
 */
/**

 Given two binary strings, return their sum (also a binary string).

 For example,
 a = "11"
 b = "1"
 Return "100"

 */


public class AddBinary {

    public static void main(String[] args){
        AddBinary add = new AddBinary() ;
        System.out.print(add.addBinary("0","0")) ;
    }

    public String addBinary(String a, String b) {
        int la = a.length() , lb = b.length() ;

        if(la == 0 && lb == 0){
            return "0" ;
        }

        if(la == 0){
            return b ;
        }

        if(lb == 0){
            return  a ;
        }

        char[] ca = a.toCharArray() , cb = b.toCharArray() ;
        int length = la > lb ? (la + 1) : (lb + 1) ;
        char[] result = new char[length] ;
        char cura = ' ' , curb = ' ' ;
        int next = 0 ;
        int i = la - 1 , j = lb - 1 ;
        for(;i >= 0 && j >=0 ; i -- , j--){
            cura = ca[i] ;
            curb = cb[j] ;

            if((cura == '1' && curb == '0') || (cura == '0' && curb == '1')){
                if(next != 0) {
                    result[--length] = '0';
                }else{
                    result[--length] = '1' ;
                }
            }else if(cura == '0' && curb == '0'){
                if(next != 0){
                    result[--length] = '1' ;
                    next -- ;
                }else{
                    result[--length] = '0' ;
                }
            }else{
                if(next != 0){
                    result[--length] = '1' ;
                }else{
                    result[--length] = '0' ;
                    next ++ ;
                }
            }
        }

        while(i >= 0){
            cura = ca[i --] ;
            if(cura == '0'){
                if(next != 0){
                    result[--length] = '1' ;
                    next -- ;
                }else{
                    result[--length] = '0' ;
                }
            }else{
                if(next != 0){
                    result[--length] = '0' ;
                }else{
                    result[--length] = '1' ;
                }
            }
        }

        while(j >= 0){
            curb = cb[j --] ;
            if(curb == '0'){
                if(next != 0){
                    result[--length] = '1' ;
                    next -- ;
                }else{
                    result[--length] = '0' ;
                }
            }else{
                if(next != 0){
                    result[--length] = '0' ;
                }else{
                    result[--length] = '1' ;
                }
            }
        }

        if(next != 0){
            result[--length] = '1' ;
        }

        return String.valueOf(result).substring(length) ;
    }

    /*

    public String addBinary(String a, String b) {
        int m = a.length();
        int n = b.length();
        int carry = 0;
        String res = "";
        // the final length of the result depends on the bigger length between a and b,
        // (also the value of carry, if carry = 1, add "1" at the head of result, otherwise)
        int maxLen = Math.max(m, n);
        for (int i = 0; i < maxLen; i++) {
            // start from last char of a and b
            // notice that left side is int and right side is char
            // so we need to  minus the decimal value of '0'
            int p = i < m ? a.charAt(m - 1 - i) - '0' : 0;
            int q = i < n ? b.charAt(n - 1 - i) - '0' : 0;
            int tmp = p + q + carry;
            carry = tmp / 2;
            res = tmp % 2 + res;
        }
        return (carry == 0) ? res : "1" + res;
    }

    */

}
