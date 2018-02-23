import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Stopwatch class is for computes elapsed time between a start and stop time.
 * 
 * @author Vichakorn Yotboonrueang
 *
 */
public class Stopwatch {
	/**
	 * NANOSECOND will made a time to second.
	 */
	private static final double NANOSECOND = 1.0E-9;
	/**
	 * startTime and stopTime attribute made for count the time
	 */
	private long startTime = 0;
	private long stopTime = 0;
	private boolean running = false;

	/**
	 * reset the stopwatch and start if if stopwatch is not running. If the
	 * stopwatch is already running then start does nothing.
	 */
	public void start() {
		if (running)
			return;
		startTime = System.nanoTime();
		this.running = true;
	}

	/**
	 * stop the stopwatch. If the stopwatch is already stopped, then stop does
	 * nothing.
	 */
	public void stop() {
		if (!running)
			return;
		stopTime = System.nanoTime();
		this.running = false;
	}

	/**
	 * returns true if the stopwatch is running, false if stopwatch is stopped.
	 * 
	 * @return true if stopwatch is running otherwise false.
	 */
	public boolean isRunning() {
		return running;
	}

	/**
	 * (a) If the stopwatch is running, then return the time since start() until the
	 * current time. (b) If stopwatch is stopped, then return the time between the
	 * start and stop times.
	 * 
	 * @returnthe elapsed time in seconds.
	 * 
	 */
	public double getElapsed() {
		if (running)
			return (System.nanoTime() - startTime) * NANOSECOND;
		else
			return (stopTime - startTime) * NANOSECOND;
	}

}
