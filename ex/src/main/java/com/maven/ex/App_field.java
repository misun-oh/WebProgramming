package com.maven.ex;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

import com.maven.ex.send.EmailSender;
import com.maven.ex.send.Sender;
import com.maven.ex.service.NotificationService_field;

/**
 * Hello world!
 *
 */
public class App_field 
{
    public static void main( String[] args ) throws Exception 
    {
    	
    	// 1. 클래스 정보를 메모리에 로드 (객체를 생성하지는 않음)
		// 객체가 존재하는지 확인하는 용도로 사용했었음
		// ? : 어떤타입이든 올수있다는 의미
		Class<?> clazz = Class.forName("com.maven.ex.service.NotificationService_field");
		
		// 2. 기본생성자를 이용해 객체를 생성  
		Constructor<?> constructor = clazz.getDeclaredConstructor();
		NotificationService_field service = (NotificationService_field)constructor.newInstance(args);
		
		// 3. 필드명으로 리플렉션 필드에 접근 
		Field field = clazz.getDeclaredField("sender");
		field.setAccessible(true);	// private 접근제한 풀기
		field.set(service, new EmailSender());	// 리플렉션의 DI(의존성 주입)DI
		
        service.send("momo.class5@gmail.com", "메세지 전송 서비스");

    }
}