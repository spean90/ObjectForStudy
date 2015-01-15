package ThreadQueue;

import java.util.LinkedList;
import java.util.Queue;

public class WorkThread {
	
	private Queue<String> taskQueue = new LinkedList<String>();
	
	public void addTask(String task) {
		synchronized (taskQueue) {
			taskQueue.add(task);
			taskQueue.notifyAll();
		}
	}
	
	public void start() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					synchronized (taskQueue) {
						try {
							if (taskQueue.size()==0) {
								System.out.println("没有代办任务：等待.....");
								taskQueue.wait();
							}else {
								String task = taskQueue.poll();
								System.out.println("获取了一个队列里的任务："+task);
								//为了方便观察过程、添加睡眠2秒
								Thread.sleep(2000);
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
						
					}
				}
			}
		}).start();
	}

}
