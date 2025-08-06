package dev.spring_prj.send;



public class SmsSender implements Sender{
	@Override
	public void send(String to, String message) {
		System.out.println("sms전송");
		System.out.println("to : " + to);
		System.out.println("msg : " + message);	
	}
}
