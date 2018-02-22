package myhuffman;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class HuffmanTreeDemo {
	public static void main(String[] args) throws IOException {
		HuffmanTree ht = new HuffmanTree();
		String line = read();
		ht.createHuffmanTree(line);
		ht.List();
	}
	
	
	public static String read() throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("data.txt"));
		char[] ch = new char[1024];
		String line = "";
		int len;
		while((len = br.read(ch))!=-1){
			line += new String(ch,0,len);
		}
		br.close();
		return line;
	}
}
