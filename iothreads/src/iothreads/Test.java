package iothreads;

import java.util.*;
import java.io.*;


public class Test {
	
	private Vector<String> lines = new Vector<String>();
	
	private void readFile(String filename) throws Exception {
		FileReader fin = new FileReader(new File(filename));
		BufferedReader bin = new BufferedReader(fin);
		
		String line = null;
		while ((line=bin.readLine())!=null) {
			System.out.println(line);
		}
		
		
		
		
	}
	
	private void writeFile() {

	}
	
	
	
	
	public static void main(String[] args) throws Exception {
		Test test = new Test();
		
		test.readFile("");
	}
	
	
}
