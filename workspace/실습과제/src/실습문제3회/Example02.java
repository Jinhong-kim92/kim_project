package �ǽ�����3ȸ;

class Person {
	//��������� ������ private���� ����
	private String name;
	private int age;
	
	//������� �ϳ��� getter, setter �޼ҵ带 �ѽֽ� �����Ѵ�.
	/*
	 * setter �޼ҵ� ���� ��Ģ => �ݵ�� �Ű������� �޾ƾ��ϰ�, return Ÿ���� void�̴�.
	 * getter �޼ҵ� ���� ��Ģ => �Ű������� ���� �ʰ�, { } ��� �ȿ� �ݵ�� return�� �־�� �Ѵ�.
	 */
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	
	public int getAge() { return age; }
	public void setAge(int age) { this.age = age; }	
}

public class Example02 {
	public static void main(String[] args) {
		Person aPerson = new Person();
		
		//aPerson.name = "ȫ�浿";
		//aPerson.age = 28;
		
		aPerson.setName("ȫ�浿");
		aPerson.setAge(28);
		
		//�̸��� ���̸� ����ϼ���
		System.out.println("�̸�: " + aPerson.getName());
		System.out.println("����: "  + aPerson.getAge());
	}
}




