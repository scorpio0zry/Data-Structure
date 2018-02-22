package com.royal;

//����������
public class MyQueue {
	public static void main(String[] args) {
		QueueNode q = new QueueNode();
		q.pushQueue(true);
		q.pushQueue(1);
		q.pushQueue("���");

		//q.clearQueue();
		q.listQueue();
	}
	
	//��������
	public static class Node{
		private Object data;
		private Node next;
		public Node(){}
		public Node(Object data){
			this.data = data;
		}		
	}
	
	//����������
	public static class QueueNode{
		//����ͷָ��
		private Node front;
		//����βָ��
		private Node rear;
		//���г���
		private int size;
		//���췽��
		public QueueNode() {
			//����һ��ͷ���
			this.front = new Node();
			rear = front;
		}
		
		//�жϵ�ǰ�����Ƿ�Ϊ��
		public boolean isEmpty(){
			return rear == front;
		}
		
		//���   Ԫ�شӶ�β����
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
		
		//����  Ԫ�شӶ�ͷ����
		public Object popQueue(){
			if(isEmpty()){
				System.out.println("����Ϊ��,���ܳ���!");
				
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
		
		//��������
		public void listQueue(){
			if(size==0){
				System.out.println("�ն���");
				System.out.println("���еĳ���" + size);
			}else{
				Node temp = front;
				while(temp.next!=rear){
					temp = temp.next;
					System.out.print(temp.data + "<-");
				}
				temp = temp.next;
				System.out.println(temp.data);
				System.out.println("���еĳ���" + size);
			}
		}
		
		//��ն���
		public void clearQueue(){
			while(!isEmpty()){
				popQueue();
			}
		}
	}
}
