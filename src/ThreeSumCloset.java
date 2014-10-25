package solution;

public class ThreeSumCloset {
	
	public static void main(String[] args){
		ThreeSumCloset sum = new ThreeSumCloset() ;
		System.out.println(sum.threeSumClosest(new int[]{0, 0, 0} , 1)) ;
	}
	
	public int threeSumClosest(int[] num, int target) {
		int result = 0, length = num.length ;
		sort(num) ;
		//less than 3
		int n = 0 ;
		for( ;n < 3 && n < length ; n ++){
			result += num[n] ;
		}
		if(n == length)
			return result ;
			
		int temp = 0 ;
		for(int i = 0 ; i < length - 2 ; i ++){
			int j = i + 1 , k = length - 1;
			while(j < k){
				temp = num[i] + num[j] + num[k] ;
				if(temp == target) return temp ;
				if(Math.abs(target-temp) < Math.abs(target-result)){
					result = temp ;
				} 
				if(temp > target) k--;
				else j ++;
			}
		}
		return result ;
    }
	
	public void sort(int[] num){
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
