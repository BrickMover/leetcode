package com.wyt.leetcodeOJ;


import java.util.HashSet;
import java.util.Set;

public class DeleteDuplicates {
	
	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(2);
		ListNode node4 = new ListNode(3);
		ListNode node5 = new ListNode(3);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		
		//delDuplicates(node1);
		//delDNode(node1);
		node1 = delDNode2(node1);
		while (node1 != null) {
			System.out.println(node1.val);
			node1 = node1.next;
		}
	}

	public static ListNode delDuplicates(ListNode head) {
		Set<Integer> set = new HashSet<Integer>();
		
		ListNode tmp = head;
		ListNode tmp2 =null;
		if(head != null) {
			set.add(head.val);
			tmp2 = head.next;
		}
		while(tmp2 != null) {
			if (set.contains(tmp2.val)) {
				ListNode p = tmp2.next;
				tmp.next = p;
				tmp2 = tmp.next;
			} else {
				set.add(tmp2.val);
				tmp = tmp2;
				tmp2 = tmp2.next;
			}
		}
		return head;
	}
	
	public static ListNode delDNode (ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		
		ListNode node1 = head;
		ListNode node2 = head.next;
		while(node2 != null) {
			if (node1.val == node2.val) {
				node1.next = node2.next;
				node2 = node1.next;
			} else {
				node1 = node1.next;
				node2 = node1.next;
			}
			
		}
		return head;
	}
	
	public static ListNode delDNode2 (ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		
		ListNode header = new ListNode(-1);
		header.next = head;
		ListNode node1 = header;
		ListNode node2 = head;
		
		while(node2 != null && node2.next != null) {
			if(node2.val == node2.next.val) {
				while(node2.next != null && node2.val == node2.next.val) {
					node2 = node2.next;
				}
				node1.next = node2.next;
				node2 = node2.next;
			} else {
				node1 = node2;
				node2 = node2.next;
			}
		}
		return header.next;
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}