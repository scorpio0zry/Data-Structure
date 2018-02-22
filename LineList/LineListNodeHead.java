package com.royal;

//带头结点的单链表
public class LineListNodeHead {
	
	public static void main(String[] args) {
		LineList L = new LineList();
		L.addNodeH(1);
		L.addNodeH(2);
		L.addNodeF(3);
		L.addNodeF(6);
		L.ListInsert(1, 5);
		L.ListDelete(2);
		
		L.ListClear();
		
		L.addNodeF(3);
		L.addNodeH(2);
		
		
		
		L.ListNode();
		
	}
	
	public interface IList{
		public void addNodeH(int data);
		public void addNodeF(int data);
		public void ListNode();
		public int ListInsert(int i, int data);
		public int ListDelete(int i);
		public void ListClear();
	}
	
	//结点
	public static class Node{
		public int data;
		public Node next;
		
		public Node(){
			
		}
		
		public Node(int data){
			this.data = data;
			this.next = null;
		}
	}
	
	public static class LineList implements IList{
		//头结点
		private Node head;
		
		//链表长度
		private int size;
		
		public LineList(){
			head = new Node();
		}

		//带头结点的单链表头插法
		public void addNodeH(int data) {
			Node node = new Node(data);
			if(head.next == null){
				head.next = node;
				size++;
			}else{
				node.next = head.next;
				head.next = node;
				size++;
			}
			
		}
		
		//带头结点的单链表尾插法
		public void addNodeF(int data) {
			Node node = new Node(data);
			if(head.next == null){
				head.next = node;
				size++;
			}else{
				Node p = head.next;
				while(p.next != null){
					p = p.next;
				}
				node.next = p.next;
				p.next = node;
				size++;
			}
		}

		//带头结点的单链表遍历
		public void ListNode() {
			Node p = head.next;
			if(p == null){
				System.out.println("空链表");
				System.out.println("单链表的长度" + size);
			}
			while(p.next != null){	
				System.out.print(p.data  + "->");
				p = p.next;					
				}
			
			System.out.println(p.data);
			System.out.println("单链表的长度" + size);
			
			
		}

		//带头结点的单链表任意插入
		public int ListInsert(int i, int data) {
			Node temp = head;
			int j = 1;
			if(i<0){
				System.out.println("i值输入有误");
				return 0;
			}
			while(temp.next != null && j<i){
				temp = temp.next;
				j++;
			}
			Node node = new Node(data);
			node.next = temp.next;
			temp.next = node;
			size++;
			
			return 1;
		}

		//单链表的删除
		public int ListDelete(int i) {
			Node temp = head;
			int j = 1;
			if(i<0){
				System.out.println("i值输入有误");
				return 0;
			}
			while(temp.next!=null && j<i){
				temp = temp.next;
				j++;
			}
			int n = temp.next.data;
			temp.next = temp.next.next;
			size--;
			
			return n;
		}

		//列表的清空
		public void ListClear() {
			Node temp = head.next;
			while(head.next!=null){
				head.next = temp.next;
				temp = null;
				temp = head.next;
				size--;
			}	
		}		
	}
}
