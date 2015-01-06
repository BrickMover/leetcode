package com.wyt.leetcodeOJ;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wangyitao
 * @Date 2015-01-06
 * @version 1.0
 * @AC Time 435ms
 */
public class LRUCache {

	public static void main(String[] args) {
		
		LRUCache cache = new LRUCache(1);
		
		cache.set(2, 1);
		//System.out.println(cache.get(2));
		cache.set(2, 2);
		System.out.println(cache.get(2));
		cache.set(1, 1);
		cache.set(4, 1);
		System.out.println(cache.get(2));

	}

	private Map<Integer, Node> map = new HashMap<Integer, Node>();

	private int capacity;//cache容量

	private Node head;//内部链表头
	
	private Node tail;//内部链表尾结点
	
	public LRUCache(int capacity) {//初始化表头和表尾，维护一个双向链表，以及cache容量
		this.capacity = capacity;
		head = new Node(-1, -1);
		tail = new Node(-2, -1);
		head.next = tail;
		tail.pre = head;
	}

	public int get(int key) {//读一次代表访问一次，所以将访问的元素提到表头
		if (map.containsKey(key)) {
			update(map.get(key));//更新
			return map.get(key).val;
		} else {
			return -1;
		}
	}

	public void set(int key, int value) {
		Node node = new Node(key, value);
		if (map.get(key) == null) {//set元素在不在cache中
			if (capacity <= 0) {// 已满，因为每次的访问更新操作，所维护的表的表尾是最近最久未使用的元素，将其删除
				deleteFromTail();
			} else {//未满就将cache容量-1
				capacity--;
			}
			insertFromHead(node);//插入到表头
		} else {// 更新，注意，有可能set的key一样，但是value变了，所以建一个新结点，将node从map中取出，值变成要set的value
			Node newNode = map.get(key);
			newNode.val = value;
			update(newNode);
		}
	}

	private void update(Node node) {
		node.next.pre = node.pre;//删除结点
		node.pre.next = node.next;
		
		insertFromHead(node);//头查
	}
	
	private void insertFromHead(Node node) {
		node.next = head.next;// 头部插入
		head.next.pre = node;
		head.next = node;
		node.pre = head;
		map.put(node.key, node);
	}
	
	private void deleteFromTail () {
		Node tmp = tail.pre;
		tail.pre = tmp.pre;//删除尾部
		tail.pre.next = tail;
		map.remove(tmp.key);
	}

}

class Node {
	Node pre;
	Node next;
	int key;
	int val;

	public Node(int key, int value) {
		this.key = key;
		this.val = value;
	}
}
