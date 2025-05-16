package com.control.practice;

import java.util.Scanner;

// 클래스의 선언부
public class ControlEx {
	// 필드
	// 기본타입
	// 참조타입의 경우 클래스명을 타입으로 사용할수 있다
	Scanner scanner = new Scanner(System.in);
	// 생성자 - 기본생성자가 컴파일러에 의해 생성된다
	// 메서드

	// method1(int, int) : void
	// 메서드 선언부
	// 접근제한자 반환타입 메서드명(매개변수타입 매개변수명,...) {}
	public void method1() {
		// 아래 예시와 같이 메뉴를 출력하고 메뉴번호를 누르면 "OO메뉴입니다"를,
		// 종료 번호를 누르면 "프로그램이종료됩니다."를 출력
		// 세로선택 - alt + shift + a
		System.out.println("1. 입력");
		System.out.println("2. 수정");
		System.out.println("3. 조회");
		System.out.println("4. 삭제");
		System.out.println("9. 종료");
		System.out.println("메뉴번호를입력하세요:");

		int menu = scanner.nextInt();

		if (menu == 1) {
			System.out.println("입력 메뉴 입니다.");
		} else if (menu == 2) {
			System.out.println("수정 메뉴 입니다.");
		} else if (menu == 3) {
			System.out.println("조회 메뉴 입니다.");
		} else if (menu == 4) {
			System.out.println("삭제 메뉴 입니다.");
		} else if (menu == 9) {
			System.out.println("종료 메뉴 입니다.");
		}
	}

	public void method2() {
		// 키보드로 정수를 입력 받고
		// 입력값이 양수 이면서 짝수 일때만 "짝수"를 출력하고
		// 짝수가 아니면 "홀수"를 출력
		// 양수가 아니면 "양수만 입력해주세요."를 출력
		System.out.println("정수를 입력 : ");
		int num = scanner.nextInt();

		// 조건을 연결
		// && : 그리고, || : 또는
		if (num > 0 && num % 2 == 0) {
			System.out.println("짝수");
		} else {
			System.out.println("홀수");
		}

	}

	public void method3() {
		/*
		 * Ctrl + Shift + F (자동 포맷)
		 * 
		 * 국어, 영어, 수학 세과목의 점수를 키보드로 입력 받고 합계와 평균을 계산 하고 합계와 평균을 이용하여 합격/불합격 처리 하는 기능을 구현
		 * (합격조건: 세과목의 점수가 각각40점 이상 이면서 평균이 60점 이상 일경우) 합격 했을 경우 과목별 점수와 합계, 평균,
		 * "축하합니다, 합격입니다!"를 출력하고 불합격인 경우에는 "불합격입니다."를 출력
		 */
		// 변수 선언및 초기화
		// 지역변수 : 초기화 되지 않은 변수는 사용할 수 없으므로 초기화도 함께 진행
		// 전역변수 : 생성자에 의해서 자동으로 초기화 초기값이 지정됨
		int korScore = 0, mathScore = 0, engScore = 0;
		int sum = 0;
		double avg = 0;

		System.out.println("국어점수 : ");
		korScore = scanner.nextInt();
		System.out.println("수학점수 : ");
		mathScore = scanner.nextInt();
		System.out.println("영어점수 : ");
		engScore = scanner.nextInt();

		sum = korScore + mathScore + engScore;
		// 정수와 정수의 연산은 정수가 반환 되므로
		// 형변환 또는 실수값을 입력 하여 정수와 실수의 계산 되도록 해야 합니다.
		avg = (double) sum / 3.0;

		System.out.println("합계 : " + sum);
		// 평균은 실수 타입으로 소수점 2째자리까지 출력
		System.out.println("평균 : " + avg);
		// %f : 실수
		// %.2f : 소수점 2째짜리까지 출력
		// \n : 줄바꿈
		System.out.printf("평균 : %.2f\n", avg);

		if (korScore >= 40 && engScore >= 40 && mathScore >= 40 && avg >= 60) {
			System.out.println("축하 드립니다.\n합격 입니다.");

		} else {
			System.out.println("불합격 입니다.");
		}

	}

	public void method4() {
		System.out.println("1. 입력");
		System.out.println("2. 수정");
		System.out.println("3. 조회");
		System.out.println("4. 삭제");
		System.out.println("9. 종료");
		System.out.println("메뉴번호를입력하세요:");

		int menu = scanner.nextInt();

		switch (menu) {
		case 1:
			System.out.println("입력을 선택 하셨습니다.");
			break;
		case 2:
			System.out.println("수정을 선택 하셨습니다.");
			break;
		case 3:
			System.out.println("조회를 선택 하셨습니다.");
			break;
		case 4:
			System.out.println("삭제를 선택 하셨습니다.");
			break;
		case 9:
			System.out.println("종료을 선택 하셨습니다.");
			break;
		default:
			System.out.println("메뉴 번호를 확인후 이용 해주세요");

		}

	}

	public void method5() {
		/*
		 * 아이디, 비밀번호를 정해두고 로그인 기능을 구현 로그인 성공시 "로그인 성공", 아이디가 불일치시 "아이디가 틀렸습니다.", 비밀번호가
		 * 불일치시 "비밀번호가 틀렸습니다."를 출력 (id는 momo, 비밀번호는 1234입니다.)
		 */

		// ==
		// 문자열의 비교(p91)
		String str = "사과";

		// 문자열의 비교는 equal메서드를 이용합니다.
		// 문자열.equals(비교 문자열) : boolean
		if (str.equals("사과")) {

		}

		// 무한반복
		while (true) {
			System.out.println("id : ");
			String id = scanner.next();

			// 사용자가 입력한 ID가 exit라면 반복문을 탈출 하는 코드를 작성해봅시다
			if ("exit".equalsIgnoreCase(id)) {
				// 반복문 탈출
				break;
			}
			System.out.println("pw : ");
			String pw = scanner.next();

			// null
			// if(id.equals("momo")) {
			if ("momo".equals(id) && "1234".equals(pw)) {
				System.out.println("로그인 성공");
			} else if (!"momo".equals(id)) {
				System.out.println("아이디가 틀렸습니다.");
			} else if (!"1234".equals(pw)) {
				System.out.println("pw가 틀렸습니다.");
			}

		}

	}

	public void method6() {
		/*
		 * 사용자에게 관리자, 회원, 비회원중 하나를 입력받아 각 등급이 행할수 있는 권한을 출력 관리자 : 회원관리, 게시글관리,
		 * 게시글작성,게시글조회, 댓글작성 회원 : 게시글작성, 게시글조회, 댓글작성 비회원 : 게시글 조회 (단, 잘못 입력 하였을 경우
		 * "잘못입력했습니다."라는 출력문이 출력)
		 */

		// 1. 반복문을 사용해서 계속 실행 되도록 해볼까요 - while
		// 2. 관리자, 회원, 비회원이 아닌경우 반복문을 탈출 해볼까요 - break
		// 3. 무한반복 -> 10번 반복 -> for
		int i = 0;
		while (true) {
			// i를 0으로 초기화 하고 i가 10보다 작을때까지 1씩 증가하면서 코드블럭을 반복적으로 실행
			// for(int i=0;i<10;i++) {
			System.out.println("등급 : ");
			String type = scanner.next();
			// null. 오류가 발생

			if (type.equals("관리자")) {
				System.out.println("회원관리, 게시글관리, 게시글작성,게시글조회, 댓글작성 ");
			} else if ("회원".equals(type)) {
				System.out.println("게시글작성, 게시글조회, 댓글작성  ");
			} else if ("비회원".equals(type)) {
				System.out.println("게시글 조회 ");
			} else {
				System.out.println("잘못입력했습니다 ");
				break;
			}
			if (i > 10)
				break;
			i++;

		}

	}

	public void method7() {

		// 반복
		// 계속 하시겠습니까?(Y)
		// Y,y를 입력 받으면 반복 아니면 종료
		while (true) {

			/*
			 * 키, 몸무게를 double로입력받고BMI지수를계산하여계산결과에따라 저체중/ 정상체중/ 과체중/ 비만을출력하세요. BMI =
			 * 몸무게/(키(m) * 키(m)) BMI가18.5미만일경우저체중/ 18.5이상23미만일경우정상체중 BMI가23이상25미만일경우과체중/
			 * 25이상30미만일경우비만 BMI가30이상일경우고도비만
			 */
			// 1. 키, 몸무계 입력 받기
			double height;
			while(true) {
				System.out.println("키(m) : ");
				height = scanner.nextDouble();
				// 키 10보다 작은 값을 입력 할때까지 
				if(height>10) {
					// 다시 입력
					System.out.println("키는 m 단위로 입력 해주세요");
				} else {
					break;
				}
			}
			
			
			
			System.out.println("몸무계(kg) : ");
			double weight = scanner.nextDouble();

			double bmi = weight / (height * height);
			System.out.printf("당신의 bmi는 %s 입니다.", bmi);

			if (bmi < 18.5) {
				System.out.println("저체중");
			} else if (bmi < 23) {
				System.out.println("정상체중");
			} else if (bmi < 25) {
				System.out.println("과체중");
			} else if (bmi < 30) {
				System.out.println("비만");
			} else {
				System.out.println("고도비만");
			}

			System.out.println("계속 하시겠습니까?");
			String input = scanner.next();
			if (!"y".equalsIgnoreCase(input)) {
				System.out.println("종료 합니다.");
				break;
			}
		}

	}

	/*
	 * method8() : void 메뉴화면을 구현
	 * 
	 * 실행할기능을선택하세요. 
	 * 1. 메뉴출력 
	 * 2. 짝수/홀수 
	 * 3. 합격/불합격 
	 * 4. 합격/불합격 switch 
	 * 5. 로그인 
	 * 6. 권한 확인 
	 * 7. BMI
	 */
	public void method8() {
		
		// i = 0,1,2,3,4
		for(int i=0;i<5;i++) {
			
			// 5번 반복
			System.out.println("1. 메뉴출력            ");
			System.out.println("2. 짝수/홀수           ");
			System.out.println("3. 합격/불합격          ");
			System.out.println("4. 합격/불합격 switch   ");
			System.out.println("5. 로그인             ");
			System.out.println("6. 권한 확인           ");
			System.out.println("7. BMI             ");
			System.out.println("메뉴 번호 : ");
			int menu = scanner.nextInt();
			
			switch (menu) {
			// menu의 값이 1이면
			case 1:	method1(); break;
			// menu의 값이 2이면
			case 2: method2(); break;
			case 3: method3(); break;
			case 4: method4(); break;
			case 5: method5(); break;
			case 6: method6(); break;
			case 7: method7(); break;
			default: System.out.println("메뉴 번호를 확인 하세요!");
			}
		}
		
		
	}
}
