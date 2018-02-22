package com.royal;

//��ջ�ṹ
public class myStackNode {
	public static void main(String[] args) {
		StackNode<Integer> S = new StackNode<Integer>();
		S.stackPop();
		S.listStack();
	}
	
	//������ջ
	public static class StackNode<T>{
		//topָ��ָ��ջ��
		private Node top;
		//ջ�ĳ���
		private int size;
		//�����
		private class Node{
			private T data;
			//ǰ�����
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
		
		//������ջ����ջ�����һ��Ԫ��
		public StackNode(T element){
			top = new Node(element,null);
			size++;
		} 
		
		//��ջ
		public void stackPush(T element){
			top = new Node(element,top);
			size++;
		}
		
		public T stackPop(){
			if(top == null){
				System.out.println("��ջ");
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
		
		//��������
		public void listStack(){
			Node temp = top;
			if(size==0){
				System.out.println("��ջ");
				System.out.println("ջ�ĳ���" + size);
			}else if(size == 1){
					System.out.println(top.data);
					System.out.println("ջ�ĳ���" + size);
			}else{
				while (temp.prior != null){
					System.out.print(temp.data + " <- ");
					temp = temp.prior;				
				}
				
				System.out.println(temp.data);
				System.out.println("ջ�ĳ���" + size);
			}
			
		}
	}

}
