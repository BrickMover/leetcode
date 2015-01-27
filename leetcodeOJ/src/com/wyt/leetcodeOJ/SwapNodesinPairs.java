package com.wyt.leetcodeOJ;

/**
 * @author wangyitao
 * @Date 2015-01-27
 * @version 1.0
 * @Description
 * Given a linked list, swap every two adjacent nodes and return its head.
 * For example,
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 *
 */
public class SwapNodesinPairs {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode node1 = new ListNode(2);
		ListNode node2 = new ListNode(3);
		//ListNode node3 = new ListNode(4);
		
		head.next=node1;node1.next=node2;//node2.next=node3;
		
		ListNode p =swapPairs(head);
		
		while (p!=null) {
			System.out.print(p.val + "->");
			p = p.next;
		}
	}
	
	public static ListNode swapPairs(ListNode head) {
        ListNode header = new ListNode(-1);
        header.next = head;
        
        if (head == null || head.next == null) {
        	return head;
        }
        
        ListNode p = header;
        
        while(p.next.next != null) {
        	ListNode tmp1 = new ListNode(p.next.val);//保留p.next
        	p.next = p.next.next;//删除p.next
        	ListNode tmp2 = p.next.next;
        	p.next.next = tmp1;//插入tmp
        	p.next.next.next = tmp2;
        	
        	p = p.next.next;
        	if (p == null || p.next == null) {//剩下的为空或者为1个，直接跳出循环
        		break;
        	}
        }
        
        return header.next;
    }

}
