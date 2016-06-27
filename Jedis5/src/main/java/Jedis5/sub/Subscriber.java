package Jedis5.sub;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import redis.clients.jedis.JedisPubSub;

public class Subscriber extends JedisPubSub {

	private static Logger logger = LoggerFactory.getLogger(Subscriber.class);

	@Override
	public void onMessage(String channel, String message) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		logger.info("asdasd:" + message);
		logger.info("Message received. Channel: {}, Msg: {}", channel, message);
	}

	@Override
	public void onPMessage(String pattern, String channel, String message) {

	}

	@Override
	public void onSubscribe(String channel, int subscribedChannels) {

	}

	@Override
	public void onUnsubscribe(String channel, int subscribedChannels) {

	}

	@Override
	public void onPUnsubscribe(String pattern, int subscribedChannels) {

	}

	@Override
	public void onPSubscribe(String pattern, int subscribedChannels) {

	}

}
