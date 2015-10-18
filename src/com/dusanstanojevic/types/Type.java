package com.dusanstanojevic.types;

public class Type {
	private VariableType type;
	private String value;
	
	public Type(VariableType type, String value) {
		super();
		this.type = type;
		this.value = value;
	}
	
	public VariableType getType() {
		return type;
	}
	public String getValue() {
		return value;
	}
	public void setType(VariableType type) {
		this.type = type;
	}
	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Type other = (Type) obj;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}
}
