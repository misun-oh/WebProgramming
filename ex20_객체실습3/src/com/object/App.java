package com.object;

import com.object.practice.NonStaticSample;
import com.object.practice.StaticSample;

public class App {

	public static void main(String[] args) {
		NonStaticSample nss = new NonStaticSample();
		nss.printLottoNumbers();
		nss.outputChar(5, 'a');
		System.out.println(nss.mySubstring("apple", 2, 4));
		
		StaticSample.setValue("Java");
		System.out.println("value : " + StaticSample.getValue());
		
		StaticSample.toUpper();
		System.out.println("대문자로 : " + StaticSample.getValue());
		
		System.out.println("길이 : " + StaticSample.valueLength());
		
		System.out.println(StaticSample.valueConcat("PRPGRAMMING"));
		
		System.out.println("value : " + StaticSample.getValue());

	}

}
