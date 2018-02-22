package mytree;

//�������������ϵ
public class BinTree<T> {
	// ���������
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

	// ���������
	private TreeNode root;

	public BinTree(T data) {
		root = new TreeNode(data);
	}

	// ��ȡ�����
	public TreeNode getRoot() {
		return root;
	}

	// ��ӽ��
	public TreeNode addNode(TreeNode parent, T data, boolean isLeft) {
		if (parent == null) {
			throw new RuntimeException("˫�׽��Ϊ��!");
		}

		if (isLeft && parent.lchild != null) {
			throw new RuntimeException("���㲻Ϊ��!");
		} else if (!isLeft && parent.rchild != null) {
			throw new RuntimeException("�ҽ�㲻Ϊ��!");
		}

		TreeNode node = new TreeNode(data);
		if (isLeft) {
			parent.lchild = node;
		} else {
			parent.rchild = node;
		}

		return node;
	}

	// ��ȡ��������˫�׽��
	public TreeNode getParent(TreeNode node) {
		return (node == null) ? null : parent(root, node);
	}

	private TreeNode parent(TreeNode subnode, TreeNode node) {
		if (subnode == null) {
			throw new RuntimeException("������Ϊ��");
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

	// �ж϶������Ƿ�Ϊ��
	public boolean isEmpty() {
		return root == null ? true : false;
	}

	// �������Ľ�����
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

	// �����������
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

	// �������ı���
	public void visit(TreeNode node) {
		System.out.print(node.data + " ");
	}

	// ǰ�����
	public void preOrder(TreeNode node) {
		if (node != null) {
			visit(node);
			preOrder(node.lchild);
			preOrder(node.rchild);
		}
	}

	// �������
	public void inOrder(TreeNode node) {
		if (node != null) {
			inOrder(node.lchild);
			visit(node);
			inOrder(node.rchild);
		}
	}

	// �������
	public void postOrder(TreeNode node) {
		if (node != null) {
			postOrder(node.lchild);
			postOrder(node.rchild);
			visit(node);
		}
	}
}
