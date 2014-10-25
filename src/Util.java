package solution;

public class Util {
	public static void sort(int[] num){
		int length = num.length ;
		boolean flag = true ;
		for(int i = 0 ; i < length ; i ++){
			
			flag = true ;
			
			for(int j = 0 ; j < length - i - 1 ; j ++){
				if(num[j] > num[j + 1]){
					int temp = num[j] ;
					num[j] = num[j + 1] ;
					num[j + 1] = temp ;
					flag = false ;
				}
			}
			
			if(flag) break ;
		}
	}
}
