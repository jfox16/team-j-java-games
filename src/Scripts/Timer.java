package Scripts;

public class Timer
{
  private int endFrame;

  public Timer() {
    endFrame = 0;
  }

  public void set(int numFrames) {
    endFrame = Clock.getInstance().getNumFramesSinceStart() + numFrames;
  }

  public boolean isDone() {
    return Clock.getInstance().getNumFramesSinceStart() >= endFrame;
  }
}
