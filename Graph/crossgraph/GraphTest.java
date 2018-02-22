package crossgraph;

public class GraphTest {
	public static void main(String[] args) {
		char[] vex = {'A','B','C','D'};
		char[][] side = {{'A','B'},{'B','A'},{'A','C'},{'A','D'},{'D','A'},{'B','C'}};
		CrossGraph cg = new CrossGraph(vex, side);
		cg.print();
	}
}
