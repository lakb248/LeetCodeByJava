package solution;

import java.util.ArrayList;
import java.util.List;

public class ThreeSum {
	
	public static void main(String[] args){
		ThreeSum sum = new ThreeSum() ;
		List<List<Integer>> list = sum.threeSum(new int[]{-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0}) ;
		System.out.println(list);
	}
	
	public List<List<Integer>> threeSum(int[] num) {
		if(num.length == 0 || num.length < 3)
			return new ArrayList<List<Integer>>() ;
        int sum = 0 , length = num.length ;
        List<List<Integer>> result =new ArrayList<List<Integer>>() ;
        List<Integer> list = new ArrayList<Integer>() ;
        sort(num) ;
        System.out.println(num[0] + "," + num[1] + "," + num[length-1]);
        
        for(int i = 0 ; i < length -2; i ++){	

        	if(i>0 && num[i-1] == num[i]) continue;
        	int j = i + 1,k=length - 1 ;
        	boolean bk = false , bj = false ;
        	while(k > j + 1 && num[k] == num[k-1]) {
        		k -- ;
        		bk = true ;
        	}
        	if(bk) k ++ ;
        	while(j < k - 1 && num[j] == num[j +1]) {
        		j ++ ;
        		bj = true ;
        	}
        	if(bj) j -- ;
        	while(j < k){
        		sum = num[i] + num[j] + num[k] ;
        		System.out.println(sum + "," + j);
        		if(sum == 0){
        			list = new ArrayList<Integer>() ;
        			list.add(num[i]) ;
        			list.add(num[j]) ;
        			list.add(num[k]) ;
        			result.add(list) ;
        			System.out.println(list);
        			k -- ;
        			j ++ ;
        		}else{
        			if(sum < 0)
        				j ++ ;
        			else
        				k -- ;
        		}
        	}
        }
        System.out.println(result);
        clear(result) ;
        return result ;
    }
	public void clear(List<List<Integer>> list){
		int length = list.size() ;
		List<Integer> cur ;
		for(int i = 0 ; i < list.size() ; i ++){
			cur = list.get(i) ;
			for(int j = i + 1 ; j < list.size() ; j ++){
				if(list.get(j).equals(cur)){
					list.remove(j) ;
					j--;
				}
			}
		}
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
