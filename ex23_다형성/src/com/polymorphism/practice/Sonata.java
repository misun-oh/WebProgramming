package com.polymorphism.practice;

public class Sonata extends Car {
	public int price = 100000;
	@Override
	public String toString() {
		return "Sonata";
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public void drive() {
		// TODO Auto-generated method stub
		
	}
}
