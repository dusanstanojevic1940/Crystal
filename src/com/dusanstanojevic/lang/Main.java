package com.dusanstanojevic.lang;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner s = new Scanner(new File("test.crystal"));
		String code="";
		
		while (s.hasNextLine()) {
			String line = s.nextLine();
			if (!line.startsWith("#"))
				code+=(line+"\n");
		}
		
		Interpreter crystalInterpreter = new Interpreter(code);
		
		crystalInterpreter.begin();
		
		while (crystalInterpreter.hasMoreToExecute()) {
			crystalInterpreter.executeNextLine();
		}
		s.close();
	}
}
