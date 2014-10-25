package solution;

/**
 * Created by lakb2_000 on 2014/8/29.
 */
public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        if(head == null)
            return null ;

        ListNode p1 = head , p2 = head.next , p3 = null ;
        if(p2 != null)
            head = p2 ;

        while(p1 != null && p2 != null){
            p1.next = p2.next ;
            p2.next = p1 ;
            //connect each two node
            if(p3 != null)
                p3.next = p2 ;
            p3 = p1 ;
            p1 = p1.next ;
            if(p1 != null)
                p2 = p1.next ;
            else
                return head ;
        }

        return head ;
    }

}
