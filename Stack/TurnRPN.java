package com.royal;

import java.util.Arrays;
import java.util.Scanner;

//���׼������ı�д 
//��׺���ʽת��׺���ʽ  ,�ó���������沨�������

//���� ����:(11+2.2)*3.1+(30*45)-((1.1+23)*3.3)/5.2
//ת���ɺ�׺���ʽ: 11 2.2 + 3.1 * 30 45 * + 1.1 23 + 3.3 * 5.2 / - 
//������:1375.6257692307693
public class TurnRPN {
	public static void method() {
		char[] s = getChar();
		String expression = getExpression(s);
		//System.out.print("ת���ɺ�׺���ʽ: ");
		//System.out.println(expression);
		//���ַ���ת�����ַ�����
		char[] s2 = expression.toCharArray();
		ArrStack as = rpn(s2);
		System.out.print("������:");
		as.listStack();
	}

	// ��������ַ���ת�����ַ�����
	@SuppressWarnings("resource")
	private static char[] getChar() {
		Scanner sc = new Scanner(System.in);
		// ��������ַ���ת����һ���ַ�����
		System.out.println("����������������ʽ: ");
		char[] s = sc.nextLine().toCharArray();
		return s;
	}

	// ��׺���ʽת��׺���ʽ
	private static String getExpression(char[] s) {
		ArrStack as = new ArrStack();
		// �����ַ����洢��׺���ʽ
		String arr = "";
		for (int i = 0; i < s.length; i++) {
			// ��������ֻ���.ֱ�ӷ����ַ�����
			if (isNumber(s[i]) || s[i] == '.') {
				arr = arr + s[i];
				// �ж������Ƿ���ȫ����,���ȫ���������,���ں�����Ͽո�
				if (i != s.length - 1) {
					if (!isNumber(s[i + 1]) && s[i + 1] != '.') {
						arr = arr + " ";
					}
				} else {
					// ����ַ������һλ������,��ֱ�Ӽӿո�(������ջ��������ַ�����)
					arr = arr + " ";
				}
				// �����������ַ�,���жϺ���ջ
			} else if (s[i] == '+' || s[i] == '-' || s[i] == '*' || s[i] == '/') {
				// �����= -���ж�ջ��Ԫ���Ƿ�Ϊ * / �����,�Ƚ�ջ��Ԫ�س�ջ������ջ ����,ֱ����ջ
				if (s[i] == '+' || s[i] == '-') {
					if (!as.isEmpty()) { // �ж�ջ�Ƿ�Ϊ��
						char r = as.getTop();
						while (r == '+' || r == '-' || r == '*' || r == '/') {
							r = as.stackPop();
							arr = arr + r + " ";
							// ���ջΪ��,��ֱ������ѭ��
							if (!as.isEmpty()) {
								r = as.getTop();
							} else {
								break;
							}
						}
					}
					as.stackPush(s[i]);
				} else {
					as.stackPush(s[i]);
				}
				// ����ַ���(ֱ����ջ,���)��ջ��Ԫ�����γ�ջ,ֱ����ջԪ����(Ϊֹ
			} else if (s[i] == '(') {
				as.stackPush(s[i]);
			} else if (s[i] == ')') {
				char r = as.stackPop();
				while (r != '(') {
					arr = arr + r + " ";
					r = as.stackPop();
				}
			}
		}
		// ��ջ��ʣ���Ԫ�����δ����ַ�����
		while (!as.isEmpty()) {
			char r = as.stackPop();
			arr = arr + r + " ";
		}
		return arr;
	}

	// �沨�����ʽ��ֵ
	private static ArrStack rpn(char[] s) {
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
				if (arr == "") {
					continue;
				} else {
					num = Double.valueOf(arr);
					as.stackPush(num);
					// �ַ����ÿ�
					arr = "";
				}

			} else {
				// ����������ַ�,����ջ��ǰ�����������������ѹ��ջ��
				switch (s[i]) {
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
					if (a == 0) {
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
	private static boolean isNumber(char c) {
		if (c >= 48 && c <= 57) {
			return true;
		}
		return false;
	}
	
	// ����˳��ջ
	private static class ArrStack {
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
			@SuppressWarnings("unused")
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
			@SuppressWarnings("unchecked")
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
					System.out.println(elementData[top - 1]);
					// System.out.println("ջ�ĳ���" + size);
				} else {
					for (int i = 0; i < size; i++) {
						System.out.print(elementData[i] + " ");
					}
					System.out.println("ջ�ĳ���" + size);
				}
			}

			// ���ص�ǰ����
			@SuppressWarnings("unused")
			public void capacity() {
				System.out.println("��ǰ�������" + capacity);

			}

			// ���ص�ǰջ����ֵ
			@SuppressWarnings("unchecked")
			public <T> T getTop() {
				T data = (T) elementData[top - 1];
				return data;
			}

			// �п�
			public boolean isEmpty() {
				return size == 0;
			}
		}
	}


	