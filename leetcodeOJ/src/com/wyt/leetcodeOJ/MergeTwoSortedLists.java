package com.wyt.leetcodeOJ;

public class MergeTwoSortedLists {

	public static void main(String[] args) {
		ListNode node11 = new ListNode(-10);
		ListNode node12 = new ListNode(-9);
		ListNode node13 = new ListNode(-6);
		ListNode node14 = new ListNode(1);
		ListNode node15 = new ListNode(9);
		ListNode node16 = new ListNode(9);
//		ListNode node17 = new ListNode(6);
		node11.next = node12;
		node12.next = node13;
		node13.next = node14;
		node14.next = node15;
		node15.next = node16;
//		node16.next = node17;
		
		ListNode node21 = new ListNode(-5);
		ListNode node22 = new ListNode(-3);
		ListNode node23 = new ListNode(0);
		ListNode node24 = new ListNode(7);
		ListNode node25 = new ListNode(8);
		ListNode node26 = new ListNode(8);
		node21.next = node22;
		node22.next = node23;
		node23.next = node24;
		node24.next = node25;
		node25.next = node26;
		
		ListNode reListNode = mergeTwoLists(node11, node21);
		
		System.out.println(reListNode);
		
		
	}

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}
		ListNode p, q, result;
		if(l1.val < l2.val) {
			result = l1;
			p = l1;
			q = l2;
		} else {
			result = l2;
			p = l2;
			q = l1;
		}
        
        while(p.next != null) {
        	if (q == null) {
        		break;
        	}
        	ListNode tmp = new ListNode(q.val);
        	if(p.next.val > tmp.val) {//p点的值大于q，将q插到p后面，p,q后移
        		tmp.next = p.next;
        		p.next = tmp;
        		p = p.next;
        		//p = p.next.next;
        		q = q.next;
        	} else {//p点小于等于q,插到后面的后面
        		if (p.next.next != null) {
        			if(p.next.next.val > tmp.val) {
        				tmp.next = p.next.next;
                		p.next.next = tmp;
                		p = p.next;
                		q = q.next;
        			} else {
        				p = p.next.next;
        			}
        		} else {
        			p.next.next = q;
        			q = null;
        			break;
        		}
        	}
        }
        
        if(q != null) {
        	p.next = q;
        }
        
        return result;
    }
	
	public static ListNode mergeTwoListsRecursive(ListNode l1, ListNode l2) {
        if(l2==null) return l1;
        if(l1==null) return l2;
        
        if(l1.val<=l2.val){
            l1.next = mergeTwoListsRecursive(l1.next,l2);
            return l1;
        }
        else{
            l2.next = mergeTwoListsRecursive(l1,l2.next);
            return l2;
        }
	}
	
}
