package »ùÇÃ2¹æ½Ä;

public class HelloApp {

	public static void main(String[] args) {
		MessageBean bean;
		
		bean = new MessageBeanEn();
		bean.sayHello("Kim sun dong");
		
		bean = new MessageBeanKr();
		bean.sayHello("±è¼±µ¿");
	}
}
