package ���ٽĽǽ�����;

import java.util.function.Consumer;

public class ConsumerEx {

	public static void main(String[] args) {
		Consumer<String> comsumer = t -> System.out.print(t + "8");  //Java8 ���
		comsumer.accept("Java");
	}
}
