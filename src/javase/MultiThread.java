package javase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class MultiThread {
	static Integer count = 0;

	void increment() {
		count = count + 1;
	}

	synchronized void incrementSync() {
		count = count + 1;
	}

	public static void stop(ExecutorService executor) {
		try {
			executor.shutdown();
			executor.awaitTermination(60, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			System.err.println("termination interrupted");
		} finally {
			if (!executor.isTerminated()) {
				System.err.println("killing non-finished tasks");
			}
			executor.shutdownNow();
		}
	}

	public static void sleep(int seconds) {
		try {
			TimeUnit.SECONDS.sleep(seconds);
		} catch (InterruptedException e) {
			throw new IllegalStateException(e);
		}
	}

	public void run() {
		ExecutorService executor = Executors.newFixedThreadPool(2);

		IntStream.range(0, 1000000).forEach(
				i -> executor.submit(this::incrementSync));

		stop(executor);

		System.out.println(count);
	}

	public static void main(String[] arg) {
		MultiThread multiThread = new MultiThread();
		multiThread.run();
	}

}
