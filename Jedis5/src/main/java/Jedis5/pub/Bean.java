package Jedis5.pub;

import java.io.Serializable;

public class Bean implements Serializable {// 需要实现序列化接口
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
