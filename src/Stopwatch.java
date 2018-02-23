import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Stopwatch {
	private static final double NANOSECCON = 1.0E-9;
	private long startTime = 0;
	private long stopTime = 0;
	private boolean running = false;
	
	public void start() {
		if(running) return;
		startTime = System.nanoTime();
		this.running = true;
	}
	
	public void stop() {
		if(!running) return;
		stopTime = System.nanoTime();
		this.running = false;
	}
	
	public boolean isRunning() {
		return running;
	}
	
	public double getElapsed() {
		if(running) return (System.nanoTime() - startTime)*NANOSECCON;
		else return (stopTime - startTime)*NANOSECCON;
	}
	

	
}
