package com.maven.ex;

import com.maven.ex.send.EmailSender;
import com.maven.ex.service.NotificationService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	NotificationService service = new NotificationService(new EmailSender());
    	
        service.send("momo.class5@gmail.com", "메세지 전송 서비스");
    }
}
