package mytree;

import mytree.BinTree.TreeNode;
/*
 * 二叉树
 * 			A
 *     B         C 
 * D       E  F
 * */

public class BinTreeTest {
	public static void main(String[] args) {
		//定义一颗二叉树,根节点是A
		BinTree<Character> bt = new BinTree<Character>('A');

		TreeNode node1 = bt.addNode(bt.getRoot(), 'B', true);
		
		TreeNode node2 = bt.addNode(bt.getRoot(), 'C', false);
		
		TreeNode node3 = bt.addNode(node1, 'D', true);
		
		TreeNode node4 = bt.addNode(node1, 'E', false);
		
		TreeNode node5 = bt.addNode(node2, 'F', true);
		
		System.out.println("树的深度" + bt.getHight());
		System.out.println("树的总结点" + bt.getSize());
		
		System.out.print("前序遍历: ");
		
		bt.preOrder(bt.getRoot());
		
		System.out.println();
		
		System.out.print("中序遍历: ");		
		
		bt.inOrder(bt.getRoot());
		
		System.out.println();
		
		System.out.print("后序遍历: ");
		
		bt.postOrder(bt.getRoot());
	}
}
