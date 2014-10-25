package solution;

/**
 * Created by lakb2_000 on 2014/10/21.
 */
public class ReverseWordsinaString {

    public static void main(String[] args){
        ReverseWordsinaString reverse = new ReverseWordsinaString() ;
        System.out.print(reverse.reverseWords("the sky is blue"));
    }

    public String reverseWords(String s) {
        s = s.trim() ;
        int length = s.length() ;
        if(length == 0)
            return "" ;
        String result = "" ;
        char[] words = s.toCharArray() ;
        int pos = 0 ;
        for(int i = 0 ; i < length ; i ++){
            if(words[i] == ' '){
                if(i > pos){
                    result = s.substring(pos,i) + " " + result ;
                }
                pos = i + 1 ;
            }else if(i == (length - 1)){
                result = s.substring(pos ,length) + " " + result ;
            }
        }
        return result.substring(0,result.length() - 1) ;
    }

}
