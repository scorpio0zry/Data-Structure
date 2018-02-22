package threadtree;

//������������ʵ��
public class ThreadBinTree<T> {
	// ��������
	class TreeNode {
		private Object data;
		private TreeNode lchild;
		// �ж������Ƿ�Ϊ����
		private boolean ltag;

		private TreeNode rchild;
		// �ж��Һ����Ƿ�Ϊ����
		private boolean rtag;

		public TreeNode() {
		}

		public TreeNode(Object data) {
			this.data = data;
			lchild = null;
			ltag = false;
			rchild = null;
			rtag = false;
		}

		public Object getData() {
			return data;
		}

		public void setData(Object data) {
			this.data = data;
		}

		public TreeNode getLchild() {
			return lchild;
		}

		public void setLchild(TreeNode lchild) {
			this.lchild = lchild;
		}

		public boolean isLtag() {
			return ltag;
		}

		public void setLtag(boolean ltag) {
			this.ltag = ltag;
		}

		public TreeNode getRchild() {
			return rchild;
		}

		public void setRchild(TreeNode rchild) {
			this.rchild = rchild;
		}

		public boolean isRtag() {
			return rtag;
		}

		public void setRtag(boolean rtag) {
			this.rtag = rtag;
		}
	}

	// �����
	private TreeNode root;
	// ������
	private int size;

	// ������ʱ��¼ǰһ�����
	private TreeNode preNode;
	
	//����ͷ���
	private TreeNode head;

	// ��ȡ�����
	public TreeNode getRoot() {
		return root;
	}

	// ����������
	public ThreadBinTree(T[] data) {
		this.size = data.length;
		this.root = createBinTree(data, 1);
	}

	public TreeNode createBinTree(T[] data, int index) {
		if (index > data.length) {
			return null;
		}
		TreeNode node = new TreeNode(data[index - 1]);
		TreeNode left = createBinTree(data, 2 * index);
		TreeNode right = createBinTree(data, 2 * index + 1);
		node.setLchild(left);
		node.setRchild(right);

		return node;

	}
	
	// �ȳ�ʼ��ǰ�����,Ȼ������������������
	public void inOrderThread(TreeNode node){
		//����ͷ���,��preNode��ʼ��Ϊͷ���
		head = new TreeNode();
		head.rtag = true;
		head.rchild = null;
		if(root == null){
			head.lchild = null;
		}else{
			//ͷ�������Ĭ�����Ӹ����
			head.lchild = node;
			preNode = head;
			//������������������
			inThread(node);
			//�������.preNodeָ�����һ�����,�����Һ���ָ��ͷ���
			preNode.rtag = true;
			preNode.rchild = head;
			head.rchild = preNode;
		}
	}

	// ����������������
	public void inThread(TreeNode node) {
		if (node == null) {
			return;
		}
		// ������������
		inThread(node.lchild);

		// ����ǰ��������
		// �������Ϊ��,��ltag��Ϊtrue,��ָ��ǰ�����
		if (null == node.lchild) {
			node.ltag = true;
			node.lchild = preNode;
		}
		
		// ˳�򲻿��Եߵ� ��ֻ����&&
		// ���ǰ�����Һ���Ϊ�� ,��rtag��Ϊtrue,��ָ���̽��
		if (preNode != null && null == preNode.rchild) {
			preNode.rtag = true;
			preNode.rchild = node;
		}

		preNode = node;

		// ������������
		inThread(node.rchild);
	}

	// �����������������
	public void inThreadList(TreeNode node) {
		// Ѱ�ҵ����������ʼ�Ľ��,����ߵĽ��
		while (node != null && !node.ltag) {
			node = node.lchild;
		}

		while (node != null) {
			System.out.print(node.data + " ");
			// ���rtagΪtrue,��node���Һ���ָ���̽��
			if (node.rtag) {
				node = node.rchild;
				//���һ�����ָ�����ͷ���,�ʵ�nodeָ��ͷ���ʱ,�������Ѿ���ȫ����,�˳�����
				if(node == head){
					return;
				}
			} else {
				node = node.rchild;
				//���node����������������,�����ҵ��������µ�������,���Կ�ltag�Ƿ�Ϊ����
				while (node != null && !node.ltag) {
					node = node.lchild;
				}
			}
		}
	}
	
	//�����������������
	public void inPreThreadList(TreeNode node){
		//�ҵ��������Ľ�� 
		while(node!=null&&!node.rtag){
			node = node.rchild;
		}
		
		while(node!=null){
			System.out.print(node.data + " ");
			if(node.ltag){
				node = node.lchild;
				if(node == head){
					return;
				}
			}else{
				node = node.lchild;
				while(node!=null&&!node.rtag){
					node = node.rchild;
				}
			}
		}
	}
	


}
