package com.royal;

//顺序结构的队列(循环队列)
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
		//定义数组结构存储元素
		private Object[] elementdata;
		//定义队头
		private int front;
		//定义队尾
		private int rear;
		//定义长度
		private int size;
		//定义当前容量
		private int capacity;
		//默认创建容量为5的数组
		public cycleQueue(){
			elementdata = new Object[5];
			capacity = 5;
		}
		//自定义容量数组
		public cycleQueue(int capacity){
			elementdata = new Object[capacity+1];
			this.capacity = capacity+1;
		}
		
		//入队
		public<T> void pushQuere(T data){
			//判断队列是否已满
			if(isFull()){
				System.out.println("队列已满"+data+"无法添加");
			}else{								
				elementdata[rear] = data;
				rear = (rear + 1)%capacity;
				size++;
			}
		}
		
		//出队
		public<T> T popQueue(){
			if(isEmpty()){
				System.out.println("队列已空");
				return null;
			}else{
				T data = (T) elementdata[front];
				front = (front+1)%capacity;
				size--;
				return data;
			}
		}
		
		//遍历队列
		public void listQueue(){
			if(isEmpty()){
				System.out.println("空队列");
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
		
		//清空队列
		public void setClear(){
			front = rear;
			size = 0;
		}
		//判断队列是否已满
		public boolean isFull(){
			return (rear+1)%capacity == front;
		}
		
		//判断队列是否为空
		public boolean isEmpty(){
			return front == rear;
		}
		
		//查看队列长度
		public int getSize(){
			return size;
		}
		
		//查看当前队列容量
		public int getCapacity(){
			return capacity-1;
		}
		
		
		
	}

}
