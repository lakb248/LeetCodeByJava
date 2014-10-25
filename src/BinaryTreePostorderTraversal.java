package solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by lakb2_000 on 2014/8/26.
 */
public class BinaryTreePostorderTraversal {

    public static void main(String[] agrs){
        BinaryTreePostorderTraversal t = new BinaryTreePostorderTraversal() ;
        int[] num = {4,2,5,1,7,4,2,11,77,55,9} ;
        t.quickSort(num,0,num.length-1);
        for(int i = 0 ; i < num.length ; i ++){
            System.out.print(num[i] + ",");
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>() ;
        Stack<TreeNode> stack = new Stack<TreeNode>();

        if(root == null){
            return list ;
        }

        TreeNode node = root ;
        TreeNode right = null ;
        while(node != null || stack.size() != 0){
            while(node != null){
                stack.push(node) ;
                node = node.left ;
            }

            node = stack.peek() ;

            if(node.right != null && node.right != right){
//                stack.push(node.right) ;
                node = node.right ;
            }else{
                node = stack.pop() ;
                list.add(node.val);
                right = node ;
                node = null ;
            }
        }

        return list ;
    }

    public int part(int[] num , int start , int end){
        int temp = num[start] ;

        while(start < end){
            while(start < end && num[end] >= temp) end -- ;
            if(start < end)
                num[start] = num[end] ;
            while(start < end && num[start] <= temp) start ++ ;
            if(start < end)
                num[end] = num[start] ;
        }

        num[start] = temp ;
//        System.out.print(num);
        return start ;

    }

    public void quickSort(int[] num,int start, int end){
        if(start < end){
            int mid = part(num,start,end) ;
            quickSort(num,start,mid - 1);
            quickSort(num,mid + 1,end) ;
        }
    }
}
