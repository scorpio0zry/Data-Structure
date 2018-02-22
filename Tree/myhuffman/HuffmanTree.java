package myhuffman;

import java.util.ArrayList;

//哈夫曼树的实现
public class HuffmanTree {
	private TreeNode root;
	private ArrayList<String> list; // 存储不同字符的队列,相同的字符在同一位置
	private ArrayList<TreeNode> nodeList; // 存储结点的队列

	// 将字符串中的字符分类分类
	public void createHuffmanTree(String s) {
		list = new ArrayList<String>();
		nodeList = new ArrayList<TreeNode>();

		// 将字符串中相同的字符找出来合并到一起,添加到集合中
		for (int i = 0; i < s.length(); i++) {
			// 判断字符是否在集合中存在的标签,若存在则置为false
			boolean flag = true;
			char ch = s.charAt(i);
			for (int j = 0; j < list.size(); j++) {
				// 遍历集合,如果ch在集合中,则将其加入该集合中
				if (ch == list.get(j).charAt(0)) {
					String str = list.get(j) + ch;
					list.set(j, str);
					flag = false;
					break;
				}
			}

			if (flag) {
				// 如果集合中不存在该字符,则将其添加到集合中
				list.add(ch + "");
			}

		}

		// 创建结点,将其添加到nodeList集合中
		for (int i = 0; i < list.size(); i++) {
			String str = list.get(i);
			// 创建结点对象
			TreeNode node = new TreeNode(str.charAt(0) + "", str.length());
			nodeList.add(node);
		}

		// 将nodeList中的元素权限由小到排序
		nodeList = Sort(nodeList);
		// 当nodeList中元素不为1个时,将最小的两个结点依次取出,合并成新的结点,并将新结点添加到nodeList的首位置
		while (nodeList.size() > 1) {
			// 将第一个取出的结点定义为右孩子结点
			TreeNode rchild = nodeList.remove(0);
			TreeNode lchild = nodeList.remove(0);
			int count = lchild.getCount() + rchild.getCount();
			// 利用TreeNode的第二种构造方法,将parent创建出来,其左右子树分别指向最小的两个结点
			TreeNode parent = new TreeNode(count, lchild, rchild);
			// 将新结点添加到nodeList的首位置
			nodeList.add(0, parent);
		}
		// 将最后剩下的结点赋值给root
		root = nodeList.get(0);

	}

	 //将nodeList中的元素权限由小到排序
	private ArrayList<TreeNode> Sort(ArrayList<TreeNode> nodeList) {
		ArrayList<TreeNode> newNodeList = new ArrayList<TreeNode>();
		
		while(nodeList.size()>0){
			TreeNode min = nodeList.get(0);
			for (int i = 1; i < nodeList.size(); i++) {
				if(min.getCount()>nodeList.get(i).getCount()){
					min = nodeList.get(i);
				}
			}
			newNodeList.add(min);
			nodeList.remove(min);
		}
		
		return newNodeList;
		
	}
	
//	private void Sort(ArrayList<TreeNode> nodeList){
//		for (int i = 0; i < nodeList.size(); i++) {
//			for (int j = 0; j < nodeList.size(); j++) {
//				int num1 = nodeList.get(i).getCount();
//				int num2 = nodeList.get(j).getCount();
//				TreeNode node1 = nodeList.get(i);
//				TreeNode node2 = nodeList.get(j);
//				if(num1 < num2){
//					nodeList.set(i,node2);
//					nodeList.set(j,node1);
//				}
//			}
//		}
//	}
	
	
	//遍历哈弗曼二叉树
	public void List(){
		HUFMList(root);
	}
	
	private void HUFMList(TreeNode node){
		if(node.getLchild()!=null){
			visit(node.getLchild());
		}else{
			node = node.getRchild();
		}	
		node = node.getRchild();
		if(node.getRchild() == null){
			visit(node);
			return;
		}
		HUFMList(node);
		
	}

	private void visit(TreeNode lchild) {
		System.out.println(lchild.getCount()+"--" + lchild.getData());
	}

}