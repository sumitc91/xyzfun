package com.funoverflowwebservices.common.core.exception;

public class FunOverflowBaseException extends Exception {

	private static final long serialVersionUID = -2755002272681679155L;

	private final String errorCode ;

	private final boolean toBeMailed;

	public boolean isToBeMailed() {
		return toBeMailed;
	}

	public FunOverflowBaseException() {		
		super();
		this.errorCode = "";
		this.toBeMailed = false;
	}

	public FunOverflowBaseException(String message, String errorCode, Throwable cause, boolean tobeMailed) {
		super(message, cause);
		this.errorCode = errorCode;
		this.toBeMailed = tobeMailed;
	}

	public String getErrorCode() {
		return errorCode;
	}

	/*
	 * @javadoc This method will give the customized details about the exception isSecure parameter determines whether
	 * the stack has to be trimmed.
	 */
	public String getExceptionStackTrace(Throwable cause, boolean isSecure) {
		StringBuilder stackTrace = new StringBuilder();
		StackTraceElement[] stackTraceElement = cause.getStackTrace();
		int stackLimit;
		if (isSecure)
			stackLimit = 2;
		else
			stackLimit = stackTraceElement.length;
		for (int i = 0; i < stackLimit; i++) {
			stackTrace.append("The exception is caused by class :").append(stackTraceElement[i].getClassName());
			stackTrace.append("The File Name is :").append(stackTraceElement[i].getFileName());
			stackTrace.append("The Line number is :").append(stackTraceElement[i].getLineNumber());
			stackTrace.append("The method is :").append(stackTraceElement[i].getMethodName());
		}
		return stackTrace.toString();
	}


}