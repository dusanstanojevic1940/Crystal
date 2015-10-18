package com.dusanstanojevic.lang;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import com.dusanstanojevic.types.Type;

public class Interpreter {
	private List<String> code;
	private Map<String, Type> variables;
	private Map<String, List<String>> functions;
	private Stack<Function> stack;
	
	public Interpreter(String code) {
		this.code = Arrays.asList(code.split("\n"));
		variables = new HashMap<String, Type>();
		functions = new HashMap<String, List<String>>();
		stack = new Stack<Function>();
		parse();
	}
	
	Map<String, List<String>> getFunctions() {
		return functions;
	}
	
	Stack<Function> getStack() {
		return stack;
	}
	Map<String, Type> getVariables() {
		return variables;
	}

	private void parse() {
		for (String s : code) {
			if (!s.startsWith("\t") && !s.replaceAll(" ", "").equals(""))
				functions.put(s, new LinkedList<String>());
		}
		String functionName = null;
		for (String s : code) {
			if (!s.startsWith("\t") && !s.replaceAll(" ", "").equals("")) {
				functionName = s;
			} else if (s.startsWith("\t") && functionName!=null && !s.replaceAll(" ", "").replaceAll("\t", "").equals("")) {
				functions.get(functionName).add(s.replaceFirst("\t", ""));
			}
		}
	}
	
	public List<String> getCode() {
		return code;
	}

	public boolean hasMoreToExecute() {
		return !stack.isEmpty();
	}
	
	public void begin() {
		if (functions.containsKey("main"))
			stack.push(new Function("main", functions.get("main")));
		else
			throw new LanguageException("No main function found");
	}
	
	public void executeNextLine() {
		if (!stack.isEmpty()) {
			Function ex = stack.peek();
			if (ex.isDone()) {
				stack.pop();
			} else {
				ex.execute(stack, functions, variables);
			}
		}
	}
}
