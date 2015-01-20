package com.wyt.leetcodeOJ;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wangyitao
 * @Date 2015-01-20
 * @version 1.0
 * @Description
 * Given a linked list, remove the nth node from the end of list and return its head.
 * For example,
 * Given linked list: 1->2->3->4->5, and n = 2.
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 * Given n will always be valid.
 * Try to do this in one pass.
 */
public class RemoveNthNodeFromEndofList {

	public static void main(String[] args) {
		ListNode node = new ListNode(1);
		ListNode node1 = new ListNode(2);
//		ListNode node2 = new ListNode(3);
//		ListNode node3 = new ListNode(4);
//		ListNode node4 = new ListNode(5);
		node.next = node1;//node1.next=node2;node2.next=node3;node3.next=node4;
		System.out.println(removeNthFromEnd__(node, 2));
	}

	/**
	 * @param head
	 * @param n
	 * @return
	 * 在遍历的同时将每个位置，结点存到map，取出倒数位置，删除节点
	 */
	public static ListNode removeNthFromEnd(ListNode head, int n) {
        Map<Integer, ListNode> map = new HashMap<Integer, ListNode>();
        int length = 1;
        if (head == null) {
			return head;
		}
        ListNode header = new ListNode(-1);
        header.next = head;
        ListNode p = head;
        map.put(0, header);
        while (p != null) {
			map.put(length, p);
			length++;
			p = p.next;
		}
        
        p = map.get(length-n-1);
        if(p != null) {
        	p.next = p.next.next;
        }
        return header.next;
        
    }
	
	/**
	 * @param head
	 * @param n
	 * @return
	 * 先遍历出长度，再删节点
	 */
	public static ListNode removeNthFromEnd__(ListNode head, int n) {
		if (head == null) {
			return head;
		}
		ListNode header = new ListNode(-1);
		header.next = head;
		ListNode p = head;
		int len = 0;
		while (p != null) {
			len ++;
			p = p.next;
		}
		if (len - n == 0) {
			return head.next;
		}
		if(len - n > 0) {
			p = head;
			for (int i = 0; i < len - n-1; i++) {
				p = p.next;
			}
			p.next = p.next.next;
			return header.next;
		} else {
			return null;
		}
	}
	
}
