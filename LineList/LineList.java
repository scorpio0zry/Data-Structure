package com.royal;

public class LineList {
	int maxsize = 20;
	String[] data = new String[maxsize];
	int length;
	
	public static void main(String[] args) {
		LineList L = new LineList();
		L.length = 0;
		
		mean M = new mean();
		M.ListInsert(L, 1, "a");
		M.ListInsert(L, 2, "b");
		M.ListInsert(L, 3, "c");
		//M.List(L);
		String e = M.ListDelete(L, 2);
		System.out.println(e);
		M.List(L);
		
	}
}
	
class mean{
	//线性表的插入
	public int ListInsert(LineList L,int i,String e){
		if(L.length == L.maxsize){
			return 0;
		}
		if(i<0){
			return 0;
		}
		if(i>L.length){
			L.data[L.length] = e;
			L.length++;
			return 1;
		}
		if(i<=L.length){
			for(int k=L.length-1;k<i;k--){
				L.data[k+1] = L.data[k];
			}
		}
		L.data[i-1] = e;
		L.length=+1;
		
		
		return 1;
	}
	
	//线性表元素的获取
	public int GetElem(LineList L, int i, String e){
		if(i<0 || i>L.length){
			return -1;
		}
		e = L.data[i-1];
		return 1;
	}
	
	//线性表删除
	public String ListDelete(LineList L,int i){
		if(i<0 || i>L.length){
			return "Error";
		}else{
			String e = L.data[i-1];
			for(int k = i;k<L.length;k++){
				L.data[k-1] = L.data[k];	
			}
			L.length--;
			return e;
		}	
	}

	//线性表遍历
	public void List(LineList L){
		for(int i=0;i<L.length;i++){
			System.out.println(L.data[i]);
		}
	}
}


