package Scripts;

import javafx.beans.Observable;

import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class Clock implements Runnable
{
  private static Clock instance;
  private int numFramesSinceStart = 0;
  private CopyOnWriteArrayList<ClockObserver> clockObservers = new CopyOnWriteArrayList<>();
  private HashMap<ClockObserver, Boolean> addedClockObservers = new HashMap<>();
  private boolean stopped;
  private boolean paused;

  private static final long FRAME_LENGTH = 15;

  public Clock() {
    instance = this;
  }

  public static Clock getInstance() {
    return instance;
  }

  public void run() {
    while (!stopped) {
      if (!paused) {
        updateClockObservers();
        numFramesSinceStart++;
      }
      try {
          Thread.sleep(FRAME_LENGTH);
      } catch (Exception e) {
        // do catch stuff
      }
    }
  }

  public void addClockObserver(ClockObserver clockObserver) {
    if (!addedClockObservers.containsKey(clockObserver)) {
      clockObservers.add(clockObserver);
      addedClockObservers.put(clockObserver, true);
    }
  }

  public void removeClockObserver(ClockObserver clockObserver) {
    if (addedClockObservers.containsKey(clockObserver)) {
      clockObservers.remove(clockObserver);
      addedClockObservers.remove(clockObserver);
    }
  }

  public void stop() {
    stopped = true;
  }

  public void pressPause() {
    paused = !paused;
  }

  public boolean getPaused() {
    return paused;
  }
  public int getNumFramesSinceStart() {
    return numFramesSinceStart;
  }

  public void updateClockObservers() {
    for (ClockObserver _co : clockObservers) {
      _co.update();
    }
  }
}
