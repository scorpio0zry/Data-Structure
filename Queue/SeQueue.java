package com.royal;

//˳��ṹ�Ķ���(ѭ������)
public class SeQueue {
	public static void main(String[] args) {
		cycleQueue c = new cycleQueue();
		c.pushQuere(1);
		c.pushQuere(2);
		c.pushQuere(3);
		c.pushQuere(5);
		c.pushQuere(6);
		
		c.listQueue();
	}
	
	public static class cycleQueue{
		//��������ṹ�洢Ԫ��
		private Object[] elementdata;
		//�����ͷ
		private int front;
		//�����β
		private int rear;
		//���峤��
		private int size;
		//���嵱ǰ����
		private int capacity;
		//Ĭ�ϴ�������Ϊ5������
		public cycleQueue(){
			elementdata = new Object[5];
			capacity = 5;
		}
		//�Զ�����������
		public cycleQueue(int capacity){
			elementdata = new Object[capacity+1];
			this.capacity = capacity+1;
		}
		
		//���
		public<T> void pushQuere(T data){
			//�ж϶����Ƿ�����
			if(isFull()){
				System.out.println("��������"+data+"�޷����");
			}else{								
				elementdata[rear] = data;
				rear = (rear + 1)%capacity;
				size++;
			}
		}
		
		//����
		public<T> T popQueue(){
			if(isEmpty()){
				System.out.println("�����ѿ�");
				return null;
			}else{
				T data = (T) elementdata[front];
				front = (front+1)%capacity;
				size--;
				return data;
			}
		}
		
		//��������
		public void listQueue(){
			if(isEmpty()){
				System.out.println("�ն���");
			}else{
				if(front < rear){
					for(int i=front;i<rear;i++){
						
						if(i == rear-1){
							System.out.println(elementdata[i]);
						}else{
							System.out.print(elementdata[i] + "<-");
						}
					}
				}else{
					int temp = front;
					while(true){
						temp++;
						if(temp > capacity){
							temp = temp%capacity;
						}
						if(temp == rear){
							break;
						}						
						if(temp == rear-1){
							System.out.println(elementdata[temp]);
						}else{
							System.out.print(elementdata[temp] + "<-");
						}
											
						
						
						
					}
				}
			}
			
		}
		
		//��ն���
		public void setClear(){
			front = rear;
			size = 0;
		}
		//�ж϶����Ƿ�����
		public boolean isFull(){
			return (rear+1)%capacity == front;
		}
		
		//�ж϶����Ƿ�Ϊ��
		public boolean isEmpty(){
			return front == rear;
		}
		
		//�鿴���г���
		public int getSize(){
			return size;
		}
		
		//�鿴��ǰ��������
		public int getCapacity(){
			return capacity-1;
		}
		
		
		
	}

}
