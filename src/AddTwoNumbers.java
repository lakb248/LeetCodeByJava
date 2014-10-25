package solution;

/**
 * Created by lakb2_000 on 2014/8/28.
 */

/**
 You are given two linked lists representing two non-negative numbers.
 The digits are stored in reverse order and each of their nodes contain a single digit.
 Add the two numbers and return it as a linked list.

 Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 0 -> 8
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0) ;
        ListNode h = result ;
        int sum = 0 ;
        while(l1 != null || l2 != null){
            sum = sum/10 ;

            if(l1 != null){
                sum += l1.val ;
                l1 = l1.next ;
            }

            if(l2 != null){
                sum += l2.val ;
                l2 = l2.next ;
            }

            h.next = new ListNode(sum%10) ;
            h = h.next ;
        }

        if(sum/10 != 0){
            h.next = new ListNode(sum/10) ;
        }

        return result.next ;
    }

}
