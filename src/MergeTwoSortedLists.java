package solution;

/**
 * Created by lakb2_000 on 2014/8/23.
 */
public class MergeTwoSortedLists {

    public static void main(String[] args){
        MergeTwoSortedLists merge = new MergeTwoSortedLists() ;
        System.out.print(merge.mergeTwoLists(new ListNode(2), new ListNode(1)).toString()) ;
    }
    //考虑保存结果链表的头指针
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode list = new ListNode(0) ;
        ListNode head = list ;
        //ListNode p1 , p2 ;
        if(l1 == null || l2 == null){
            if(l1 == null)
                return l2 ;
            else
                return l1 ;
        }

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

        if(l1 != null){
            list.next = l1 ;
        }

        if(l2 != null){
            list.next = l2 ;
        }
        return head.next ;
    }
}

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
     public String toString(){
         String str = "" ;
         ListNode l = this ;
         while(l != null){
            str += "," + l.val ;
            l = l.next ;
         }
         return str ;
     }
}