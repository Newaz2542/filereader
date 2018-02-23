
public class Main {

	public static void main(String[] args) {
		TaskTimer.measureAndPrint(new ReadByString());
		TaskTimer.measureAndPrint(new ReadByBufferedReader());
		TaskTimer.measureAndPrint(new ReadByReadBuilder());
	}

}
