package com._interface.practice;

public class Tv extends Product{
	private int inch; // 인치

	public Tv(String brand, String pCode, String name, int price, int inch) {
		super(brand, pCode, name, price);
		this.inch = inch;
	}

	public int getInch() {
		return inch;
	}

	public void setInch(int inch) {
		this.inch = inch;
	}

	@Override
	public String information() {
		// TODO Auto-generated method stub
		return super.information() + ", " + inch;
	}
	

}
