package test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.Transaction;

public class JedisDemo {
	public static void main(String[] args) {
		Jedis jedis=getJedis();
		//jedis.set("country", "China");
		//System.out.println(jedis.get("country"));
		//jedis.del("country");
		jedisOnTransaction(jedis);
	}
	
	public static void fun1(){
		//加载属性文件
		//Locale locale=Locale.getDefault();
		ResourceBundle bundle=ResourceBundle.getBundle("redis");
		//创建配置对象
		JedisPoolConfig config=new JedisPoolConfig();
		String host=bundle.getString("redis.host");
		int port=Integer.parseInt(bundle.getString("redis.port"));
		int timeout=Integer.parseInt(bundle.getString("redis.timeout"));
		String password=bundle.getString("redis.password");
		config.setMaxActive(Integer.valueOf(bundle.getString("redis.pool.maxActive")));
		//创建Jedis连接池
		JedisPool pool=new JedisPool(config, host, port, timeout, password);
		//从连接池获取Jedis对象
		Jedis jedis=pool.getResource();
		//操作
		jedis.set("country", "China");
		String country=jedis.get("country");
		System.out.println(country);	
	}

	/**
	 * 从spring容器中获取Jedis对象
	 * @return
	 */
	public static Jedis getJedis(){
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		JedisPool pool=(JedisPool)context.getBean("jedisPool");
		Jedis jedis=pool.getResource();
		return jedis;
	}

	/**
	 * jedis操作List
	 * @param jedis
	 */
	public static void jedisOnList(Jedis jedis){
		jedis.lpush("userList", "James");
		jedis.lpush("userList", "Mary");
		jedis.lpush("userList", "Bob");
		jedis.lpush("userList", "Alice");
		//System.out.println(jedis.lpop("userList"));
		//System.out.println(jedis.lpop("userList"));
		List<String> userList=jedis.lrange("userList", 0, -1);
		System.out.println(userList);
		jedis.lset("userList", 1, "chenchuandong");
		System.out.println(jedis.lrange("userList", 0, -1));
		long size=jedis.llen("userList");
		System.out.println(size);
		String str=jedis.ltrim("userList", 1, 2);
		System.out.println(str);
		List<String> userList2=jedis.lrange("userList", 0, -1);
		System.out.println(userList2);
		jedis.del("userList");
	}

	/**
	 * jedis操作Set
	 * @param jedis
	 */
	public static void jedisOnSet(Jedis jedis){
		jedis.sadd("fruit", "apple","pear");
		jedis.sadd("fruit", "apple");
		Set<String> fruit=jedis.smembers("fruit");
		System.out.println(fruit);
		jedis.srem("fruit", "apple");
		long size=jedis.scard("fruit");
		Boolean isMember=jedis.sismember("fruit", "apple");
		System.out.println(isMember);
		jedis.sadd("food", "bread","milk");
		Set<String> fruitFood=jedis.sunion("fruit","food");
		System.out.println(fruitFood);
		jedis.del("fruit","food");
		System.out.println(jedis.smembers("fruit"));
	}

	/**
	 * jedis操作Sorted Set
	 * @param jedis
	 */
	public static void jedisOnSortedSet(Jedis jedis){
		jedis.zadd("user", 22, "Bob");
		jedis.zadd("user", 21, "Mary");
		Set<String> user=jedis.zrange("user", 0, -1);
		System.out.println(user);
		jedis.del("user");
	}
	
	/**
	 * jedis操作Hash
	 * @param jedis
	 */
	public static void jedisOnHash(Jedis jedis){
		Map<String, String> capital=new HashMap<String ,String>();
		capital.put("shanxi", "xi'an");
		capital.put("shandong", "jinan");
		jedis.hmset("capital", capital);
		List<String> cities=jedis.hmget("capital", "shanxi","shandong");
		System.out.println(cities);
		jedis.del("capital");		
	}

	/**
	 * jedis操作Transaction
	 * @param jedis
	 */
	public static void jedisOnTransaction(Jedis jedis){
		Transaction tx=jedis.multi();
		for(int i=0;i<10;i++){
			tx.set("key"+i, "value"+i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		List<Object> results=tx.exec();
		System.out.println(results);
		//Set<String> keys=jedis.keys("*");
		//System.out.println(keys);
	}
}







