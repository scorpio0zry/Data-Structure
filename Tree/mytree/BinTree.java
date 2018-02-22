package mytree;

//二叉树链表的联系
public class BinTree<T> {
	// 创建结点类
	public class TreeNode {
		Object data;
		TreeNode lchild;
		TreeNode rchild;

		public TreeNode() {
			super();
		}

		public TreeNode(Object data) {
			super();
			this.data = data;
		}
	}

	// 创建根结点
	private TreeNode root;

	public BinTree(T data) {
		root = new TreeNode(data);
	}

	// 获取根结点
	public TreeNode getRoot() {
		return root;
	}

	// 添加结点
	public TreeNode addNode(TreeNode parent, T data, boolean isLeft) {
		if (parent == null) {
			throw new RuntimeException("双亲结点为空!");
		}

		if (isLeft && parent.lchild != null) {
			throw new RuntimeException("左结点不为空!");
		} else if (!isLeft && parent.rchild != null) {
			throw new RuntimeException("右结点不为空!");
		}

		TreeNode node = new TreeNode(data);
		if (isLeft) {
			parent.lchild = node;
		} else {
			parent.rchild = node;
		}

		return node;
	}

	// 获取二叉树的双亲结点
	public TreeNode getParent(TreeNode node) {
		return (node == null) ? null : parent(root, node);
	}

	private TreeNode parent(TreeNode subnode, TreeNode node) {
		if (subnode == null) {
			throw new RuntimeException("二叉树为空");
		}

		if (subnode.lchild == node || subnode.rchild == node) {
			return subnode;
		}
		TreeNode p;

		if ((p = parent(subnode.lchild, node)) != null) {
			return p;
		} else {
			return parent(subnode.rchild, node);
		}

	}

	// 判断二叉树是否为空
	public boolean isEmpty() {
		return root == null ? true : false;
	}

	// 二叉树的结点个数
	public int getSize() {
		return (root == null) ? 0 : size(root);
	}

	public int size(TreeNode node) {
		if (node == null) {
			return 0;
		} else {
			return size(node.lchild) + 1 + size(node.rchild);
		}
	}

	// 二叉树的深度
	public int getHight() {
		return (root == null) ? 0 : high(root);
	}

	public int high(TreeNode node) {
		if (node == null) {
			return 0;
		} else {
			int left = high(node.lchild);
			int right = high(node.rchild);
			return (left > right) ? (left + 1) : (right + 1);
		}
	}

	// 二叉树的遍历
	public void visit(TreeNode node) {
		System.out.print(node.data + " ");
	}

	// 前序遍历
	public void preOrder(TreeNode node) {
		if (node != null) {
			visit(node);
			preOrder(node.lchild);
			preOrder(node.rchild);
		}
	}

	// 中序遍历
	public void inOrder(TreeNode node) {
		if (node != null) {
			inOrder(node.lchild);
			visit(node);
			inOrder(node.rchild);
		}
	}

	// 后序遍历
	public void postOrder(TreeNode node) {
		if (node != null) {
			postOrder(node.lchild);
			postOrder(node.rchild);
			visit(node);
		}
	}
}
