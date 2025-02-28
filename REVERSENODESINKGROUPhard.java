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
class REVERSENODESINKGROUPhard {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp=head;
        for(int i=0;i<k;i++){
            if(temp==null) return head;
            temp=temp.next;
        }
        ListNode newHead=reverseList(head,k);
        head.next=reverseKGroup(temp,k);
        return newHead;
    }

    private ListNode reverseList(ListNode head,int k){
        ListNode prev=null;
        ListNode curr=head;
        while(k-->0){
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
}