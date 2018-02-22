package mytree;

import mytree.BinTree.TreeNode;
/*
 * ������
 * 			A
 *     B         C 
 * D       E  F
 * */

public class BinTreeTest {
	public static void main(String[] args) {
		//����һ�Ŷ�����,���ڵ���A
		BinTree<Character> bt = new BinTree<Character>('A');

		TreeNode node1 = bt.addNode(bt.getRoot(), 'B', true);
		
		TreeNode node2 = bt.addNode(bt.getRoot(), 'C', false);
		
		TreeNode node3 = bt.addNode(node1, 'D', true);
		
		TreeNode node4 = bt.addNode(node1, 'E', false);
		
		TreeNode node5 = bt.addNode(node2, 'F', true);
		
		System.out.println("�������" + bt.getHight());
		System.out.println("�����ܽ��" + bt.getSize());
		
		System.out.print("ǰ�����: ");
		
		bt.preOrder(bt.getRoot());
		
		System.out.println();
		
		System.out.print("�������: ");		
		
		bt.inOrder(bt.getRoot());
		
		System.out.println();
		
		System.out.print("�������: ");
		
		bt.postOrder(bt.getRoot());
	}
}
