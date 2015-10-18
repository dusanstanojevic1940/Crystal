package com.dusanstanojevic.lang;

public class LanguageException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public LanguageException() {
		super();
	}

	public LanguageException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public LanguageException(String message, Throwable cause) {
		super(message, cause);
	}

	public LanguageException(String message) {
		super(message);
	}

	public LanguageException(Throwable cause) {
		super(cause);
	}
	
}
