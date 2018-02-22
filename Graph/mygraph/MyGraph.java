package mygraph;

import java.util.Scanner;

//�ڽӾ���(ͼ)
public class MyGraph {
	int MAX_SIZE = 100;
	// ����һ��һά����洢����
	final static int INFINITE = Integer.MAX_VALUE;
	char[] vex;
	// �����ά����洢��
	int[][] side;
	// �ߵ�����
	int numSide;
	// ���������
	int numVertex;

	public void createGraph() {
		// ����ߺͶ��������
		Scanner sc = new Scanner(System.in);
		System.out.println("������ߵ�����");
		numSide = sc.nextInt();
		System.out.println("�����붥�������");
		numVertex = sc.nextInt();
		// ���ݶ�������������
		vex = new char[numVertex];
		side = new int[numVertex][numVertex];
		// ���붥��
		Scanner sc2 = new Scanner(System.in);
		System.out.println("�����붥��");
		String str = sc2.nextLine();
		// ����������ʽ,���Ƿ������ַ�ȥ��
		vex = str.replaceAll("[^1-9a-zA-Z]*", "").substring(0, numVertex)
				.toCharArray();

		// �����ʼ��
		for (int i = 0; i < side.length; i++) {
			for (int j = 0; j < side.length; j++) {
				if (i == j) {
					side[i][j] = 0;
				} else {
					side[i][j] = INFINITE;
				}
			}
		}

		// ��������
		System.out.println("������ͼ�Ľṹ:1.����ͼ   2.����ͼ");
		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			method1();
			break;
		case 2:
			method2();
			break;
		default:
		}

	}

	// ����ͼ
	private void method2() {
		Scanner sc = new Scanner(System.in);
		// ��������Ȩ��
		for (int i = 0; i < side.length; i++) {
			for (int j = 0; j < side.length; j++) {
				if (i == j) {

				} else {
					System.out.println("������" + vex[i] + "��" + vex[j] + "��Ȩ��");
					int weight = sc.nextInt();
					side[i][j] = weight;
					side[j][i] = side[i][j];
				}
			}
		}
	}

	// ����ͼ
	public void method1() {
		Scanner sc = new Scanner(System.in);
		// ��������Ȩ��
		for (int i = 0; i < side.length; i++) {
			for (int j = i; j < side.length; j++) {
				if (i == j) {

				} else {
					System.out.println("������" + vex[i] + "��" + vex[j] + "��Ȩ��");
					int weight = sc.nextInt();
					side[i][j] = weight;
					side[j][i] = side[i][j];
				}
			}
		}
	}

}
