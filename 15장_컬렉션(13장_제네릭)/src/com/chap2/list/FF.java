package com.chap2.list;

import java.util.function.Function;

public class FF implements Function<Integer, Integer> {

	@Override
	public Integer apply(Integer t) {
		return t+10;
		
	}

}
