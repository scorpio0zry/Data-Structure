package com.royal;

import java.util.Arrays;
import java.util.Scanner;

//简易计算器的编写 
//中缀表达式转后缀表达式  ,得出结果用于逆波兰数输出

//例如 输入:(11+2.2)*3.1+(30*45)-((1.1+23)*3.3)/5.2
//转换成后缀表达式: 11 2.2 + 3.1 * 30 45 * + 1.1 23 + 3.3 * 5.2 / - 
//输出结果:1375.6257692307693
public class TurnRPN {
	public static void method() {
		char[] s = getChar();
		String expression = getExpression(s);
		//System.out.print("转换成后缀表达式: ");
		//System.out.println(expression);
		//将字符串转换成字符数组
		char[] s2 = expression.toCharArray();
		ArrStack as = rpn(s2);
		System.out.print("输出结果:");
		as.listStack();
	}

	// 将输入的字符串转换成字符数组
	@SuppressWarnings("resource")
	private static char[] getChar() {
		Scanner sc = new Scanner(System.in);
		// 将输入的字符串转换成一个字符数组
		System.out.println("请输入四则运算表达式: ");
		char[] s = sc.nextLine().toCharArray();
		return s;
	}

	// 中缀表达式转后缀表达式
	private static String getExpression(char[] s) {
		ArrStack as = new ArrStack();
		// 创建字符串存储后缀表达式
		String arr = "";
		for (int i = 0; i < s.length; i++) {
			// 如果是数字或者.直接放入字符串中
			if (isNumber(s[i]) || s[i] == '.') {
				arr = arr + s[i];
				// 判断数字是否完全输入,如果全部输入完毕,则在后面加上空格
				if (i != s.length - 1) {
					if (!isNumber(s[i + 1]) && s[i + 1] != '.') {
						arr = arr + " ";
					}
				} else {
					// 如果字符的最后一位是数字,则直接加空格(与最后出栈的运算符字符区分)
					arr = arr + " ";
				}
				// 如果是运算符字符,则判断后入栈
			} else if (s[i] == '+' || s[i] == '-' || s[i] == '*' || s[i] == '/') {
				// 如果是= -则判断栈顶元素是否为 * / 如果是,先将栈顶元素出栈后再入栈 否则,直接入栈
				if (s[i] == '+' || s[i] == '-') {
					if (!as.isEmpty()) { // 判断栈是否为空
						char r = as.getTop();
						while (r == '+' || r == '-' || r == '*' || r == '/') {
							r = as.stackPop();
							arr = arr + r + " ";
							// 如果栈为空,则直接跳出循环
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
				// 如果字符是(直接入栈,如果)则栈顶元素依次出栈,直到出栈元素是(为止
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
		// 将栈中剩余的元素依次存入字符串中
		while (!as.isEmpty()) {
			char r = as.stackPop();
			arr = arr + r + " ";
		}
		return arr;
	}

	// 逆波兰表达式求值
	private static ArrStack rpn(char[] s) {
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
				if (arr == "") {
					continue;
				} else {
					num = Double.valueOf(arr);
					as.stackPush(num);
					// 字符串置空
					arr = "";
				}

			} else {
				// 遇到运算符字符,弹出栈顶前两个数进行运算后再压入栈中
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
	private static boolean isNumber(char c) {
		if (c >= 48 && c <= 57) {
			return true;
		}
		return false;
	}
	
	// 创建顺序栈
	private static class ArrStack {
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
			@SuppressWarnings("unused")
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
			@SuppressWarnings("unchecked")
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
					System.out.println(elementData[top - 1]);
					// System.out.println("栈的长度" + size);
				} else {
					for (int i = 0; i < size; i++) {
						System.out.print(elementData[i] + " ");
					}
					System.out.println("栈的长度" + size);
				}
			}

			// 返回当前容量
			@SuppressWarnings("unused")
			public void capacity() {
				System.out.println("当前最大容量" + capacity);

			}

			// 返回当前栈顶的值
			@SuppressWarnings("unchecked")
			public <T> T getTop() {
				T data = (T) elementData[top - 1];
				return data;
			}

			// 判空
			public boolean isEmpty() {
				return size == 0;
			}
		}
	}


	