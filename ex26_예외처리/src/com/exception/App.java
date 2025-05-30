package com.exception;

import com.exception.practice.A_TryCatch;
import com.exception.practice.B_UnCheckedException;
import com.exception.practice.UserException;

public class App {
	public static void main(String[] args) throws UserException {
		A_TryCatch a = new A_TryCatch();
		//a.method1();
		//a.method3(null);
		//a.method4();
		//int age = a.getInt("나이를 입력 해주세요");
		//a.method5();
		
		B_UnCheckedException b = new B_UnCheckedException();
		//b.method1(0);
		b.method2();
	}
}
