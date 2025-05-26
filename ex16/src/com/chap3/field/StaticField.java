package com.chap3.field;

public class StaticField {
	
	// 정적멤버 - 정적 필드(클래스 변수), 정적 메서드
	// static 키워드는 객체로 생성 하지 않아도 클래스명을 통해서 접근 할 수 있다
	// 객체에 소속된 멤버가 아니라 클래스에 소속된 멤버이다
	// static 메모리 영역에 할당 된다

	// 정적 필드
	public static String pubSta = "public static";
	private static String priSta = "private static";
	
	// 인스턴스 필드
	public String pub = "public";
	
	// static 필드에 대한 getter/setter 메서드 또한 static 키워드를 붙여서 만들어야 한다
	public static String getPubSta() {
		return pubSta;
	}
	// 인스턴스 멤버는 new 연산자를 만나서 메모리에 올라간 이후 사용 가능하다
	// 정적 멤버는 생성하지 않고 사용 할 수 있다
	// 정적 메서드에서 인스턴스 필드를 초기화
	// 정적 메서드에서 인스턴스 필드에 접근 하기 위해서는 생성후 접근 해야한다
	// 같은 클래스 안에 있더라도 바로 접근이 불가능 하다
	public static void setPubSta(String pubSta) {
		
		// 생성후 사용이 가능
		//pub = pubSta;
		// 객체를 생성하지 않고 클래스 명으로 접근
		// 객체를 생성 하지 않아서 this는 존재 하지 않는다
		StaticField.pubSta = pubSta;
	}
	
	
	public static void main(String[] args) {
		// 인스턴스 필드를 생성하지 않고 사용할 수 없다
		//pub
		
		// p247 - 정적멤버
		// 객체마다 가지고 있을 필요성이 없는 공용적인 필드
		// 인스턴스 멤버에 접근 하기 위해서는 객체를 생성후 접근이 가능 하다
		StaticField sf = new StaticField();
		StaticField sf1 = new StaticField();
		sf.pub = "pub"; 
		sf1.pub = "pub1";
		
		// System.out.println(Math.PI);
		// 정적필드에 접근하기 위해서는 클래스이름.필드명 으로 접근 해서 값을 확인 
		System.out.println(StaticField.priSta);
		System.out.println("==================");
		// 인스턴스 멤버 생성후 정적 멤버에 접근
		System.out.println(sf.pubSta); 	// 정적 멤버 (기울임꼴)
		System.out.println(sf.pub);		// 인스턴스 멤버
		System.out.println("==================");
		System.out.println(sf1.pubSta);	// 정적 멤버
		System.out.println(sf1.pub);	// 인스턴스 멤버
		System.out.println("==================");
		
		sf.setPubSta("변경"); // 정적멤버의 값을 변경
		System.out.println(sf1.pubSta);
		System.out.println(sf.pubSta);
		
		
	}
}
