package iothreads;

import java.util.*;
import java.io.*;

import javax.xml.bind.DatatypeConverter;

public class Test {

	private Vector<String> lines = new Vector<String>();

	private void readFile(String filename) throws Exception {
		FileReader fin = new FileReader(new File(filename));
		BufferedReader bin = new BufferedReader(fin);

		String line = null;
		while ((line = bin.readLine()) != null) {
			// System.out.println(line);
			lines.add(line);
		}

	}

	private void writeFile(String filename) throws Exception {
		FileWriter fout = new FileWriter(new File(filename));
		BufferedWriter bout = new BufferedWriter(fout);

		for (String line : lines) {
			bout.write(line + "\n");

		}

		bout.close();
		fout.close();

	}

	private static String enc(String line) {
		return DatatypeConverter.printBase64Binary(line.getBytes());

	}

	private static String dec(String line) {
		return new String(DatatypeConverter.parseBase64Binary(line));
	}

	private void process() {
		Vector<String> newLines = new Vector<String>();
		for (String line : lines) {
			line = enc(line);
			newLines.add(line);
			// System.out.println(line);
		}
		lines = newLines;
	}

	private void undo() {
		Vector<String> newLines = new Vector<String>();
		for (String line : lines) {
			line = dec(line);
			newLines.add(line);
			// System.out.println(line);
		}
		lines = newLines;
	}

	public static void main(String[] args) throws Exception {
		Test test = new Test();

		// test.readFile("test.data");
		// test.process();
		// test.writeFile("test_new.data");

		test.readFile("test_new.data");
		test.undo();

	}

}
