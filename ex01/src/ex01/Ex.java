package ex01;

// 한줄주석
/*
 * 여러줄 주석 */
/**
 * 프로그램 주석
 * JavaDoc를 만들때 사용되는 주석
 */
/*
 * 네이밍규칙(카멜표기법)
 * 1. 클래스명
 *  - 대문자로 시작, 여러 개의 단어가 있을 때는 단어 앞자리마다 대문자로 표기한다. (낙타 표기법 / 관습적으로 사용)
 * 2. 메서드명
 *   - 소문자로 시작, 여러 개의 단어가 있을 때는 단어 앞자리마다 대문자로 표기한다. (낙타 표기법 / 관습적으로 사용)
 * */
public class Ex {
	
	/*
	 * 프로그램의 실행을 담당(main을 입력하고 ctrl+space를 누르면 자동완성을 이용해서 만들수 있다
	 * */
	public static void main(String[] args) {
		// 문자는 쌍따옴표 안에 입력
		System.out.println("hello!");
		// 숫자 출력 따옴표 없이 입력
		System.out.println(111111);
		System.out.println(3.14);
		// 사칙연산
		System.out.println(3*1);
		System.out.println(3/1);
		// 문자와 문자를 연결하기
		// + : 문자와 문자, 문자와 숫자를 연결
		System.out.println("당신의"+" BMI는 "+ 20.5 +" 입니다.");
		// 문자출력 : 하나의 문자를 입력할 수 있어요!
		System.out.println('a');
		// 숫자로 연산이 가능하다
		System.out.println('a'+ 1);
		
		
		
		
		
	}
}
