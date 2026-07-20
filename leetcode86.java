/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        
        ListNode afterNode = new ListNode(0);
        ListNode beforeNode = new ListNode(0);

        ListNode after = afterNode;
         ListNode before = beforeNode;

         while(head != null){
       
       if(x>head.val){
              
            before.next = head;
            before = before.next;

       }else{

        after.next = head;
        after = after.next;


       }

       head = head.next;

         }

         after.next = null;

         before.next = afterNode.next;

         return beforeNode.next;
    }
}
