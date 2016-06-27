package Jedis5.Jedis5;

import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.fastjson.JSON;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Response;
import redis.clients.jedis.Transaction;
import redis.clients.jedis.Tuple;
import redis.clients.util.RedisInputStream;
import redis.clients.util.RedisOutputStream;

public class Main {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:/applicationContext.xml");
		JedisPool pool = (JedisPool) context.getBean("jedisPool");
		Jedis jedis = pool.getResource();
//		jedis.set("123", "dw");
//		System.out.println(jedis.get("post:createTime:group:stat_0_1:6"));
//		System.out.println(jedis.keys("post:*"));
//		System.out.println(jedis.keys("post:*").size());
//		System.out.println(jedis.zinterstore("post:createTime", sets));
//		System.out.println(jedis.zinterstore("post:group:time", "post:createTime", "post:group:1"));
//		System.out.println(jedis.sunionstore("post:stat:0,1", "post:stat:0", "post:stat:1"));
//		System.out.println(jedis.scard("post:stat:0,1"));
//		System.out.println(jedis.scard("post:stat:0"));
//		System.out.println(jedis.scard("post:stat:1"));
//		User user = JSON.parseObject(jedis.get("user:11"), User.class);
//		
//		User user2 = JSON.parseObject(jedis.get("user:11"), User.class);
//		System.out.println(user == user2);
//		
//		System.out.println(user.equals(user2));
		
		
//		System.out.println(jedis.zinterstore("post:group:time", "post:createTime","post:stat:0,1","post:group:1"));
		for(int i =0; i<16 ;i++){
		      jedis.select(i);
		      System.out.println(jedis.flushDB());
		}
//		Set<String> set = jedis.zrange("post:topTime:area:330100001:group:1", 0, -1);
//		for(String ss : set){
//			System.out.println(ss);
//		}
//		jedis.hset("cacheInitUrl", "dynamicCache", "0");
//		Set<Tuple> set = jedis.zrangeWithScores("dynamic:pic:user:1akEUwdPBalUZGJtPBKEAB:area:330100001", 0, -1);
//		for(Tuple tuple : set){
//			System.out.println(tuple.getElement() + " "+ tuple.getScore());
//		}
//		System.out.println(jedis.zunionstore("user:focuss:8587", "user:followers:8587", "user:following:8587"));
//		System.out.println(jedis.hexists("tokenSysURL", "api/getUserInfo"));
//		Transaction tx = jedis.multi();
//		Response<Boolean> response = tx.hexists("user:phone", "1");
//		tx.exec();
//		System.out.println(response.get());
//		Set<String> postSet = jedis.keys("post:*");
//		System.out.println(postSet);
//		Object [] objs = postSet.toArray();
//		for(Object obj : objs){
//			System.out.println(obj);
//		}
//		for(int i =0 ;i<10; i++){
//			jedis.zadd("test", 1, "awsd"+i);
//		}
//		Set<Tuple> set = jedis.zrevrangeWithScores("action:area_topTime:330100006", 0, 1000);
//		for(Tuple tuple :set){
//			System.out.println(tuple.getElement()+" "+tuple.getScore());
//		}
//		Set<String> voteSet = jedis.zrange("voteOption:sort:vote:6", 0, - 1);
//		for(String tuple :voteSet){
//			System.out.println(tuple);
//		}
//		System.out.println(jedis.zscore("vote:count", "vote:6"));
//		System.out.println(jedis.zrange("post:gidCount:1", 0, -1));
//		jedis.set("杭州梦虎网络科技有限公司", "asdasd");
//		jedis.hset("杭州梦虎网络科技有限公司", "杭州梦虎网络科技有限公司2", "asdasd");
//		System.out.println(jedis.keys("*梦虎*"));
//		jedis.zadd("aaa", -999, "1");
//		System.out.println(jedis.zinterstore("aaa", "1"));
//		System.out.println(jedis.keys("parea:areaName:*"));
//		System. out .println("seq:"+jedis.incr("seq"));
//		System.out.println(SCRIPT);
//		
		pool.returnResource(jedis);
	}
}
