package solution;

import java.util.ArrayList;

/**
 * Created by lakb2_000 on 2014/10/23.
 */
public class SortList {


    public ListNode sortList(ListNode head) {
        ArrayList<ListNode> list = new ArrayList<ListNode>() ;
        if(head == null)
            return null ;
        ListNode node = head ;
        while(node != null){
            list.add(node) ;
            node = node.next ;
        }

        heapSort(list);
        int length = list.size() ;
        for(int i = 0 ; i < length - 1 ; i ++){
            list.get(i).next = list.get(i + 1) ;
        }
        list.get(length - 1).next = null ;
        head = list.get(0) ;

        return head ;
    }

    public void heapSort(ArrayList<ListNode> list){

        int length = list.size() ;
        for(int i = length/2 - 1 ; i >= 0 ; i --){
            adjustList(list,i,length-1);
        }
        for(int i = length - 1 ; i >= 0 ; i --){
            ListNode temp = list.get(i) ;
            list.set(i , list.get(0)) ;
            list.set(0 , temp) ;
            adjustList(list,0,i-1);
        }

    }

    public void adjustList(ArrayList<ListNode> list , int start , int end){

        ListNode max = list.get(start) ;
        int index = start ;
        for(int i = 2 * (start + 1) - 1 ; i <= end  ; i = 2*(i + 1) - 1){
            if(i + 1 <= end && list.get(i).val < list.get(i + 1).val){
                i = i + 1;
            }

            if(list.get(i).val > max.val){
//                max = list.get(i).val ;
                list.set(index,list.get(i)) ;
                index = i ;
            }else{
                break ;
            }
        }

        list.set(index,max) ;


    }

}


