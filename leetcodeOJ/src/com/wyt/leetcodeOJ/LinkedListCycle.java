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
		ListNode head = new ListNode(3);
		ListNode node1 = new ListNode(2);
		ListNode node2 = new ListNode(0);
		ListNode node3 = new ListNode(4);
		//ListNode node4 = new ListNode(5);
		head.next=node1;node1.next=node2;node2.next=node3;node3.next=node1;//node4.next=node2;
		System.out.println(detectCycle(head).val);
	}
	
	public static boolean hasCycle(ListNode head) {
		if (head == null) {
		    return false;
		}
        //创建两个指针，以每次走一步，一个每次走2步
		ListNode p1 = head;//走一步
		ListNode p2 = head.next;//走两步
		
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
	
	/**
	 * @param head
	 * @return
	 * @Description
	 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
	 * Follow up:
	 * Can you solve it without using extra space?
	 * 
	 * 设置第三个节点，和走一步的同步，先不走，当快的和慢的相遇，此时可以计算出起点到环点的距离等于相遇点到环点的距离
	 * 所以此时第三个指针和走一步的指针同时开始走，相遇点即环点
	 */
	public static ListNode detectCycle(ListNode head) {
		if (head == null) {
			return null;
		}
		
		ListNode header = new ListNode(-1);
		header.next = head;
		ListNode p1 = header;
		ListNode p1_3 = header;
		ListNode p2 = header.next;
		
		while (p1 != null && p2 != null) {
			if (p1 == p2) {
				p1 = p1.next;
				while (p1 != p1_3) {
					p1 = p1.next;
					p1_3 = p1_3.next;
				}
				return p1;
			} else {
				p1 = p1.next;
				if (p2.next == null) {
					return null;
				} else {
					p2 = p2.next.next;
				}
			}
		}
		return null;
	}

}
