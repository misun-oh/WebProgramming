package com.chap1.generic;

public class Container <T>{
	private T content;

	public T get() {
		return content;
	}

	public void set(T content) {
		this.content = content;
	}
	
}
