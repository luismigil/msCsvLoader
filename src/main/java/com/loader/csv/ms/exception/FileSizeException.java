package com.loader.csv.ms.exception;

public class FileSizeException extends Exception{
	public static final int MAX_FILE_SIZE = 500000;
	public FileSizeException(String errorMessage) {
		super(errorMessage);
	}

}
