package it.unibo.aknightstale.models.entity;

import javafx.geometry.BoundingBox;
import javafx.geometry.Point2D;

public class Player extends BaseCharacter {

    static final double WIDTH_BOUNDS = 50.0;
    static final double HEIGHT_BOUNDS = 50.0;
    static final double DAMAGE = 25.0;
    static final double MAX_HEALTH = 100.0;
    static final double SPEED = 1.0;

    static final double ATTACK_RANGE = 5.0;

    public Player(final Point2D position) {
        super(new BoundingBox(position.getX(), position.getY(), WIDTH_BOUNDS, HEIGHT_BOUNDS), EntityType.PLAYER, true,
                Direction.RIGHT, DAMAGE, MAX_HEALTH, SPEED);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getAttackRange() {
        return ATTACK_RANGE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void attack(final LifeEntity e) {
        e.setHealth(e.getHealth() - this.getDamage());
    }

}
