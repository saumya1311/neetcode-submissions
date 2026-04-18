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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> minheap= new PriorityQueue<>();
        for(ListNode list:lists){
            while(list!=null){
                minheap.add(list.val);
                list=list.next;
            }
        }

        ListNode dummy=new ListNode(0);
        ListNode mergeList=dummy;

        while(!minheap.isEmpty()){
            mergeList.next=new ListNode(minheap.remove());
            mergeList=mergeList.next;
        }
        return dummy.next;
    }
}
