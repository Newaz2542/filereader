
public class TaskTimer {
	
	public static void measureAndPrint(Runnable runnable) {
		System.out.print(runnable);
		Stopwatch sw = new Stopwatch();
		sw.start();
		runnable.run();
		sw.stop();
		System.out.printf("%.6f sec\n",sw.getElapsed());
	}

}
