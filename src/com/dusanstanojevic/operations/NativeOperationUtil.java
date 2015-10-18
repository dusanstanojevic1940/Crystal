package com.dusanstanojevic.operations;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

import com.dusanstanojevic.lang.Function;
import com.dusanstanojevic.types.Type;
import com.dusanstanojevic.types.VariableType;

public class NativeOperationUtil {
	public static final String[] NATIVE_FUNCTIONS = new String[] {"SUM", "DIV", "MUL", "MINUS", "PRINT", "READ", "CLOSE", "RANDOM", "TO_NUMBER", "TO_TEXT", "FOR_", "IF_", "NEGATE", "EQ", "LT", "GT"};
	
	public static void execute(Stack<Function> stack, String nativeF, Map<String, List<String>> functions, Map<String, Type> globalVariables) {
		switch (nativeF) {
			case "PRINT":
				System.out.println(globalVariables.get("PRINT_1"));
				break;
			case "SUM":
				Type a = globalVariables.get("SUM_1");
				Type b = globalVariables.get("SUM_2");
				globalVariables.put("SUM_RESULT", Sum.execute(a, b));
				break;
			case "DIV":
				globalVariables.put("DIV_RESULT", new Type(VariableType.NUMBER, (
						Double.parseDouble(globalVariables.get("DIV_1").getValue())/
						Double.parseDouble(globalVariables.get("DIV_2").getValue()))+""));
				break;
			case "MINUS":
				globalVariables.put("MINUS_RESULT", new Type(VariableType.NUMBER, (
						Double.parseDouble(globalVariables.get("MINUS_1").getValue())-
						Double.parseDouble(globalVariables.get("MINUS_2").getValue()))+""));
				break;
			case "MUL":
				globalVariables.put("MUL_RESULT", new Type(VariableType.NUMBER, (
						Double.parseDouble(globalVariables.get("MUL_1").getValue())*
						Double.parseDouble(globalVariables.get("MUL_2").getValue()))+""));
				break;
			case "READ":
				try {
					Scanner scan = new Scanner(System.in);
					globalVariables.put("READ_RESULT", new Type(VariableType.TEXT,scan.nextLine()));
					scan.close();
				} catch (Exception e) {
					globalVariables.put("READ_RESULT", new Type(VariableType.TEXT,""));
				}
				break;
			case "CLOSE":
				System.exit(0);
				break;
			case "RANDOM":
				globalVariables.put("RANDOM_RESULT", new Type(VariableType.NUMBER,""+(Double.parseDouble(globalVariables.get("RANDOM_1").getValue())+(int)(Math.random()*Double.parseDouble(globalVariables.get("RANDOM_2").getValue())))));
				break;
			case "TO_NUMBER":
				globalVariables.put("TO_NUMBER_RESULT", new Type(VariableType.NUMBER, ""+Double.parseDouble(globalVariables.get("TO_NUMBER_1").getValue())));
				break;
			case "TO_TEXT":
				globalVariables.put("TO_TEXT_RESULT", new Type(VariableType.TEXT, globalVariables.get(globalVariables.get("TO_TEXT_1").getValue()).getValue()));
				break;
			case "NEGATE":
				String ng = globalVariables.get("NEGATE_1").getValue().equals("true")?"false":"true";
				globalVariables.put("NEGATE_RESULT", new Type(VariableType.TEXT, ng));
			case "EQ":
				String eq = globalVariables.get("EQ_1").getValue().equals(globalVariables.get("EQ_2").getValue())?"true":"false";
				globalVariables.put("EQ_RESULT", new Type(VariableType.TEXT, eq));
				break;
			case "GT":
				String gt = globalVariables.get("GT_1").getValue().compareTo(globalVariables.get("GT_2").getValue())>0?"true":"false";
				globalVariables.put("GT_RESULT", new Type(VariableType.TEXT, gt));
				break;
			case "LT":
				String lt = globalVariables.get("LT_1").getValue().compareTo(globalVariables.get("LT_2").getValue())<0?"true":"false";
				globalVariables.put("GT_RESULT", new Type(VariableType.TEXT, lt));
				break;
		}
		
		
		if (nativeF.startsWith("IF_")) {
			if (globalVariables.get(nativeF+"_1").getValue().equals("true")) {
				String function = globalVariables.get(nativeF+"_2").getValue();
				stack.push(new Function(function, functions.get(function)));
			}
		}
		if (nativeF.startsWith("FOR_")) {
			int counter = 0;
			globalVariables.put(nativeF+"_COUNTER", new Type(VariableType.NUMBER, "0"));
			Stack<Function> fs = new Stack<Function>();
			while (counter<((Double)Double.parseDouble(globalVariables.get(nativeF+"_1").getValue())).intValue()) {
				String function = globalVariables.get(nativeF+"_2").getValue();
				List<String> f = new LinkedList<String>();
				f.add(nativeF+"_COUNTER="+counter);
				f.addAll(functions.get(function));
				fs.push(new Function(function, f));
				counter++;
			}
			while (!fs.isEmpty()) 
				stack.push(fs.pop());
		}
	}
}
