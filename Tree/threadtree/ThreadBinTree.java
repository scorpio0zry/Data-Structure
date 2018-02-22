package threadtree;

//线索二叉树的实现
public class ThreadBinTree<T> {
	// 定义结点类
	class TreeNode {
		private Object data;
		private TreeNode lchild;
		// 判断左孩子是否为线索
		private boolean ltag;

		private TreeNode rchild;
		// 判断右孩子是否为线索
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

	// 根结点
	private TreeNode root;
	// 结点个数
	private int size;

	// 线索化时记录前一个结点
	private TreeNode preNode;
	
	//定义头结点
	private TreeNode head;

	// 获取根结点
	public TreeNode getRoot() {
		return root;
	}

	// 建立二叉树
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
	
	// 先初始化前驱结点,然后中序线索化二叉树
	public void inOrderThread(TreeNode node){
		//定义头结点,将preNode初始化为头结点
		head = new TreeNode();
		head.rtag = true;
		head.rchild = null;
		if(root == null){
			head.lchild = null;
		}else{
			//头结点左孩子默认连接根结点
			head.lchild = node;
			preNode = head;
			//中序线索遍历二叉树
			inThread(node);
			//遍历完后.preNode指向最后一个结点,将他右孩子指向头结点
			preNode.rtag = true;
			preNode.rchild = head;
			head.rchild = preNode;
		}
	}

	// 中序线索化二叉树
	public void inThread(TreeNode node) {
		if (node == null) {
			return;
		}
		// 线索化左子树
		inThread(node.lchild);

		// 假设前驱结点存在
		// 如果左孩子为空,则将ltag置为true,并指向前驱结点
		if (null == node.lchild) {
			node.ltag = true;
			node.lchild = preNode;
		}
		
		// 顺序不可以颠倒 且只能用&&
		// 如果前驱的右孩子为空 ,则将rtag置为true,并指向后继结点
		if (preNode != null && null == preNode.rchild) {
			preNode.rtag = true;
			preNode.rchild = node;
		}

		preNode = node;

		// 线索化右子树
		inThread(node.rchild);
	}

	// 中序遍历线索二叉树
	public void inThreadList(TreeNode node) {
		// 寻找到中序遍历开始的结点,最左边的结点
		while (node != null && !node.ltag) {
			node = node.lchild;
		}

		while (node != null) {
			System.out.print(node.data + " ");
			// 如果rtag为true,则node的右孩子指向后继结点
			if (node.rtag) {
				node = node.rchild;
				//最后一个结点指向定义的头结点,故当node指向头结点时,二叉树已经完全遍历,退出方法
				if(node == head){
					return;
				}
			} else {
				node = node.rchild;
				//如果node的右子树不是线索,则先找到改子树下的最左孩子,所以看ltag是否为线索
				while (node != null && !node.ltag) {
					node = node.lchild;
				}
			}
		}
	}
	
	//中序遍历线索二叉树
	public void inPreThreadList(TreeNode node){
		//找到最后遍历的结点 
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
