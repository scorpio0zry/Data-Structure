package com.royal;

//˫��ѭ������
public class DLineListNode {
	public static void main(String[] args) {
		DLineList L = new DLineList();
		L.addDNode(1);
		//L.addDNode(3);
		//L.addDNode(1, 2);
		L.deleteNode(1);
		L.list();
	}

	// ����ӿ�
	public interface List {
		public void list();

		public void addDNode(int data);

		public void addDNode(int i, int data);

		public void deleteNode(int i);
	}

	// ������
	public static class DNode {
		private int data;
		private DNode prior;
		private DNode next;

		public DNode() {
			this.data = 0;
			this.prior = null;
			this.next = null;
		}

		public DNode(int data) {
			this.data = data;
			this.prior = null;
			this.next = null;
		}
	}

	public static class DLineList implements List {
		// ����ͷ���
		private DNode head;

		// ����������
		private int size;

		// ���캯�� ����������
		public DLineList() {

			head = null;

			this.size = 0;
		}

		@Override
		// ��������(β�巨)
		public void addDNode(int data) {
			if (head == null) {
				DNode node = new DNode(data);
				head = node;
				head.next = head.prior = head;
				size++;
			} else if (head.next == head) {
				DNode node = new DNode(data);
				node.next = head.next;
				node.prior = head;
				head.next = node;
				head.prior = node;
				size++;

			} else {
				DNode temp = head;
				while (temp.next != head) {
					temp = temp.next;
				}
				DNode node = new DNode(data);
				node.next = temp.next;
				temp.next.prior = node;
				node.prior = temp;
				temp.next = node;
				size++;
			}
		}

		@Override
		// �����ָ��λ�ò���
		public void addDNode(int i, int data) {

			if (i < 1 || i > size + 1) {
				System.out.println("�����λ��i����ȷ");
			} else if (i == 1) {
				DNode node = new DNode(data);
				node.next = head;
				node.prior = head.prior;
				head.prior.next = node;
				head.prior = node;
				head = node;
				size++;
			} else {
				DNode temp = head;
				for (int j = 2; j < i; j++) {
					temp = temp.next;
				}
				DNode node = new DNode(data);
				node.next = temp.next;
				node.prior = temp;
				temp.next.prior = node;
				temp.next = node;
				size++;
			}
		}

		@Override
		// ����ı���
		public void list() {
			if (head == null) {
				System.out.println("������");
				System.out.println("����ĳ���" + size);
			} else {
				DNode temp = head;
				while (temp.next != head) {
					System.out.print(temp.data + "->");
					temp = temp.next;
				}
				System.out.println(temp.data);
				System.out.println("����ĳ���" + size);
			}

		}

		@Override//����ɾ��
		public void deleteNode(int i) {
			if(i<1 || i>size){
				System.out.println("��������λ��!");
			}else if(i == 1){
				head.next.prior = head.prior;
				head.prior.next = head.next;
				head = head.next;
				size--;
				if(head.next == head){
					head = null;
				}
			}else{
				DNode temp = head;
				if(i/2<size){
					for(int j=1;j<i;j++){
						temp = temp.next;
					}
					temp.next.prior = temp.prior;
					temp.prior.next = temp.next;
					temp = null;
					size--;
				}else{
					for(int j=0;j<size-i+1;j++){
						temp = temp.prior;
					}
					temp.next.prior = temp.prior;
					temp.prior.next = temp.next;
					temp = null;
					size--;
				}
			}
		}
		
		
		
	}
}
