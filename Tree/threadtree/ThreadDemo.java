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
		System.out.print("�����������̽��������: ");
		tb.inThreadList(tb.getRoot());
		System.out.println();
		System.out.print("���������ǰ�����������: ");
		tb.inPreThreadList(tb.getRoot());
		
	}
}
