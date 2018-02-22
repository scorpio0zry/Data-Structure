package com.royal;

import java.util.Arrays;
import java.util.Scanner;

//�沨�����ʽ������
public class RPN {
	public static void main(String[] args) {
		char[] s = getChar();
		ArrStack arr = rpn(s);
		arr.listStack();

	}
	
	//��������ַ���ת�����ַ�����
	public static char[] getChar() {
		Scanner sc = new Scanner(System.in);
		// ��������ַ���ת����һ���ַ�����
		System.out.println("�������沨�����ʽ: ");
		char[] s = sc.nextLine().toCharArray();
		return s;
	}

	//�沨�����ʽ
	public static ArrStack rpn(char[] s) {
		ArrStack as = new ArrStack();
		double num = 0;
		// ������ַ��������ַ�
		String arr = "";
		double a = 0;
		double b = 0;
		double result = 0;
		for (int i = 0; i < s.length; i++) {
			// ��������ֻ���.������ջ��
			if (isNumber(s[i]) || s[i] == '.') {
				arr = arr + s[i];
			} else if (s[i] == ' ') {
				// �����ո�,������ȡ��ת��double��������ջ��
				if(arr == ""){
					continue;
				}else{
					num = Double.valueOf(arr);
					as.stackPush(num);
					// �ַ����ÿ�
					arr = "";
				}
				
			}else{
				//����������ַ�,����ջ��ǰ�����������������ѹ��ջ��
				switch(s[i]){
				case '+':
					a = as.stackPop();
					b = as.stackPop();
					result = b + a;
					as.stackPush(result);
					break;
				case '-':
					a = as.stackPop();
					b = as.stackPop();
					result = b - a;
					as.stackPush(result);
					break;
				case '*':
					a = as.stackPop();
					b = as.stackPop();
					result = b * a;
					as.stackPush(result);
					break;
				case '/':
					a = as.stackPop();
					b = as.stackPop();
					if(a == 0){
						System.out.println("��������Ϊ0!");
						break;
					}
					result = b / a;
					as.stackPush(result);
					break;
					
				}
			}
		}
		return as;
		
	}
	
	

	// �ж��ַ��Ƿ�Ϊ����
	public static boolean isNumber(char c) {
		if (c >= 48 && c <= 57) {
			return true;
		}
		return false;
	}

	// ����˳��ջ
	public static class ArrStack {
		// �������鱣��Ԫ��
		private Object[] elementData;
		// ����ջ�ĵ�ǰ����
		private int size;
		// ����ջ�ĵ�ǰ����
		private int capacity;
		// ����ջ��
		public int top;

		// ��ʼ��,Ĭ�Ͻ���һ������Ϊ50������
		public ArrStack() {
			elementData = new Object[50];
			capacity = 50;
		}

		// ��ʼ��,�Զ�����������
		public ArrStack(int n) {
			elementData = new Object[n];
			capacity = n;
		}

		// ��ջ
		public <T> void stackPush(T data) {
			// �����������,���½�һ��������������
			if (size >= capacity) {
				int newLength = (capacity * 3 / 2) + 1;
				elementData = Arrays.copyOf(elementData, newLength);
				capacity = newLength;
			}
			elementData[top] = data;
			top++;
			size++;
		}

		// ��ջ
		public <T> T stackPop() {
			if (size == 0) {
				System.out.println("��ǰΪ��ջ");
				return null;
			} else {
				T data = (T) this.elementData[top - 1];
				top--;
				size--;
				return data;
			}

		}

		// ����ջ
		public void listStack() {
			if (size == 0) {
				System.out.println("��ջ");
			} else if (size == 1) {
				System.out.println(elementData[top-1]);
				System.out.println("ջ�ĳ���" + size);
			} else {
				for (int i = 0; i < size; i++) {
					System.out.print(elementData[i] + " ");
				}
				System.out.println("ջ�ĳ���" + size);
			}
		}

		// ���ص�ǰ����
		public void capacity() {
			System.out.println("��ǰ�������" + capacity);

		}
	}
}
