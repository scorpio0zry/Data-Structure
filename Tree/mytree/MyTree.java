package mytree;
/*
 * ˫�׺���
 * */
public class MyTree<T> {
	public int MAX_SIZE = 100;
	CTBox<T>[] nodes;
	
	
	
	
	//�����ͷ�ṹ
	public class CTBox<T>{
		private T data; //��������нڵ������
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
	
	
	//���庢�ӽ��
	public class CNode{
		private int child; //�����±�
		private CNode next; //ֻ����һ�����ӵĽڵ�
		//���췽��
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
