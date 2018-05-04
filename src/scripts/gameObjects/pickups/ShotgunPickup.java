package scripts.gameObjects.pickups;

import scripts.gameObjects.Tank;
import scripts.gameWorlds.TankGameWorld;
import scripts.utility.Vector2;
import scripts.weapons.ShotgunWeapon;

public class ShotgunPickup extends Pickup {
  public ShotgunPickup(Vector2 position) {
    super(position, 4);
    TankGameWorld.getInstance().loadSound("weaponequip.wav");
  }

  @Override
  public void activatePickup(Tank tank) {
    tank.equip(new ShotgunWeapon());
    TankGameWorld.getInstance().playSound("weaponequip.wav");
    die();
  }
}
