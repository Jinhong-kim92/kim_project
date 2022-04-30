package 샘플2방식;

//           클래스이름  implements 인터페이스이름
public class MessageBeanEn implements MessageBean{

	@Override   //"약속"의 의미 => ~해야 한다.
	public void sayHello(String name) {
		System.out.println("Hello, " + name + "!");		
	}
}
