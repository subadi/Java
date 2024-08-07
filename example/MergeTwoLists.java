// https://leetcode.com/problems/merge-two-sorted-lists


//  //Definition for singly-linked list.
//  public class ListNode {
//       int val;
//       ListNode next;
//       ListNode() {}
//       ListNode(int val) { this.val = val; }
//       ListNode(int val, ListNode next) { this.val = val; this.next = next; }

//     // @Override
//     // public String toString() {
//     //     StringBuilder sb = new StringBuilder();
//     //     ListNode current = this;
//     //     while (current != null) {
//     //         sb.append(current.val);
//     //         if (current.next != null) {
//     //             sb.append(" -> ");
//     //         }
//     //         current = current.next;
//     //     }
//     //     return sb.toString();
//     // }
//  }
 
class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode tmpNode = new ListNode(-1);
        ListNode tmp = tmpNode;
        while(list1!=null && list2!=null){
            int data1 = list1.val;
            int data2 = list2.val;
            if(data1<=data2){
                tmp.next= list1;
                list1 = list1.next;
            }else{
                tmp.next= list2;
                list2 = list2.next;
            }
            tmp= tmp.next;
        }
        if(list1!=null){
            tmp.next = list1;
        }
        if(list2!=null){
           tmp.next = list2; 
        }
        return tmpNode.next;
    }
}