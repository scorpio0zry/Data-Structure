package com.royal;

//定义链队列
public class MyQueue {
	public static void main(String[] args) {
		QueueNode q = new QueueNode();
		q.pushQueue(true);
		q.pushQueue(1);
		q.pushQueue("你好");

		//q.clearQueue();
		q.listQueue();
	}
	
	//定义结点类
	public static class Node{
		private Object data;
		private Node next;
		public Node(){}
		public Node(Object data){
			this.data = data;
		}		
	}
	
	//定义链队列
	public static class QueueNode{
		//定义头指针
		private Node front;
		//定义尾指针
		private Node rear;
		//队列长度
		private int size;
		//构造方法
		public QueueNode() {
			//定义一个头结点
			this.front = new Node();
			rear = front;
		}
		
		//判断当前队列是否为空
		public boolean isEmpty(){
			return rear == front;
		}
		
		//入队   元素从队尾进入
		public void pushQueue(Object data){
			if(isEmpty()){
				Node node = new Node(data);
				front.next = node;
				rear = node;
				size++;
			}else{
				Node node = new Node(data);
				rear.next = node;
				rear = node;
				size++;
			}
		}
		
		//出队  元素从队头出来
		public Object popQueue(){
			if(isEmpty()){
				System.out.println("队列为空,不能出队!");
				
				return null;
			}else if(size == 1){
				Object data = rear.data;
				front.next = null;
				rear = front;
				size--;	
				return data;
			}else{
				Object data = front.next.data;
				front.next = front.next.next;
				size--;
				return data;				
			}
		}
		
		//遍历队列
		public void listQueue(){
			if(size==0){
				System.out.println("空队列");
				System.out.println("队列的长度" + size);
			}else{
				Node temp = front;
				while(temp.next!=rear){
					temp = temp.next;
					System.out.print(temp.data + "<-");
				}
				temp = temp.next;
				System.out.println(temp.data);
				System.out.println("队列的长度" + size);
			}
		}
		
		//清空队列
		public void clearQueue(){
			while(!isEmpty()){
				popQueue();
			}
		}
	}
}
