// https://leetcode.com/problems/reverse-linked-list

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
class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        ListNode front = null;
        while (current != null) {
            front = current.next; //initialize front to the next of curr
            current.next = prev; // reverse node pointing to previous
            
            //moving pointer ahead
            prev = current;
            current = front;
        }
        head = prev;
        return head;
        
    }
}