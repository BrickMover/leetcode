package com.wyt.leetcodeOJ;

/**
 * @author wangyitao
 * @Date 2015-01-27
 * @version 1.0
 * @Description
 * Given a linked list, determine if it has a cycle in it.
 * Follow up:
 * Can you solve it without using extra space?
 *
 */
public class LinkedListCycle {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = head;
		ListNode node1 = new ListNode(2);
//		ListNode node2 = new ListNode(3);
//		ListNode node3 = new ListNode(4);
//		ListNode node4 = new ListNode(5);
		head.next=node1;node1.next=head;//node2.next=node3;node3.next=node4;//node4.next=node2;
		System.out.println(hasCycle(head));
	}
	
	public static boolean hasCycle(ListNode head) {
		if (head == null) {
		    return false;
		}
        //创建两个指针，以每次走一步，一个每次走2步
		ListNode p1 = head;//走一步
		ListNode p2 = head.next;//走两步
		
		if (head.next == head) {
			return true;
		}
		
		while (p1 != null && p2 != null) {
			if(p1 == p2) {//相遇，返回true
				return true;
			} else {
				p1 = p1.next;
				if(p2.next == null) {//走不到两步结束，则无环
					return false;
				} else {//否则走两步
					p2 = p2.next.next;
				}
			}
		}
		return false;
    }

}
