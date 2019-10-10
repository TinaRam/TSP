/**
 * @author tinarambo
 * Class for measuring elapsed time
 */


import java.time.Duration;
import java.time.Instant;

public class TimeTracker {

	private Instant start;
	private Instant stop;
	private long elapsedMillis;
	private String formattedTime;

	public void startTimer() {
		start = Instant.now();
	}

	private long msFromStart() {
		return Duration.between(start, Instant.now()).toMillis();
	}

	public void stopTimer() {
		stop = Instant.now();
		elapsedMillis();
		formatElapsedTime(elapsedMillis);
	}

	private void elapsedMillis() {
		elapsedMillis = Duration.between(start, stop).toMillis();
	}

	private void formatElapsedTime(long ms) {
		formattedTime = (String.format("%02d:%02d:%02d:%02d", ms / 3600000, (ms % 3600000) / 60000, (ms % 60000) / 1000,
				(ms % 1000)));
	}

	public String getFormattedElapsedTime() {
		long ms = msFromStart();
		return (String.format("%02d:%02d:%02d:%02d", ms / 3600000, (ms % 3600000) / 60000, (ms % 60000) / 1000,
				(ms % 1000)));
	}

	public String getElapsedMs() {
		return "" + elapsedMillis;
	}

	public String getFormattedTimeTot() {
		return formattedTime;
	}
}
