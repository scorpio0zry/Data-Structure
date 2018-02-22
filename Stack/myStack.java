package com.royal;


import java.util.Arrays;

//应用:将二进制转换成十进制
//顺序栈的实现
public class myStack {
	public static void main(String[] args) {
		ArrayStack S = new ArrayStack(3);
		//二进制为整数时,转换成十进制
		int num = 1010;
		int decimal = S.transDecimal(num);
		System.out.println(decimal);
		
		//二进制为字符时,转换成十进制
		char[] num1 = {'1','0','1','0','1','0','0','1'};
		int decimal1 = S.transDecimal(num1);
		System.out.println(decimal1);
		//二进制为字符时,转换成八进制
		char[] num3 = S.transOctal(num1);
		for(int i=0;i<num3.length;i++){
			System.out.print(num3[i]);
		}
		
		System.out.println();
		//二进制为字符时,转换成十六进制
		char[] num4 = S.transHex(num1);
		for (int i = 0; i < num4.length; i++) {
			System.out.print(num4[i]);
			
		}
	}

	// 顺序栈的类
	public static class ArrayStack {
		// 定义数组保存顺序栈的元素
		private Object[] elementData;
		// 栈的长度
		private int size;
		// 数组的长度
		private int capacity;;
		// 定义栈顶
		public int top;

		// 创建栈时,默认创建一个长度为20的数组
		public ArrayStack() {
			elementData = new Object[20];
			capacity = 20;

		}

		// 创建栈时,自定义数组的长度
		public ArrayStack(int capacity) {
			elementData = new Object[capacity];
			this.capacity = capacity;

		}

		// 入栈  如果长度超过容量则扩容
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

		// 出栈
		public <T> T stackPop() {
			if(size ==  0){
				System.out.println("空栈");
				return null;
			}else{
				T data = (T) this.elementData[top - 1];
				top--;
				size--;
				return data;
			}
		
		}

		// 遍历栈
		public void listStack() {
			if (top == 0) {
				System.out.println("空栈");
				System.out.println("栈的长度" + size);
			} else {
				for (int i = 0; i < top; i++) {
					System.out.print(elementData[i] + " ");
				}
				System.out.println();
				System.out.println("栈的长度" + size);
			}
		}

		// 返回当前容量
		public void capacity() {
			System.out.println("当前最大容量" + capacity);

		}
		
		
		//清空栈
		public void stackClear(){
			Arrays.fill(elementData, null);
			size = 0;
		}
		
		//二进制为整数时,转换成十进制
		public int transDecimal(int num){
			//将二进制num推入栈中(最高次幂在栈顶)
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
			//将二进制依次推出栈中
			int sum = 0;
			for(int i=m;i>0;i--){
				int p = stackPop();
				sum = (int) (sum +p* Math.pow(2, i-1));
			}
			return sum;
		}
		
		
			
		
		
		
		//求整数的个数方法
		public int getNumber(int num){
			int m = 0;
			int p = num;
			while(p != 0){
				p  /= 10;
				m++;
			}
			
			return m;
		}
		
		//二进制为字符时,转换成十进制
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
		
		//二进制为字符时,转换成八进制
		public char[] transOctal(char[] num){
			for(int i=0;i<num.length;i++){
				stackPush(num[i]);
			}
			//建立八进制数组
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
		
		//二进制为字符时,转换成十六进制
		public char[] transHex(char[] num){
			for(int i=0;i<num.length;i++){
				stackPush(num[i]);
			}
			//建立十六进制数组
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
