package com.array;

import java.util.Arrays;

import com.array.practice.ArrayEx;
import com.array.practice.ArrayEx1;

public class App {
	public static void main(String[] args) {
		ArrayEx ae = new ArrayEx();
		//ae.method1();
		//ae.method2();
		//ae.method3();
		//ae.method4();
		//ae.method5();
		//ae.method5_1();
		
		ArrayEx1 ae1 = new ArrayEx1();
		//ae1.method4();
		//ae1.method5();
		//ae1.method6();
		//ae1.method7();
		//ae1.method9();
		int[][] lottos = ae1.method10();
		System.out.println("로또번호 : ");
		for(int i=0;i<lottos.length;i++) {
			
			System.out.println(Arrays.toString(lottos[i]));
		}
		
		
		
	}
}
