package com.dusanstanojevic.lang;

import java.util.List;
import java.util.Map;
import java.util.Stack;

import com.dusanstanojevic.operations.NativeOperationUtil;
import com.dusanstanojevic.types.Type;
import com.dusanstanojevic.types.VariableType;

public class Function {
	private String name;
	private List<String> lines;
	private int currentLine = 0;
	
	public Function(String name, List<String> lines) {
		this.name = name;
		this.lines = lines;
	}

	public boolean isDone() {
		return currentLine==lines.size();
	}
	
	public void execute(Stack<Function> stack, Map<String, List<String>> functions, Map<String, Type> globalVariables) {
		String line = lines.get(currentLine);
		if (line.contains("=")) {
			if (globalVariables.containsKey(line.split("=")[1]))
				globalVariables.put(line.split("=")[0], globalVariables.get(line.split("=")[1]));
			else
				globalVariables.put(line.split("=")[0], parse(line.split("=")[1], functions, globalVariables));
		} else {
			for (Map.Entry<String, List<String>> f : functions.entrySet()) {
				if (line.startsWith(f.getKey())) {
					stack.push(new Function(f.getKey(), f.getValue()));
					currentLine++;
					return;
				}
			}
			for (String nativeF : NativeOperationUtil.NATIVE_FUNCTIONS) {
				if (line.startsWith(nativeF))
					NativeOperationUtil.execute(stack, line, functions, globalVariables);
			}
			
		}
		currentLine++;
	}
	
	private Type parse(String line, Map<String, List<String>> functions, Map<String, Type> globalVariables) {
		if (line.startsWith("'"))
			return new Type(VariableType.TEXT, line.substring(1, line.length()-1));
		return new Type(VariableType.NUMBER, Double.parseDouble(line)+"");
	}
	
	List<String> getLines() {
		return lines;
	}

	public String getName() {
		return name;
	}
}
