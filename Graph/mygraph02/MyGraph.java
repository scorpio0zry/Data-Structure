package mygraph02;

import java.util.Scanner;

//�ڽӱ�
public class MyGraph {
	// һά���鴢�����ж���
	private Vertex[] graph;
	// �ߵ�����
	int numSide;
	// ���������
	int numVertex;

	public MyGraph() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void createGraph() {
		// ����ߺͶ��������
		Scanner sc = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		System.out.println("������ߵ�����");
		numSide = sc.nextInt();
		System.out.println("�����붥�������");
		numVertex = sc.nextInt();

		// ���붥��
		getVertex();

		// �����
		for (int i = 0; i < graph.length; i++) {
			getfirst(graph, i);
		}
	}

	// �����
	private void getfirst(Vertex[] graph, int n) {
		Scanner sc = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		System.out.println("�����붥��" + graph[n].getVertex() + "���ڽ������� :");
		int num = sc.nextInt();
		System.out.println("�������ڽ��");
		String str = sc2.nextLine();
		// ����һ���������������ڽ������ַ�������
		char[] newStr = (graph[n].getVertex() + str.replaceAll("[^1-9a-zA-Z]*",
				"").substring(0, num)).toCharArray();
		// ����graph��ͷ��� ֵΪnull
		Side pre = new Side();
		graph[n].setSide(pre);
		// �ڽ������Ϊ0
		if (num == 0) {
		} else {
			for (int j = 1; j < newStr.length; j++) {
				System.out.println("������" + newStr[0] + "��" + newStr[j] + "��Ȩ��");
				int weight = sc.nextInt();
				Side side = new Side(newStr[j], weight);
				pre.setNext(side);
				pre = side;
			}
		}
	}

	// ��ȡ����
	public void getVertex() {
		Scanner sc = new Scanner(System.in);
		this.graph = new Vertex[numVertex];
		System.out.println("�����붥��:");
		String str = sc.nextLine();
		char[] newStr = str.replaceAll("[^1-9a-zA-Z]*", "")
				.substring(0, numSide).toCharArray();
		for (int i = 0; i < newStr.length; i++) {
			// ����graph[]��ÿ��vertex����
			graph[i] = new Vertex(newStr[i], null);
		}
	}
}
