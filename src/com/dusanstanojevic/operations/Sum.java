package com.dusanstanojevic.operations;

import com.dusanstanojevic.types.Type;
import com.dusanstanojevic.types.VariableType;

public class Sum {
	public static Type execute(Type a, Type b) {
		if (a.getType()==VariableType.TEXT
				|| b.getType()==VariableType.TEXT)
			return new Type(VariableType.TEXT, a.getValue()+b.getValue());
		double aNum = Double.parseDouble(a.getValue());
		double bNum = Double.parseDouble(b.getValue());
		return new Type(VariableType.NUMBER, (aNum+bNum)+"");
	}
}
