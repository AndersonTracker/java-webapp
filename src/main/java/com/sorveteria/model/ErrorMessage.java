package com.sorveteria.model;

public class ErrorMessage {
    private String errorMessage;
    private int errorCode;

    public ErrorMessage(String message, int i) {
	}

	public String getErrorMessage() {
        return this.errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

}
