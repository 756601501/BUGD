package Jedis5.Jedis5;

public class Test {
	public static void main(String[] args) {
		A a = new B();
		a.a1();
		a.a2();
		
		A b = (A) new B();
		b.a1();
		b.a2();
	}
}
