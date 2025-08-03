package com.maven.ex;

import com.maven.ex.send.SmsSender;
import com.maven.ex.service.NotificationService_setter;

/**
 * Hello world!
 *
 */
public class App_setter 
{
    public static void main( String[] args )
    {
    	NotificationService_setter service = new NotificationService_setter();
    	service.setSender(new SmsSender());
        service.send("momo.class5@gmail.com", "메세지 전송 서비스");
    }
}
