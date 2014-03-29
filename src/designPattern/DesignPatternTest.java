package designPattern;

import org.junit.Test;

public class DesignPatternTest {

	@Test
	public void testBuilderPattern(){
		BuilderCake cake = new BuilderCake.Builder().butter(1).eggs(4).milk(10).build();
		System.out.println(cake.toString());
	}
}
