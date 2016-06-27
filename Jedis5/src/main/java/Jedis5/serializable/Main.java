package Jedis5.serializable;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		BlockingQueue<Runnable> queue = new ArrayBlockingQueue<Runnable>(4); // 固定为4的线程队列
		ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 6, 1,
				TimeUnit.DAYS, queue, new Threadhandler());
		for (int i = 0; i < 10000; i++) {
			executor.execute(new ThreadPoolTest("TestThread".concat("" + i)));
			int threadSize = queue.size();
			System.out.println("线程队列大小为-->" + threadSize);
			if (threadSize == 4) {
				queue.put(new Runnable() {
					@Override
					public void run() {
						System.out.println("我是新线程，看看能不能搭个车加进去！");
					}
				});
			}
		}
		executor.shutdown();
	}
}

class ThreadPoolTest extends Thread {
	private String name;
	public ThreadPoolTest(String name){
		this.name = name;
	}

	@Override
	public void run() {
		synchronized (this) {
			try {
				System.out.println(Thread.currentThread().getName()+" "+name);
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}