package com.royal;


import java.util.Arrays;

//Ӧ��:��������ת����ʮ����
//˳��ջ��ʵ��
public class myStack {
	public static void main(String[] args) {
		ArrayStack S = new ArrayStack(3);
		//������Ϊ����ʱ,ת����ʮ����
		int num = 1010;
		int decimal = S.transDecimal(num);
		System.out.println(decimal);
		
		//������Ϊ�ַ�ʱ,ת����ʮ����
		char[] num1 = {'1','0','1','0','1','0','0','1'};
		int decimal1 = S.transDecimal(num1);
		System.out.println(decimal1);
		//������Ϊ�ַ�ʱ,ת���ɰ˽���
		char[] num3 = S.transOctal(num1);
		for(int i=0;i<num3.length;i++){
			System.out.print(num3[i]);
		}
		
		System.out.println();
		//������Ϊ�ַ�ʱ,ת����ʮ������
		char[] num4 = S.transHex(num1);
		for (int i = 0; i < num4.length; i++) {
			System.out.print(num4[i]);
			
		}
	}

	// ˳��ջ����
	public static class ArrayStack {
		// �������鱣��˳��ջ��Ԫ��
		private Object[] elementData;
		// ջ�ĳ���
		private int size;
		// ����ĳ���
		private int capacity;;
		// ����ջ��
		public int top;

		// ����ջʱ,Ĭ�ϴ���һ������Ϊ20������
		public ArrayStack() {
			elementData = new Object[20];
			capacity = 20;

		}

		// ����ջʱ,�Զ�������ĳ���
		public ArrayStack(int capacity) {
			elementData = new Object[capacity];
			this.capacity = capacity;

		}

		// ��ջ  ������ȳ�������������
		public <T> void stackPush(T data) {
			if (capacity <= size) {
				int newcapacity = (capacity * 3/ 2) + 1;
				elementData = Arrays.copyOf(elementData, newcapacity);
				capacity = newcapacity;
			}
			elementData[top] = data;
			top++;
			size++;
			

		}

		// ��ջ
		public <T> T stackPop() {
			if(size ==  0){
				System.out.println("��ջ");
				return null;
			}else{
				T data = (T) this.elementData[top - 1];
				top--;
				size--;
				return data;
			}
		
		}

		// ����ջ
		public void listStack() {
			if (top == 0) {
				System.out.println("��ջ");
				System.out.println("ջ�ĳ���" + size);
			} else {
				for (int i = 0; i < top; i++) {
					System.out.print(elementData[i] + " ");
				}
				System.out.println();
				System.out.println("ջ�ĳ���" + size);
			}
		}

		// ���ص�ǰ����
		public void capacity() {
			System.out.println("��ǰ�������" + capacity);

		}
		
		
		//���ջ
		public void stackClear(){
			Arrays.fill(elementData, null);
			size = 0;
		}
		
		//������Ϊ����ʱ,ת����ʮ����
		public int transDecimal(int num){
			//��������num����ջ��(��ߴ�����ջ��)
			int m  = getNumber(num);
			for(int i=0;i<m;i++){
				int d = num;
				int p = i-1;
				while(p >= 0){
					d = d / 10;
					p--;
				}
				d = d % 10;
				stackPush(d);
			}
			//�������������Ƴ�ջ��
			int sum = 0;
			for(int i=m;i>0;i--){
				int p = stackPop();
				sum = (int) (sum +p* Math.pow(2, i-1));
			}
			return sum;
		}
		
		
			
		
		
		
		//�������ĸ�������
		public int getNumber(int num){
			int m = 0;
			int p = num;
			while(p != 0){
				p  /= 10;
				m++;
			}
			
			return m;
		}
		
		//������Ϊ�ַ�ʱ,ת����ʮ����
		public int transDecimal(char[] num){
			for(int i=0;i<num.length;i++){
				stackPush(num[i]);
			}
			int sum = 0;
			for(int i=0;i<num.length;i++){
				char p = stackPop();
				sum = (int) (sum +(p-48)* Math.pow(2, i));
			}
			return sum;
			
		}
		
		//������Ϊ�ַ�ʱ,ת���ɰ˽���
		public char[] transOctal(char[] num){
			for(int i=0;i<num.length;i++){
				stackPush(num[i]);
			}
			//�����˽�������
			char[] octal = new char[3];
			int count = 2;
			
			for(int i=0;i<num.length;i+=3){
				int sum = 0;
				for(int j=0;j<3;j++){
					if(size == 0){
						continue;
					}
					char p = stackPop();
					
					sum += (p-48)*Math.pow(2, j);					
				}
				octal[count] = (char)(sum+48);
				count--;
			}
			return octal;
		}
		
		//������Ϊ�ַ�ʱ,ת����ʮ������
		public char[] transHex(char[] num){
			for(int i=0;i<num.length;i++){
				stackPush(num[i]);
			}
			//����ʮ����������
			int count = 1;
			char[] hex = new char[2];
			for(int i=0;i<num.length;i+=4){
				int sum = 0;
				for(int j=0;j<4;j++){
					if(size == 0){
						continue;
					}
					char p = stackPop();
					
					sum += (p-48)*Math.pow(2, j);					
				}
				if(sum<=9){
					hex[count] = (char)(sum+48);
				}else{
					hex[count] = (char)(sum-10+65);
				}
				
				count--;
			}
			
			return hex;
		}
	}

}
