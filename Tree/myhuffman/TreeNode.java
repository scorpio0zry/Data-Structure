package myhuffman;

//�����������Ľ���
public class TreeNode {	
	//�������
	private Object data;
	
	//���Ȩֵ
	private int count;
	
	private TreeNode lchild;
	
	private TreeNode rchild;
	
	public TreeNode(){}
	
	public TreeNode(Object data,int count){
		this.data = data;
		this.count = count;
	}
	
	public TreeNode(int count, TreeNode lchild,TreeNode rchild){
		this.count = count;
		this.lchild = lchild;
		this.rchild = rchild;
		data = null;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public TreeNode getLchild() {
		return lchild;
	}

	public void setLchild(TreeNode lchild) {
		this.lchild = lchild;
	}

	public TreeNode getRchild() {
		return rchild;
	}

	public void setRchild(TreeNode rchild) {
		this.rchild = rchild;
	}
	

}
