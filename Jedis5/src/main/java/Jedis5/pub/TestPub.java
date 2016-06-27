package Jedis5.pub;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class TestPub {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:/applicationContext.xml");
		JedisPool pool = (JedisPool) context.getBean("jedisPool");
		Jedis jedis = pool.getResource();
		try {
			Bean bean = new Bean();
			bean.setName("test2");
			// 使用ObjectOutputStream和ByteArrayOutputStream将对象转换成字节流
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(bean);
			String msg1 = baos.toString("ISO-8859-1");// 指定字符集将字节流解码成字符串，否则在订阅时，转换会有问题。
			// msg1 = URLEncoder.encode(msg1, "UTF-8");
			jedis.publish("foo", msg1);
		} catch (Exception e) {

		}
	}
}
