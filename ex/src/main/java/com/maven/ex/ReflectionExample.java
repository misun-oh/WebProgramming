package com.maven.ex;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionExample {
    public static void main(String[] args) throws Exception {
        // 1. 클래스 정보 획득 (클래스 이름으로 클래스 로딩)
        Class<?> clazz = Class.forName("com.maven.ex.User");

        // 2. 기본 생성자를 통해 객체 생성
        Object obj = clazz.getDeclaredConstructor().newInstance();

        // 3. private 필드 "name" 접근
        Field nameField = clazz.getDeclaredField("name");

        // 4. 접근 제한 해제 (private 필드도 접근 가능하게 함)
        nameField.setAccessible(true);

        // 5. 필드 값 변경 ("홍길동" → "이순신")
        // obj 객체의 해당 필드에 value를 설정
        nameField.set(obj, "이순신");

        // 6. "sayHello" 메서드 가져와서 실행
        Method method = clazz.getDeclaredMethod("sayHello");
        method.invoke(obj);

        // 7. 변경된 필드 값 출력
        System.out.println("이름: " + nameField.get(obj));
    }
}

class User {
    private String name = "홍길동";
    public void sayHello() {
        System.out.println("안녕하세요!");
    }
}

