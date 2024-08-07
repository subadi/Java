package org.example;
import java.io.*;

/**
 * Definition for singly-linked list. */
  class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }


  public class LinkedListInterSection {
      public static void main(String[] args) {
          //ListNode interSect = getIntersectionNode(headA,headB);
      }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA =  calculateLen(headA);
        int lenB =  calculateLen(headB);

        ListNode longer = lenA > lenB? headA: headB;
        ListNode shorter = lenA<= lenB ? headA: headB;

        int lenDiff = Math.abs(lenA-lenB);
        for(int i=0;i<lenDiff;i++){
            longer = longer.next;
        }

        while(longer!=null && shorter!=null){
            if(longer == shorter){
                return longer;
            }
            longer = longer.next;
            shorter = shorter.next;
        }
        return null;



    }

    private static int calculateLen(ListNode head){
        int len = 0;
        ListNode temp = head;
        while(temp.next != null){
            len++;
            temp = temp.next;
        }
        return len;
    }
  }



