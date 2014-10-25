package solution;

import java.util.List;

/**
 * Created by lakb2_000 on 2014/8/28.
 */
public class MergeKSortedLists {

    public ListNode mergeKLists(List<ListNode> lists) {
        int length = lists.size() ;

        if(length == 0){
            return null ;
        }
        if(length == 1){
            return lists.get(1) ;
        }

        int mid = (length - 1)/2 ;
        ListNode l1 = mergeKLists(lists.subList(0,mid + 1)) ;
        ListNode l2 = mergeKLists(lists.subList(mid + 1,length)) ;

        return mergeTowLists(l1,l2) ;
    }

    public ListNode mergeTowLists(ListNode l1 , ListNode l2){
        ListNode result = new ListNode(0) ;
        ListNode list = result ;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                list.next = l1 ;
                l1 = l1.next ;
            }else{
                list.next = l2 ;
                l2 = l2.next ;
            }
            list = list.next ;
        }

        while(l1 != null){
            list.next = l1 ;
            l1 = l1.next ;
            list = list.next ;
        }

        while(l2 != null){
            list.next = l2 ;
            l2 = l2.next ;
            list = list.next ;
        }

        return result.next ;
    }

}
