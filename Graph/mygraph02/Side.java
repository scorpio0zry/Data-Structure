package mygraph02;

//�߽��
public class Side {
	private char name;
	//����Ȩ��
	private int weight;
	//ָ���̽��
	private Side next;
	public Side() {
		super();
		this.name = '\0';
		this.weight = 0;
		this.next = null;
				
	}
	
	public Side(char name, int weight) {
		super();
		this.name = name;
		this.weight = weight;
		this.next = null;
	
	}
	
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public Side getNext() {
		return next;
	}
	public void setNext(Side next) {
		this.next = next;
	}
	
	
	
}
