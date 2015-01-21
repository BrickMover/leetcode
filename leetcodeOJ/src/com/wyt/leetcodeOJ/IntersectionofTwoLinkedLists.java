package com.wyt.leetcodeOJ;

/**
 * @author wangyitao
 * @Date 2015-01-21
 * @version 1.0
 * @Description
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 * 
 * For example, the following two linked lists:
 * A:          a1 → a2
 *                    ↘
 *                     c1 → c2 → c3
 *                   ↗
 * B:     b1 → b2 → b3
 * begin to intersect at node c1.
 * 
 * Notes:
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 * Credits:
 * Special thanks to @stellari for adding this problem and creating all test cases.
 */
public class IntersectionofTwoLinkedLists {

	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(3);
		ListNode node3 = new ListNode(5);
		ListNode node4 = new ListNode(7);
		node1.next=node2;node2.next=node3;node3.next=node4;
		
		ListNode node5 = new ListNode(2);
		
		System.out.println(getIntersectionNode(node1, node5));
	}
	
	/**
	 * @param headA
	 * @param headB
	 * @return
	 * 算出两个链表长度的差值，让长的先走差值步，再同时走，若相交，则一定能找到一个相同的点
	 */
	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
			return null;
		}
        int lenA = 0;
        int lenB = 0;
        ListNode pA = headA;
        ListNode pB = headB;
        
        while (pA != null) {
			lenA++;
			pA = pA.next;
		}
        while (pB != null) {
			lenB++;
			pB = pB.next;
		}
        pA = headA;pB = headB;
        int gap = Math.abs(lenA-lenB);
        return (lenA > lenB ? run(pA, pB, gap) : run(pB, pA, gap));
    }
	
	private static ListNode run(ListNode pA, ListNode pB, int gap) {//A先
		for (int i = 0; i < gap; i++) {
			pA = pA.next;
		}
		while (pA != null) {
			if(pA == pB) {
				return pA;
			}
			pA = pA.next;
			pB = pB.next;
		}
		return null;
	}

}
