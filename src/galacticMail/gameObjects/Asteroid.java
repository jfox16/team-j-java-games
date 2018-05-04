package galacticMail.gameObjects;

import general.GameWorld;
import utility.AnimatedSprite;
import utility.MultiSprite;
import utility.RandomNumberGenerator;
import utility.Vector2;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Asteroid extends SpaceObject {
  private AnimatedSprite animatedSprite;

  public Asteroid(Vector2 position, double rotation) {
    super(position, 20);
    setRotation(rotation);
    moveSpeed = 1;

    BufferedImage spriteStrip = GameWorld.getInstance()
            .loadSprite("Asteroid_strip180.png");
    MultiSprite multiSprite = new MultiSprite(spriteStrip, 180);
    int animationFrameLength = RandomNumberGenerator.getRandomInt(1, 10);
    animatedSprite = new AnimatedSprite(multiSprite, animationFrameLength);
    animatedSprite.setLoop(true);
    animatedSprite.setReverse(RandomNumberGenerator.getRandomBoolean());
  }

  @Override
  public void drawSprite(Graphics graphics) {
    sprite = animatedSprite.getCurrentSprite();
    super.drawSprite(graphics);
  }
}
