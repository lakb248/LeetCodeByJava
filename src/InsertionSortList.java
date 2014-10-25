package solution;

/**
 * Created by lakb2_000 on 2014/10/24.
 */
public class InsertionSortList {

    public static void main(String[] str){
        InsertionSortList insertionSortList = new InsertionSortList() ;
        ListNode head = new ListNode(1) ;
        ListNode first = new ListNode(1) ;
        head.next = first ;

        insertionSortList.insertionSortList(head) ;
    }

    public ListNode insertionSortList(ListNode head) {

        if(head == null || head.next == null)
            return head ;

        ListNode node = head.next ;
           //3,4,1
        while(node != null){

            ListNode cur = head ;
            while(cur != node && cur.val < node.val){
                cur = cur.next ;
            }
            int val = node.val ;
            ListNode pos = cur ;
//            int temp = val ;
            int temp2 = cur.val ;
            while(cur != node){
                int temp1 = temp2 ;
                temp2 = cur.next.val ;
                cur.next.val = temp1 ;
                cur = cur.next ;
            }
            pos.val = val ;
            node = node.next;

        }

        return head ;
    }

}
