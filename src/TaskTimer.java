/**
 * This class is for compute and print the elapsed time for any task, without
 * any duplicate code.
 * 
 * @author Vichakorn Yotboonrueang
 *
 */
public class TaskTimer {
	/**
	 * runs a task, measures and prints its running time to the console.
	 * @param runnable for run any object that have been called.
	 */
	public static void measureAndPrint(Runnable runnable) {
		System.out.print(runnable);
		Stopwatch sw = new Stopwatch();
		sw.start();
		runnable.run();
		sw.stop();
		System.out.printf("%.6f sec\n", sw.getElapsed());
	}

}
