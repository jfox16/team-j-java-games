package Scripts;

public class TankExplosion extends GameObject implements ClockListener {

  private MultiSprite multiSprite;
  private int animationIndex = 0;
  private Timer animationTimer = new Timer();
  private int animationFrameLength = 5;

  public TankExplosion (Vector2 position) {
    super(position);
    multiSprite = new MultiSprite(GameWorld.loadSprite("Tank_explosion_strip19.png"), 19);
    sprite = multiSprite.getSubSprite(0);
    if (sprite != null) {
      this.position = Vector2.subtractVectors(position, new Vector2(sprite.getWidth()/2, sprite.getHeight()*(0.7)));
    }
  }

  public void update() {
    animate();
  }

  private void animate() {
    if (animationIndex < multiSprite.getNumSubSprites()) {
      if (animationTimer.isDone()) {
        sprite = multiSprite.getSubSprite(animationIndex);
        animationIndex++;
        animationTimer.set(animationFrameLength);
      }
    }
    else {
      sprite = null;
      die();
    }
  }
}
