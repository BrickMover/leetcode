package com.wyt.leetcodeOJ;

public class InsertionSortList {

	public static void main(String[] args) {
		ListNode head = new ListNode(3);
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		head.next = node1;
		node1.next = node2;
		
		ListNode node = insertionSortList(head);
		
		while(node != null) {
			System.out.print(node.val + ",");
			node = node.next;
		}
	}
	
	public static ListNode insertionSortList(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		
		ListNode header = new ListNode(-1);
		header.next = head;
		ListNode currnet = head;
		ListNode tmp1 = head.next;
		
		while (tmp1 != null) {
			if(tmp1.val>=currnet.val){
				currnet = currnet.next;
				tmp1 = tmp1.next;
            }else {
                ListNode insertCur = header;
                ListNode insertPost = header.next;
                while(insertPost.val<tmp1.val){  
                    insertCur = insertPost;
                    insertPost = insertPost.next;
                }  
                currnet.next = tmp1.next;
                tmp1.next = insertPost;
                insertCur.next = tmp1;
                tmp1 = currnet.next;
            }  
		}
		
			return header.next;
    }

}