package com.practice.model.vo;

// 하나의 추상메서드라도 존재하면 무조건 추상 클래스가 되어야 한다
public abstract class Animal {
	private String name;
	private String kinds;
	
	// 반환타입이 없고, 클래스명과 동일한 이름
	protected Animal() {
		
	}
	protected Animal(String name, String kind) {
		this.name = name;
		this.kinds = kind;
	}
	
	@Override
	public String toString() { 
		return "name : " + name + ", kinds : " + kinds;
	}
	
	// 코드블럭이 없다!
	public abstract void speak();
	
	
}
