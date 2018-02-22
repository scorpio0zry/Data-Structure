package crossgraph;

/**
 * Author:scorpio0zry
 * 
 * ����:��java����ʮ������ ��ʾ����ͼ
 * 
 * */
public class CrossGraph {
	int vexL; // ��������
	int sideL; // �ߵ�����

	Vertex[] vertexs; // ��������

	// ���嶥����
	private class Vertex {
		char vertex;
		SideNode firstin; // ��ʾָ��ö�����ȵĵ�һ����
		SideNode firstout; // ��ʾָ��ö�����ȵĵ�һ����

		public Vertex() {
			super();
		}

		public Vertex(char vertex) {
			super();
			this.vertex = vertex;
		}

	}

	// ����߽��
	private class SideNode {
		int tailvex; // ��β�ڶ�����е��±�
		int headvex; // ��ͷ�ڶ�����е��±�
		SideNode headlink; // ָ����ͬ�յ�(��ͷһ��)����һ���� ����
		SideNode taillink; // ָ����ͬ���(��βһ��)����һ���� ���

		public SideNode(int tailvex, int headvex) {
			super();
			this.tailvex = tailvex;
			this.headvex = headvex;
		}

	}

	/**
	 * ���캯��: ��ʼ��ʮ������ ����: ���� ����� char[][] side = {'A','B'} A -> B
	 */
	public CrossGraph(char[] vex, char[][] side) {
		vexL = vex.length;
		sideL = side.length;
		vertexs = new Vertex[vexL];

		// ��ʼ������ , ���������
		for (int i = 0; i < vexL; i++) {
			vertexs[i] = new Vertex(vex[i]);
		}

		// ����ͷ�巨����ʮ������
		for (int i = 0; i < sideL; i++) {

			// ȡ��ͬһ���߻�β����(���)�±�ͻ�ͷ����(�յ�)�±�
			int tail = getPostion(side[i][0], vertexs); // ��β����(���)
			int head = getPostion(side[i][1], vertexs); // ��ͷ����(�յ�)
			
			//�����߽��   tail -> head
			SideNode Node = new SideNode(tail, head);

			// ����ȱ����β��뵽��ͬ�յ�Ķ����
			Node.taillink = vertexs[head].firstin;
			vertexs[head].firstin = Node;

			// ͷ�巨 �����ȱ����β�����ͬ���Ķ����
			Node.headlink = vertexs[tail].firstout;
			vertexs[tail].firstout = Node;
			
		}
	}

	// ���Ҷ�����±�
	private int getPostion(char c, Vertex[] vertexs) {
		for (int i = 0; i < vertexs.length; i++) {
			if (vertexs[i].vertex == c) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * ��ӡ ʮ������
	 */
	public void print() {
		// ��ӡ�ڽӱ�
		System.out.println("�ڽӱ�: ");
		for (int i = 0; i < vertexs.length; i++) {
			System.out.print(vertexs[i].vertex + "->");
			if (vertexs[i].firstout != null) {
				SideNode pre = vertexs[i].firstout;
				while (pre != null) {
					if (pre.headlink == null) {
						System.out.println(vertexs[pre.headvex].vertex);
					} else {
						System.out.print(vertexs[pre.headvex].vertex + ",");
					}
					pre = pre.headlink;
				}
			} else {
				System.out.println();
			}
		}

		// ��ӡ���ڽӱ�
		System.out.println("���ڽӱ�");
		for (int i = 0; i < vertexs.length; i++) {
			System.out.print(vertexs[i].vertex + "<-");
			if (vertexs[i].firstin != null) {
				SideNode pre = vertexs[i].firstin;
				while (pre != null) {
					if (pre.taillink == null) {
						System.out.println(vertexs[pre.tailvex].vertex);
					} else {
						System.out.print(vertexs[pre.tailvex].vertex + ",");
					}
					pre = pre.taillink;
				}
			} else {
				System.out.println();
			}
		}
	}
}
