package com.exception.practice;

public class UserException extends Exception{
	public UserException(){
		super("사용자 정의 예외");
	}
	
	public UserException(String msg){
		super(msg);
	}
}
