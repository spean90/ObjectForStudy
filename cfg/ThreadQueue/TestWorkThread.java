package ThreadQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestWorkThread {

	public static void main(String[] args) {
		WorkThread workThread = new WorkThread();
		for (int i = 0; i < 5; i++) {
			workThread.addTask("task "+i);
		}
		workThread.start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				String content = null;
				try {
					while (!(content=reader.readLine()).equals("bye")) {
						workThread.addTask(content);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}finally {
					try {
						reader.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}
}
