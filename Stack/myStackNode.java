package com.royal;

//链栈结构
public class myStackNode {
	public static void main(String[] args) {
		StackNode<Integer> S = new StackNode<Integer>();
		S.stackPop();
		S.listStack();
	}
	
	//建立链栈
	public static class StackNode<T>{
		//top指针指向栈顶
		private Node top;
		//栈的长度
		private int size;
		//结点类
		private class Node{
			private T data;
			//前驱结点
			private Node prior;
			
			public Node(){
				
			}
			
			public Node(T data,Node node){
				this.data = data;
				this.prior = node;
			}
		}
		
		public StackNode(){
			top = null;
		}
		
		//建立空栈并在栈顶添加一个元素
		public StackNode(T element){
			top = new Node(element,null);
			size++;
		} 
		
		//入栈
		public void stackPush(T element){
			top = new Node(element,top);
			size++;
		}
		
		public T stackPop(){
			if(top == null){
				System.out.println("空栈");
				return null;
			}else{
				T data = top.data;
				Node old = top;
				top = top.prior;
				old.prior = null;
				size--;
				return data;
			}
			
		}
		
		//遍历链表
		public void listStack(){
			Node temp = top;
			if(size==0){
				System.out.println("空栈");
				System.out.println("栈的长度" + size);
			}else if(size == 1){
					System.out.println(top.data);
					System.out.println("栈的长度" + size);
			}else{
				while (temp.prior != null){
					System.out.print(temp.data + " <- ");
					temp = temp.prior;				
				}
				
				System.out.println(temp.data);
				System.out.println("栈的长度" + size);
			}
			
		}
	}

}
