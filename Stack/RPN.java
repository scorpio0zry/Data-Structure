package com.royal;

import java.util.Arrays;
import java.util.Scanner;

//逆波兰表达式计算器
public class RPN {
	public static void main(String[] args) {
		char[] s = getChar();
		ArrStack arr = rpn(s);
		arr.listStack();

	}
	
	//将输入的字符串转换成字符数组
	public static char[] getChar() {
		Scanner sc = new Scanner(System.in);
		// 将输入的字符串转换成一个字符数组
		System.out.println("请输入逆波兰表达式: ");
		char[] s = sc.nextLine().toCharArray();
		return s;
	}

	//逆波兰表达式
	public static ArrStack rpn(char[] s) {
		ArrStack as = new ArrStack();
		double num = 0;
		// 定义空字符串存入字符
		String arr = "";
		double a = 0;
		double b = 0;
		double result = 0;
		for (int i = 0; i < s.length; i++) {
			// 如果是数字或者.则推入栈中
			if (isNumber(s[i]) || s[i] == '.') {
				arr = arr + s[i];
			} else if (s[i] == ' ') {
				// 遇到空格,将数据取出转成double类型推入栈中
				if(arr == ""){
					continue;
				}else{
					num = Double.valueOf(arr);
					as.stackPush(num);
					// 字符串置空
					arr = "";
				}
				
			}else{
				//遇到运算符字符,弹出栈顶前两个数进行运算后再压入栈中
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
						System.out.println("除数不能为0!");
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
	
	

	// 判断字符是否为数字
	public static boolean isNumber(char c) {
		if (c >= 48 && c <= 57) {
			return true;
		}
		return false;
	}

	// 创建顺序栈
	public static class ArrStack {
		// 定义数组保存元素
		private Object[] elementData;
		// 定义栈的当前长度
		private int size;
		// 定义栈的当前容量
		private int capacity;
		// 定义栈顶
		public int top;

		// 初始化,默认建立一个容量为50的数组
		public ArrStack() {
			elementData = new Object[50];
			capacity = 50;
		}

		// 初始化,自定义容量数组
		public ArrStack(int n) {
			elementData = new Object[n];
			capacity = n;
		}

		// 入栈
		public <T> void stackPush(T data) {
			// 如果容量满了,则新建一个数组扩充容量
			if (size >= capacity) {
				int newLength = (capacity * 3 / 2) + 1;
				elementData = Arrays.copyOf(elementData, newLength);
				capacity = newLength;
			}
			elementData[top] = data;
			top++;
			size++;
		}

		// 出栈
		public <T> T stackPop() {
			if (size == 0) {
				System.out.println("当前为空栈");
				return null;
			} else {
				T data = (T) this.elementData[top - 1];
				top--;
				size--;
				return data;
			}

		}

		// 遍历栈
		public void listStack() {
			if (size == 0) {
				System.out.println("空栈");
			} else if (size == 1) {
				System.out.println(elementData[top-1]);
				System.out.println("栈的长度" + size);
			} else {
				for (int i = 0; i < size; i++) {
					System.out.print(elementData[i] + " ");
				}
				System.out.println("栈的长度" + size);
			}
		}

		// 返回当前容量
		public void capacity() {
			System.out.println("当前最大容量" + capacity);

		}
	}
}
