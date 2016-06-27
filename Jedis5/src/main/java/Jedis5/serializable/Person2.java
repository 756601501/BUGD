package Jedis5.serializable;

import java.io.Serializable;

public class Person2 implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1;
	private int age;
	private String name;
	private String sex;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	

}
