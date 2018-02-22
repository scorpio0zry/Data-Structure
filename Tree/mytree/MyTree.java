package mytree;
/*
 * 双亲孩子
 * */
public class MyTree<T> {
	public int MAX_SIZE = 100;
	CTBox<T>[] nodes;
	
	
	
	
	//定义表头结构
	public class CTBox<T>{
		private T data; //存放在树中节点的数据
		private int parent;
		private CNode firstChild;
		
		public CTBox() {
		}

		public CTBox(T data, int parent) {
			this.data = data;
			this.parent = parent;
		}

		public T getData() {
			return data;
		}

		public void setData(T data) {
			this.data = data;
		}

		public int getParent() {
			return parent;
		}

		public void setParent(int parent) {
			this.parent = parent;
		}

		public CNode getFirstChild() {
			return firstChild;
		}

		public void setFirstChild(CNode firstChild) {
			this.firstChild = firstChild;
		}
		
		
		
		
	}
	
	
	//定义孩子结点
	public class CNode{
		private int child; //孩子下标
		private CNode next; //只想下一个孩子的节点
		//构造方法
		public CNode() {
		}
		public CNode(int child) {
			this.child = child;
		}

		public int getChild() {
			return child;
		}
		public void setChild(int child) {
			this.child = child;
		}
		public CNode getNext() {
			return next;
		}
		public void setNext(CNode next) {
			this.next = next;
		}
		
	}
}
