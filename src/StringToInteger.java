package solution;

public class StringToInteger {
	
	public static void main(String[] args){
		StringToInteger switcher  = new StringToInteger() ;
		System.out.println(switcher.atoi("   2147483648qwqqw"));
	}
	
	public int atoi(String str) {
		int length = str.length() ;
		if(length == 0) return 0 ;
        int base = 0 , sign = 1;
        int i = 0 ;
        while(str.charAt(i) == ' ') 
        	i ++ ;
        if(str.charAt(i) == '-'){
        	sign = -1 ;
        	i ++ ;
        }else if(str.charAt(i) == '+'){
        	sign = 1 ;
        	i ++ ;
        }
        while(i < length && str.charAt(i) <= '9' && str.charAt(i) >= '0'){
        	if(base > Integer.MAX_VALUE/10 || ((base == Integer.MAX_VALUE/10) && str.charAt(i) > '7')){
        		if(sign == 1) return Integer.MAX_VALUE ;
        		else return Integer.MIN_VALUE ;
        	}
        	base = 10*base + (str.charAt(i++) - '0') ;
        }
        return base*sign ;
    }

}
