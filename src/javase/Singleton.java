package javase;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class Singleton {
	private static Singleton instance;

	private Singleton() {
	}

	public static Singleton getInstance() {
		if (instance == null) {
			instance = new Singleton();
		}
		return instance;
	}
}
