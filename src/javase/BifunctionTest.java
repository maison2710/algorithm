package javase;

import java.util.function.BiFunction;

public class BifunctionTest {
	public static void main(String[] args) {
		BiFunction<String, String, String> bi = (x, y) -> {
			return x + y;
		};

		System.out.println(bi.apply("java2s.com", " tutorial"));
		BifunctionTest test = new BifunctionTest();
		getQualifiedName(test);
	}

	private static void getQualifiedName(BifunctionTest test) {
		System.out.println(test.getClass());
	}
}
