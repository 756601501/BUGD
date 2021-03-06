package Jedis5.pub;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPubSub;

public class TestSub {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:/applicationContext.xml");
		JedisPool pool = (JedisPool) context.getBean("jedisPool");
		Jedis jedis = pool.getResource();
		JedisPubSub jedisPubSub = new JedisPubSub() {
			@Override
			public void onUnsubscribe(String channel, int subscribedChannels) {
			}

			@Override
			public void onSubscribe(String channel, int subscribedChannels) {
			}

			@Override
			public void onPUnsubscribe(String pattern, int subscribedChannels) {
			}

			@Override
			public void onPSubscribe(String pattern, int subscribedChannels) {
			}

			@Override
			public void onPMessage(String pattern, String channel,
					String message) {
			}

			@Override
			public void onMessage(String channel, String message) {
				try {
					ByteArrayInputStream bis = new ByteArrayInputStream(
							message.getBytes("ISO-8859-1"));// 此处指定字符集将字符串编码成字节数组，此处的字符集需要与发布时的字符集保持一致
					ObjectInputStream ois = new ObjectInputStream(bis);
					Bean bean = (Bean) ois.readObject();
					System.out.println(bean.getName());
				} catch (Exception e) {
					e.printStackTrace();
				} finally {

				}
			}
		};
		jedis.subscribe(jedisPubSub, "foo");
	}
}
