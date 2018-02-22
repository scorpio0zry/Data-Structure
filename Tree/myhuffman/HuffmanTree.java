package myhuffman;

import java.util.ArrayList;

//����������ʵ��
public class HuffmanTree {
	private TreeNode root;
	private ArrayList<String> list; // �洢��ͬ�ַ��Ķ���,��ͬ���ַ���ͬһλ��
	private ArrayList<TreeNode> nodeList; // �洢���Ķ���

	// ���ַ����е��ַ��������
	public void createHuffmanTree(String s) {
		list = new ArrayList<String>();
		nodeList = new ArrayList<TreeNode>();

		// ���ַ�������ͬ���ַ��ҳ����ϲ���һ��,��ӵ�������
		for (int i = 0; i < s.length(); i++) {
			// �ж��ַ��Ƿ��ڼ����д��ڵı�ǩ,����������Ϊfalse
			boolean flag = true;
			char ch = s.charAt(i);
			for (int j = 0; j < list.size(); j++) {
				// ��������,���ch�ڼ�����,�������ü�����
				if (ch == list.get(j).charAt(0)) {
					String str = list.get(j) + ch;
					list.set(j, str);
					flag = false;
					break;
				}
			}

			if (flag) {
				// ��������в����ڸ��ַ�,������ӵ�������
				list.add(ch + "");
			}

		}

		// �������,������ӵ�nodeList������
		for (int i = 0; i < list.size(); i++) {
			String str = list.get(i);
			// ����������
			TreeNode node = new TreeNode(str.charAt(0) + "", str.length());
			nodeList.add(node);
		}

		// ��nodeList�е�Ԫ��Ȩ����С������
		nodeList = Sort(nodeList);
		// ��nodeList��Ԫ�ز�Ϊ1��ʱ,����С�������������ȡ��,�ϲ����µĽ��,�����½����ӵ�nodeList����λ��
		while (nodeList.size() > 1) {
			// ����һ��ȡ���Ľ�㶨��Ϊ�Һ��ӽ��
			TreeNode rchild = nodeList.remove(0);
			TreeNode lchild = nodeList.remove(0);
			int count = lchild.getCount() + rchild.getCount();
			// ����TreeNode�ĵڶ��ֹ��췽��,��parent��������,�����������ֱ�ָ����С���������
			TreeNode parent = new TreeNode(count, lchild, rchild);
			// ���½����ӵ�nodeList����λ��
			nodeList.add(0, parent);
		}
		// �����ʣ�µĽ�㸳ֵ��root
		root = nodeList.get(0);

	}

	 //��nodeList�е�Ԫ��Ȩ����С������
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
	
	
	//����������������
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