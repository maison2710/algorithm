package javase;

import java.util.ArrayList;
import java.util.List;

public class Student {
	private String name;
	private Integer age;

	public Student(String name, Integer age){
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}


	public static void main(String[] args) {
		Student test = new Student("a", 1);
		updateStudent(test);
		System.out.println(test.age);

		Student test1 = test;
		test1.setName("b");
		System.out.println(test.getName());

		int a = 3;
		updateInt(a);
		System.out.println(a);

		int[] array = {2,7};
		updateArray(array);
		System.out.println(array[0]);

		List list = new ArrayList();
		updateList(list);
		System.out.println(list);
	}

	private static void updateList(List list) {
		list.add(1);
	}

	private static void updateArray(int[] array) {
		array[0] = 1;
	}

	private static void updateInt(int a) {
		a = 4;
	}

	private static void updateStudent(Student test) {
		test.setAge(2);
	}
}
