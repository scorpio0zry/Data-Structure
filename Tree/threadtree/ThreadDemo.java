package threadtree;




/*
 * 				A
 * 			B		C
 * 		D	   E F		G
 * 	
 * 
 * */


public class ThreadDemo {
	public static void main(String[] args) {
		Character[] data = {'A','B','C','D','E','F','G'};
		ThreadBinTree<Character> tb = new ThreadBinTree<Character>(data);
		tb.inOrderThread(tb.getRoot());
		System.out.print("中序遍历按后继结点遍历结果: ");
		tb.inThreadList(tb.getRoot());
		System.out.println();
		System.out.print("中序遍历按前驱结点遍历结果: ");
		tb.inPreThreadList(tb.getRoot());
		
	}
}
