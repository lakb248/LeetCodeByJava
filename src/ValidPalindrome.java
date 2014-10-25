package solution;

/**
 * Created by lakb2_000 on 2014/8/27.
 */
public class ValidPalindrome {

    public static void main(String[] args){
        ValidPalindrome valid = new ValidPalindrome() ;
        System.out.print(valid.isPalindrome("abbaabba")) ;
    }

    public boolean isPalindrome(String s) {

        if(s.length() == 0 )
            return true ;
        s = s.trim() ;
        if(s.length() == 0 || s.length() == 1)
            return true ;
        //s = s.toLowerCase() ;
        char cur ;
        String temp = "" ;
        for(int i = 0 ; i < s.length() ; i ++){
            cur = s.charAt(i) ;
            if(cur <= 'z' && cur >= 'a'){
                temp = temp.concat(cur + "") ;
            }else if(cur <= 'Z' && cur >= 'A'){
                temp = temp.concat(cur-('A'-'a') + "") ;
            }
        }
        //System.out.print(s) ;
        int length = temp.length() ;
        System.out.print(length);
        if(length == 0)
            return false ;
        if(length == 1)
            return true ;
        for(int i = 0 ; i < length/2 ; i ++){
            if(temp.charAt(i) != temp.charAt(length-i-1))
                return false ;
        }
        return true ;
    }

}
